package com.huimin.distributedlock;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.huimin.util.LogUtil;

@Service
public class RedisDistributionLockImpl2 implements DistributionLock {

	private static LogUtil logger = LogUtil.logger(RedisDistributionLockImpl2.class);
	@Autowired
	private StringRedisTemplate redisTemplate;
	private ThreadLocal<String> lockFlag = new ThreadLocal<String>();
	private static final long LOCK_TIMEOUT = 5 * 1000;
	public static final String UNLOCK_LUA;

	static {
		StringBuilder sb = new StringBuilder();
		sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ")
		.append("then ").append("    return redis.call(\"del\",KEYS[1]) ")
		.append("else ").append("    return 0 ").append("end ");
		UNLOCK_LUA = sb.toString();
	}
	@Override
	public boolean lock(String lockKey) {
		boolean result = setRedis(lockKey, LOCK_TIMEOUT);
		// 如果获取锁失败，按照传入的重试次数进行重试
		while ((!result)) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				return false;
			}
			result = setRedis(lockKey, LOCK_TIMEOUT);
		}
		logger.info(Thread.currentThread().getName() + "加锁成功 ++++ 11111");
		return true;
	}

	@Override
	public void unlock(String lockKey) {
		// 释放锁的时候，有可能因为持锁之后方法执行时间大于锁的有效期，此时有可能已经被另外一个线程持有锁，所以不能直接删除
		try {
			// 使用lua脚本删除redis中匹配value的key，可以避免由于方法执行时间过长而redis锁自动过期失效的时候误删其他线程的锁
			// spring自带的执行脚本方法中，集群模式直接抛出不支持执行脚本的异常，所以只能拿到原redis的connection来执行脚本

			// 集群模式和单机模式虽然执行脚本的方法一样，但是没有共同的接口，所以只能分开执行
			// 集群模式
			Long result = redisTemplate.execute((RedisConnection redisConnection) -> {
				return redisConnection.eval(UNLOCK_LUA.getBytes(), ReturnType.INTEGER, 1, lockKey.getBytes(),
						lockFlag.get().getBytes());
			});
			if (result != null && result > 0) {
				logger.info(Thread.currentThread().getName() + "解锁成功------------------");
				return;
			}
			// return result != null && result > 0;
		} catch (Exception e) {
			logger.error("release lock occured an exception", e);
		}
		logger.info(Thread.currentThread().getName() + "解锁失败------------------");
	}

//	@Override
	public long currtTimeForRedis() {
		return redisTemplate.execute((RedisConnection redisConnection) -> {
			return redisConnection.time();
		});
	}

	private boolean setRedis(String key, long expire) {
		try {
			String uuid = UUID.randomUUID().toString();
			if (redisTemplate.execute( (RedisConnection c) -> {
				return c.setNX(key.getBytes(), uuid.getBytes());
			})) {
				// 设置超时时间，释放内存
				redisTemplate.expire(key, LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
				lockFlag.set(uuid);
				// 如果加锁成功
				//logger.info("加锁成功 ++++ 111111");
				return true;
			} else {
				Long exp = redisTemplate.getExpire(key);
				if (exp != null && exp.longValue() == -1) {
					// 说明该锁没有设置过期时间 为防止死锁 加上过期时间
					redisTemplate.expire(key, LOCK_TIMEOUT, TimeUnit.MILLISECONDS);
				}
			}
		} catch (Exception e) {
			logger.error("set redis occured an exception", e);
		}
		return false;
	}
}

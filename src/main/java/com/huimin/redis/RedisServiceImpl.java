package com.huimin.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
	private static Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public String get(String key) {
		try {
			Object value = redisTemplate.opsForValue().get(key);
			return value == null ? null : String.valueOf(value);
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	@Override
	public <T> T get(String key, Class<T> clazz) {
		try {
			return covernt(redisTemplate.opsForValue().get(key), clazz);
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	@Override
	public void set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public void set(String key, Object value, int seconds) {
		set(key, value, seconds, TimeUnit.SECONDS);
	}

	@Override
	public void multiSet(Map<String, Object> map) {
		if (map != null && !map.isEmpty()) {
			redisTemplate.opsForValue().multiSet(map);
		}
	}

	@Override
	public void set(String key, Object value, long timeout, TimeUnit timeUnit) {
		redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
	}

	@Override
	public boolean exist(String key) {
		return redisTemplate.hasKey(key);
	}

	@Override
	public void delete(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public Long getExpire(String key) {
		try {
			return redisTemplate.getExpire(key);
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	@Override
	public Long increment(String key, long delta) {
		return redisTemplate.opsForValue().increment(key, delta);
	}

	@Override
	public void add(String key, Object value) {
		redisTemplate.opsForList().leftPush(key, value);
	}

	@Override
	public void add(String key, List<Object> values) {
		redisTemplate.opsForList().leftPushAll(key, values);
	}

	@Override
	public <T> List<T> getList(String key, Class<T> clazz) {
		try {
			List<T> list = new ArrayList<>();
			List<Object> range = redisTemplate.opsForList().range(key, 0, -1);
			if (range == null || !range.isEmpty()) {
				range.forEach(action -> {
					list.add(covernt(action, clazz));
				});
			}
			return list;
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private <T> T covernt(Object value, Class<T> clazz) {
		return value == null ? null : (T) value;
	}

	@Override
	public void lpush(String key, String value) {
          redisTemplate.opsForList().leftPush(key, value);		
	}
}

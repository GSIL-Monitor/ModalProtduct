package com.huimin.effective.test;

import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

import com.huimin.enun.Sex;

public class EnumSetTest {

	@Autowired
	StringRedisTemplate s ;
	RedisTemplate<String, Object> redisTemplate;
	@Test
	public void test02() throws ClassNotFoundException {
	     ValueOperations<String, String> forValue = s.opsForValue();
	     ListOperations<String, String> opsForList = s.opsForList();
	     HashOperations<String, Object, Object> opsForHash = s.opsForHash();
	     SetOperations<String, String> opsForSet = s.opsForSet();
	     ZSetOperations<String, String> opsForZSet = s.opsForZSet();
	     BoundListOperations<String,String> boundListOps = s.boundListOps("");
	}
	@Test
	public void test01() throws ClassNotFoundException {
		System.out.println(Sex.FEMALE.getSql("student"));
		System.out.println(new Random().nextInt(100));
	}
}

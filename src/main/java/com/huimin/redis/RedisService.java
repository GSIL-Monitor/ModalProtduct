package com.huimin.redis;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface RedisService {

	public String get(String key);
	
	public <T> T get(String key, Class<T> clazz);
	
	public boolean exist(String key);
	
	public void delete(String key);
	
	public void set(String key, Object value);
	
	public void set(String key, Object value, int seconds);
	
	public void set(String key, Object value, long times, TimeUnit timeout);
	
	public void multiSet(Map<String, Object> map);
	
	public Long getExpire(String key);
	
	public Long increment(String key, long delta);
	
	public void add(String key, Object value);
	
	public void add(String key, List<Object> value);
	
	public <T> List<T> getList(String key, Class<T> clazz);
	
	public void lpush(String key, String value);
}

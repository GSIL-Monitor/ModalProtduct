package com.huimin.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 对json进行简单封装 项目中不直接依赖于某种JSON实现
 * @author ThinkPad
 *
 */
public class JsonUtil {

	/**
	 * 将对象转换为json字符串
	 * @param object
	 * @return
	 */
	public static String toJsonString(Object object) {
		return JSON.toJSONString(object);
	}
	
	/**
	 * 
	 * @param text
	 * @param clazz
	 * @return
	 */
	public static <T> T parseObject(String text, Class<T> clazz){
		return JSON.parseObject(text, clazz);
	}
	
	/**
	 * 
	 * @param text
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> parseArray(String text, Class<T> clazz){
		return JSON.parseArray(text, clazz);
	}
	
	/**
	 * 
	 * @param text
	 * @return
	 */
	public static Map<String, Object> parseMap(String text){
		return JSON.parseObject(text);
	}
}

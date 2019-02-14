package com.huimin.elasticsearch.common;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.search.SearchHits;

import com.alibaba.fastjson.JSON;
import com.huimin.elasticsearch.annotation.Document;
import com.huimin.elasticsearch.annotation.Id;

public class ElasticsearchUtil {


	public static <T>  String getIndexName(T t) {
		return getDocument(t).indexName();
	}
	public static <T>  String getType(T t) {
		return getDocument(t).type();
	}
	public static <T>  String getId(T t) {
		Field[] declaredFields = t.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			if (field.getAnnotation(Id.class) != null) {
				field.setAccessible(true);
				Object id;
				try {
					id = field.get(t);
					return id == null ? null : id.toString();
				} catch (IllegalArgumentException | IllegalAccessException e) {
				}
			}
		}
	    throw new ElasticsearchException();
	}
	
	public static<T> Document getDocument(T t) {
		Document document = t.getClass().getAnnotation(Document.class);
		if (document == null) {
			throw new ElasticsearchException();
		}
		return document;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T covert(String json, T t){
		return (T) JSON.parseObject(json, t.getClass());
	}
	
	public static<T> Map<String, Object> getSource(T t) {
		Map<String, Object> source = new HashMap<>();
		Field[] declaredFields = t.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			try {
				String filedName = field.getName();
				if ("serialVersionUID".equals(filedName)) {
					//序列化号不保存
					continue;
				}
				Object obj = field.get(t);
				if (obj != null) {
					source.put(filedName, obj);
				}
			} catch (Exception e) {
			}
		}
		return source;
	}
	public static<T> List<T> handleHits(SearchHits hits, T t) {
		List<T> results = new ArrayList<>();
		hits.forEach(action -> {
			results.add(covert(action.getSourceAsString(), t));
		});
		return results;
	}
}

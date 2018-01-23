package com.huimin.effective.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class TypeTest {

	@Test
	public void test03() {
		
	}
	@Test
	public void test02() {
		Faviter faviter = new Faviter();
		faviter.put(String.class, "hhhhh");
		faviter.put(Integer.class, 11111111);
		faviter.put(Long.class, 1111L);
		String string = faviter.get(String.class);
		Integer integer = faviter.get(Integer.class);
		Long long1 = faviter.get(Long.class);
		System.out.println(string);
		System.out.println(integer);
		System.out.println(long1);
	}
	@Test
	public void test01() {
		List<String> listS = new ArrayList<>();
		List<Object> listO = new ArrayList<>();
		List<?> list2 = new ArrayList<>();
		List list = new ArrayList();
		list.add(listS);
		listO.add(listS);
		//listS.add(listO);
		HashMap<Class<?>,Object> hashMap = new HashMap<Class<?>, Object>();
	}
}


class Faviter{
	private  HashMap<Class<?>,Object> hashMap = new HashMap<>();
	
	public <T> void put(Class<T> type, T instance) {
		hashMap.put(type, instance);
	}
	public <T> T get(Class<T> type) {
		return type.cast(hashMap.get(type));
	}
}
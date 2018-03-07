package com.huimin.java8;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.Assert;

import com.huimin.entity.Student;

public class BaseTest {

	@Test
	public void test05() throws Exception {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		String join = StringUtils.join(ids, ",");
		System.out.println(join);
	}
	@Test
	public void test04() throws Exception {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("cmd.exe /c tasklist");
		InputStream inputStream = process.getInputStream();
		Scanner scanner = new Scanner(inputStream);
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			System.out.println(nextLine);
		}
		scanner.close();
		//终止进程
		// runtime.exec("taskkill /F /IM firefox.exe");
		runtime.exec("D:\\devolopsoftware\\tool\\firfox\\firefox.exe");
	}
	@Test
	public void test03() {
		Assert.notNull("", "");
		Assert.isInstanceOf(Object.class, new Object());
		Assert.isAssignable(Object.class, String.class);
	}
	@Test
	public void test02() {
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < 5000000; i++) {
			Student student = new Student();
			student.setId(i);
			students.add(student);
		}
		long start = System.currentTimeMillis();
		Map<Integer, Student> map1 = new HashMap<>();
				students.parallelStream()
				.forEach(student -> {
					map1.put(student.getId(), student);
				});
		
		long start2 = System.currentTimeMillis();
		System.out.println("time ------>" + (start2 - start));
		System.out.println("--------------------------------------------");
		Map<Integer, Student> map2 = new HashMap<>();
		long start3 = System.currentTimeMillis();
		for (Student student : students) {
			map2.put(student.getId(), student);
		}
		long start4 = System.currentTimeMillis();
		System.out.println("time ------>" + (start4 - start3));
	}
	@Test
	public void test01() {
		long nanoTime = System.nanoTime();
		//System.out.println(currentTimeMillis);
		System.out.println(nanoTime);
		Properties properties = System.getProperties();
		Map<String, String> getenv = System.getenv();
		long start = System.currentTimeMillis();
		properties.forEach((Key, value) -> {
			System.out.println(Key + " ----> " + value);
		});
		getenv.forEach((Key, value) -> {
			System.out.println(Key + " ----> " + value);
		});
		properties.forEach((Key, value) -> {
			System.out.println(Key + " ----> " + value);
		});
		getenv.forEach((Key, value) -> {
			System.out.println(Key + " ----> " + value);
		});
		properties.forEach((Key, value) -> {
			System.out.println(Key + " ----> " + value);
		});
		getenv.forEach((Key, value) -> {
			System.out.println(Key + " ----> " + value);
		});
		properties.forEach((Key, value) -> {
			System.out.println(Key + " ----> " + value);
		});
		getenv.forEach((Key, value) -> {
			System.out.println(Key + " ----> " + value);
		});
		long start2 = System.currentTimeMillis();
		System.out.println("time ------>" + (start2 - start));
		System.out.println("--------------------------------------------");
	
		for (Entry<Object, Object> entry : properties.entrySet()) {
			System.out.println(entry.getKey() + " ----> " + entry.getKey());
		}
		for (Entry<String, String> entry : getenv.entrySet()) {
			System.out.println(entry.getKey() + " ----> " + entry.getKey());
		}
		for (Entry<Object, Object> entry : properties.entrySet()) {
			System.out.println(entry.getKey() + " ----> " + entry.getKey());
		}
		for (Entry<String, String> entry : getenv.entrySet()) {
			System.out.println(entry.getKey() + " ----> " + entry.getKey());
		}
		for (Entry<Object, Object> entry : properties.entrySet()) {
			System.out.println(entry.getKey() + " ----> " + entry.getKey());
		}
		for (Entry<String, String> entry : getenv.entrySet()) {
			System.out.println(entry.getKey() + " ----> " + entry.getKey());
		}
		long start3 = System.currentTimeMillis();

		System.out.println("time ------>" + (start3 - start2));

	}
}

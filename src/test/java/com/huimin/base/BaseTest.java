package com.huimin.base;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class BaseTest {

	@Test
	public void test06() throws Exception{
		String string = new SQL(){{
			SELECT("abc,bgh");
			FROM("aaaa");
			WHERE("x > 10");
		}}.toString();
		System.out.println(string);
	}
	@Test
	public void test05() throws Exception{
	//	HashMap<K, V>
		System.out.println(1 << 30);
		System.out.println(Math.pow(2, 30));
	}
	@Test
	public void test04() throws Exception{
		URL url = new URL("http://newehr-api.beta.huimin100.cn:28102/ehr_api/rest/generation/system/getRoleByUserId");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(HttpMethod.POST.name());
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write("user_id=20000&ctime=&1514430643936&nonce=QANsS465K9k37gS6odpW&sign=a695fab8e0a0420483dae7ca559cbb989ec6d21777a0ef4240141180176f3668".getBytes());
		outputStream.flush();
		outputStream.close();
		
		InputStream inputStream = connection.getInputStream();
		StringBuilder result = new StringBuilder();
		BufferedReader breader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
		String str;
		while ((str = breader.readLine()) != null) {
			result.append(str);
		}
		breader.close();
		inputStream.close();
		System.out.println(result.toString());
	}
	@Test
	public void test03(){
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		System.out.println(list);
		
		list.remove(1);
		System.out.println(list);
		
	}
	@Test
	public void test02(){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1222);
		list.add(122);
		list.add(12);
		
		Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		set.addAll(list);
		System.out.println(set);
	}
	
	@Test
	public void test01() throws Exception{
        PasswordEncoder passwordEncoder= new Pbkdf2PasswordEncoder();
        String encode = passwordEncoder.encode("admin");
        System.out.println(encode);
	}
}

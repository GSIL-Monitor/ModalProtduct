package com.huimin.base;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import com.huimin.entity.Student;
import com.huimin.util.HttpClientUtils;
import com.huimin.util.LogUtil;


public class BaseTest {

	@Test
	public void test4() throws Exception{
		LogUtil.logger(this).info("id = {}, age = {}", 1, 12);;
	}
	@Test
	public void test3() throws Exception{
		String property = System.getProperty("user.timezone");
		System.out.println(property);
	}
	@Test
	public void test2() throws Exception{
		ClassLoader classLoader = this.getClass().getClassLoader();
		String name = "com.huimin.entity.Student";
		Class<?> loadClass = classLoader.loadClass(name);
		Field[] declaredFields = loadClass.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field.getName());
		}
	}
	@Test
	public void test1() throws Exception{
//		Scanner scanner = new Scanner(System.in);
//		String nextLine = scanner.nextLine();
//		System.out.println(nextLine);
//		scanner.close();
		System.out.println(jiecheng(3));
	}
	
	public int jiecheng(int n) {
		if (n == 1) {
			return 1;
		}
		return n * jiecheng(n - 1);
	}
	@Test
	public void test0() throws Exception{
		Student student = new Student();
		student.setId(1);
		student.setAge(2);
		Student student2 = new Student();
		student2.setId(2);
		student2.setAge(2);
		Student student3 = new Student();
		student3.setId(3);
		student3.setAge(2);
		List<Student> students = new ArrayList<>();
		students.add(student3);
		students.add(student2);
		students.add(student);
		student.setId(4);
		students.add(student);
		System.out.println(students);
		Set<Integer> keySet =
				students.stream().collect(Collectors.toMap(Student::getId, Function.identity())).keySet();
		System.out.println(keySet);
	}
	
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
	public void test15() throws Exception{
		String url = "http://www.baidu.com?a=zhangsan&b=5&c=9";
		System.out.println(HttpClientUtils.doGet(url));
	}
	@Test
	public void test10() throws Exception{
		Map<String, Object> params = new HashMap<>();
		params.put("user_id", 20000);
		params.put("ctime", 1514430643936L);
		params.put("nonce", "QANsS465K9k37gS6odpW");
		params.put("sign", "a695fab8e0a0420483dae7ca559cbb989ec6d21777a0ef4240141180176f3668");
		String url = "http://newehr-api.beta.huimin100.cn:28102/ehr_api/rest/generation/system/getRoleByUserId";
		System.out.println(HttpClientUtils.doPost(url, params));
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
		Set<Integer> set2 = new TreeSet<>(Comparator.comparing(Integer::intValue));
		
		set.addAll(list);
		set2.addAll(list);
		System.out.println(set);
		System.out.println(set2);
	}
	
	@Test
	public void test01() throws Exception{
        PasswordEncoder passwordEncoder= new Pbkdf2PasswordEncoder();
        String encode = passwordEncoder.encode("admin");
        System.out.println(encode);
	}
}

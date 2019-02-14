package com.huimin.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huimin.entity.Student;
import com.huimin.entity.security.Role;
import com.huimin.util.CollectionUtil;
import com.huimin.util.DateUtil;
import com.huimin.util.EncryptUtil;
import com.huimin.util.HttpClientUtils;
import com.huimin.util.LogUtil;
import com.huimin.util.SHA256Verify;
import com.huimin.util.Sha256SignUtil;
import com.huimin.util.ZipUtils;


public class BaseTest {
	
	private static LogUtil logger = LogUtil.logger(BaseTest.class);
	public Logger log = LoggerFactory.getLogger(BaseTest.class);

	public static String NEW_LINE = System.getProperty("line.separator");
	@Test
	public void test52() throws Exception {
		Properties properties = System.getProperties();
		properties.forEach((key, value) -> {
			System.out.println(key + "--->" + value);
		});
	}
	@Test
	public void test51() throws Exception {
		Properties properties = System.getProperties();
		properties.forEach((key, value) -> {
			System.out.println(key + "--->" + value);
		});
	}
	@Test
	public void test50() throws Exception {
		String str = "黄金叶(七彩装)";
		// 清除掉所有特殊字符
		String regEx =  ".*[`~!@#$%^&*+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\\\]+.*";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		System.out.println(m.matches());
	}
	@Test
	public void test49() throws Exception {
		ZipUtils.unzip2("C:\\Users\\ThinkPad\\Desktop\\response.zip", "C:\\Users\\ThinkPad\\Desktop\\");
	}
	@Test
	public void test48() throws Exception {
		System.out.println(File.separator);
	}
	@Test
	public void test47() throws Exception {
		System.out.println(NEW_LINE);
		String[] strs = {"落霞与孤鹜齐飞", "秋水共长天一色"};
		//简写如下：
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File("C:\\Users\\ThinkPad\\Desktop\\test.txt")), "UTF-8"));
		for (String string : strs) {
			writer.write(string + NEW_LINE); 
		}
		writer.close();
	}
	@Test
	public void test46() {
		BigDecimal bigDecimal = new BigDecimal("1");
		System.out.println(bigDecimal.setScale(0,BigDecimal.ROUND_HALF_UP));
		if(bigDecimal.setScale(0,BigDecimal.ROUND_HALF_UP).compareTo(new BigDecimal(9999999)) > 0){
			System.out.println(111111);
		}
		System.out.println(22222222);
	}

	@Test
	public void test45() {
		List<Integer> items = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			items.add(i);
		}
		if (CollectionUtil.isNotEmpty(items )) {
			//防止数据过多导致失败  所以分批更新
			int batchSize = 5;
			int size = items.size();
			int count = size % batchSize == 0 ? size / batchSize : size / batchSize + 1;
			for (int i = 1; i <= count; i++) {
				if (size / batchSize >= i) {
					System.out.println(items.subList((i - 1) * batchSize, i * batchSize));
				}else {
					System.out.println(items.subList((i - 1) * batchSize, size));
				}
			}
		}
		
	}
	@Test
	public void test44() {
		List<String> markets = new ArrayList<>();
		markets.add("369460");
		markets.add("553370");
		markets.add("553374");
		System.out.println(markets.contains("369460"));
		
	}
	@Test
	public void test43() {
		String itemNo = "11111111";
		String itemSubno = "222222";
		log.info("多规格处理库存，商品货号：" + itemNo  + ",条形码" + itemSubno );
		logger.info("多规格处理库存，商品货号：" + itemNo  + ",条形码" + itemSubno );
	}
	@Test
	public void test42() {
		String a = "abc";
		String b = new String("abc");
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(a == b.intern());
	}
	@Test
	public void test41() {
		BigDecimal rq =  new BigDecimal(2);
		BigDecimal vp = new BigDecimal(20.00);
		System.out.println(rq.multiply(vp));
	}
	@Test
	public void test40() {
		List<Student> parseArray = JSON.parseArray(null, Student.class);
		List<Student> parseArray2 = JSON.parseArray("[]", Student.class);
		System.out.println(parseArray);
	}
	@Test
	public void test39() {
		String a = null;
		logger.info(a);
	}
	@Test
	public void test38() {
		JSONObject parseObject = JSONObject.parseObject(null);
		System.out.println(parseObject);
		
	}
	@Test
	public void test37() {
		Map<String, String> params = new HashMap<>();
		params.put("userId", "12345");
		params.put("userName", "诸葛亮");
		String key = "1111111111111";
		Map<String, String> sign = Sha256SignUtil.sign(params, key);
		System.out.println(sign);
		//sign.remove("sign");
		System.out.println(SHA256Verify.verifyRequest(sign, key));;
	}
	@Test
	public void test36() {
		System.out.println(Integer.parseInt("0000879"));
	}
	@Test
	public void test35() {
		Date parse = DateUtil.parse("2018-04-23");
		System.out.println(parse.compareTo(new Date()));
	}
	@Test
	public void test34() {
		Date parse = DateUtil.parse("2018-04-23");
		System.out.println(parse.compareTo(new Date()));
	}
	@Test
	public void test33() {
		String md5 = EncryptUtil.md5("123456");
		System.out.println(md5);
	}
		@Test
		public void test32() {
	
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(22);
		list.add(21);
		list.add(23);
		list.add(24);
		list.add(25);
		list.add(26);
		List<Integer> subList = list.subList(0, 6);
		System.out.println(list);
		System.out.println(subList);
	}
		@Test
		public void test31() {
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < 5000; i++) {
			students.add(new Student(i % 100, "张三" + i, i));
		}
		
		long start = System.currentTimeMillis();
		Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getId));
		//System.out.println(list);
		long start2 = System.currentTimeMillis();
		System.out.println(start2 - start);
		map = new HashMap<>();
		for (Student student : students) {
			List<Student> list = map.get(student.getId());
			if (list == null) {
				list = new ArrayList<>();
				list.add(student);
				map.put(student.getId(), list);
			}else {
				list.add(student);
			}
		}
		long start3 = System.currentTimeMillis();
		System.out.println(start3 - start2);
	}
	@Test
	public void test30() {
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < 500000; i++) {
			students.add(new Student(i, "张三" + i, i));
		}
		
		long start = System.currentTimeMillis();
		List<Integer> list = students.stream().map(Student::getId)
				.collect(Collectors.toList());
		//System.out.println(list);
		long start2 = System.currentTimeMillis();
		System.out.println(start2 - start);
		list = new ArrayList<>();
		for (Student student : students) {
			list.add(student.getId());
		}
		long start3 = System.currentTimeMillis();
		System.out.println(start3 - start2);
	}
	
		@Test
		public void test14() {
		Student student = new Student(1, "张三", 12);
		String jsonString = JSON.toJSONString(student);
		JSONReader jsonReader = new JSONReader(new StringReader(jsonString));
		JSONObject readObject = jsonReader.readObject(JSONObject.class);
		jsonReader.close();
		System.out.println(readObject);
	}
		@Test
		public void test13() {
		/*JSONArray jsonArray = new JSONArray();
		jsonArray.add("1");*/
		/*
	     * 实体带查询使用方法  输出看结果
	     */
		EntityWrapper<Role> wrapper = new EntityWrapper<>();
	    wrapper.like("aaa", "www")
	    .andNew("b = {0} or c = {1}", 1, 2);
	    System.out.println(wrapper.getSqlSegment());
	}
	@Test
	public void test12() {
		String url = "http://www.easybots.cn/api/holiday.php";
		Map<String, Object> params = new HashMap<>();
		params.put("d", "20180101");
		String doGet = HttpClientUtils.doGet(url, params);
		System.out.println(doGet);
	}
	@Test
	public void test11() {
		
		String[] keysAndArgsn = {"1", "2"};
		String[] range = Arrays.copyOfRange(keysAndArgsn , 0, 1);
		System.out.println(range.length);
	}
	@Test
	public  void test09() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "诸葛亮", 12));
		students.add(new Student(1, "张飞", 24));
		students.add(new Student(1, "关羽", 56));
		students.add(new Student(2, "孙权", 34));
		students.add(new Student(2, "周瑜", 45));
		students.add(new Student(2, "鲁肃", 12));
		students.add(new Student(3, "曹操", 46));
		students.add(new Student(3, "郭嘉", 45));
		students.add(new Student(3, "典韦", 44));
		
		Map<Integer, List<Student>> map = students.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.groupingBy(Student::getId));
		System.out.println(map);
//		map.forEach((key, value) -> {
//			value.stream().sorted(Comparator.comparing(Student::getName));
//		});
		System.out.println(map);
	}  
	
	@Test
	public void test8() throws Exception{
//		URL url = new URL("http://www.zhuliang2.test.com:9010/test/");
//		System.out.println(url.getAuthority());
//		System.out.println(url.getHost());
		TreeSet<Student> set = new TreeSet<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		Student student = new Student();
		student.setAge(10);
		Student student2 = new Student();
		student2.setAge(1);
		Student student3 = new Student();
		student3.setAge(15);
		set.add(student);
		set.add(student3);
		set.add(student2);
		Integer age = set.first().getAge();
		System.out.println(age);
	}
	@Test
	public void test7() throws Exception{
        Pattern pattern = Pattern.compile("/*");
        Matcher matcher = pattern.matcher("/jsjjs/jjs");
        System.out.println(matcher.matches());
		Set<String> keys = new HashSet<>();
		keys.add("1111111111");
		keys.add("1111111112");
		keys.add("1111111113");
		keys.add("1111111114");
		Set<String> collect = keys.stream().map(key -> ("sso-" + key)).collect(Collectors.toSet());
		System.out.println(collect);
	}
	
	@Test
	public void test6() throws Exception{
		System.out.println(System.currentTimeMillis() - 1522310129941L);
	}
	@Test
	public void test16() throws Exception{
		Map<String, Object> param = new HashMap<>();
		param.put("title","get_store_user");
		Map<String, Object> param2 = new HashMap<>();
		//param2.put("id", 2);
		param.put("params", param2);
		String jsonResult =  HttpClientUtils.doPostJson("http://bi.alpha.huimin100.cn:8888",param );
	System.out.println(jsonResult);
	}
	@Test
	public void test5() throws Exception{
		Header[] headers = new Header[2] ;
		headers[0] = new BasicHeader("userToken", "a2e3a30b-9097-42ba-9af5-1460a131d00c1");
		headers[1] = new BasicHeader("uuidToken", "997e1c6b-de08-4896-b653-a23603e5ded71");
		String string = HttpClientUtils.doPost("http://www.zhuliang1.test.com:9001/test", null, "UTF-8", headers );
		System.out.println(string);
	}
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
	@Test
	public void test20() throws Exception{
		System.out.println(DateUtil.plus(1).compareTo(DateUtil.endOfDay(new Date())));
	}
}

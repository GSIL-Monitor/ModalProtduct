//package com.huimin.java8.combat;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.Test;
//
//import com.huimin.util.HttpClientUtils;
//
//public class AppleTest {
//	@Test
//	public void test21() {
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		list.add(6);
//		list.add(7);
//		list.add(8);
//	    spilt(list);
//	}
//	
//	public void spilt(List<Integer> list) {
//		if (list.size() > 2) {
//			List<Integer> subList1 = list.subList(0, list.size() / 2);
//			List<Integer> subList2 = list.subList(list.size() / 2, list.size());
//			spilt(subList2);
//		    spilt(subList1);
//		}else {
//			System.out.println("size: " + list.size() + "=======" + list);
//		}
//	}
//	@Test
//	public void test20() {
//		Stream.builder().add(1).add("ddff").build()
//		.forEach(System.out::println);
////		Stream.generate(() -> new Random().nextInt(100))
////		.limit(20)
////		.forEach(System.out::println);
//	}
//	@Test
//	public void test19() {
//		Stream.generate(() -> new Random().nextInt(100))
//		.limit(20)
//		.forEach(System.out::println);
//	}
//	@Test
//	public void test18() {
//		// 0 1  1 1 1 2 2 3 3 5 5 8
//		Stream.iterate(new int[] {0, 1} , (a)-> {
//			int[] arr = new int[2];
//			arr[0] = a[1];
//			arr[1] = a[0] + a[1];
//			return arr;
//		})
//		.limit(20)
//		.map(a -> a[0])
//		.forEach(System.out::println);
//	}
//	@Test
//	public void test17() {
//		Stream.iterate(LocalDate.now(), AppleTest::plus)
//		.limit(100)
//		.forEach(System.out::println);
//	}
//	
//	public static LocalDate plus(LocalDate localDate) {
//		return localDate.plusDays(1);
//	}
//	@Test
//	public void test16() {
//		Stream.iterate(0, n -> n+2)
//		.limit(100)
//		.forEach(System.out::println);
//	}
//	@Test
//	public void test15() {
//		try {
//			Files.lines( Paths.get("D:\\workspace\\cms\\ModalProtduct\\src\\main\\resources\\application.yml"))
//			.forEach(System.out::println);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void test14() {
//		//(5, 12, 13)、(6, 8, 10)和(7, 24, 25)
//		List<Integer> asList1 = Arrays.asList(3,12,13);
//		List<Integer> asList2 = Arrays.asList(4,8,10);
//		List<Integer> asList3 = Arrays.asList(5,24,25);
//		List<String> collect = asList1.stream().flatMap(num1 -> asList2.stream()
//				.flatMap(num2 -> asList3.stream()
//						.filter(num3 -> num1 *num1 + num2 *num2 == (int) num3 *num3)
//						.map(num3 -> "(" + num1 +","+ num2 +","+ num3 +")")))
//		.collect(Collectors.toList());
//		System.out.println(collect);
//	}
//	@Test
//	public void test13() {
//		List<String> asList = Arrays.asList("abc","def","jui","loki");
//		String string = asList.stream().reduce(String::concat).get();
//		System.out.println(string);
//	}
//	@Test
//	public void test12() {
//		Apple reduce = apples().stream().reduce(Apple::reduce).get();
//		System.out.println(reduce);
//	}
//	@Test
//	public void test11() {
//		
//		List<Integer> asList = Arrays.asList(3,45,566,3,2,44,5,11,6,7,0,8,11,8,9);
//		//int init = asList.get(0);
//		Integer reduce = asList.stream().reduce(Integer::max).get();
//		Integer reduce2 = asList.stream().max(Integer::compareTo).get();
//		Integer reduce3 = asList.stream().max(Comparator.comparing(Integer::intValue)).get();
//		System.out.println(reduce);
//		System.out.println(reduce2);
//		System.out.println(reduce3);
//	}
//	@Test
//	public void test10() {
//		apples().stream().filter(apple -> apple.getWeight() >= 100)
//		.findAny().ifPresent(a -> {
//			System.out.println(a);
//		});
//	}
//	@Test
//	public void test09() {
//		List<Integer> nums1 = Arrays.asList(1,2,3);
//		List<Integer> nums2 = Arrays.asList(3,4);
//		List<String> combine = nums1.stream().flatMap( num1 -> nums2.stream()
//				.filter(num2 -> (num1 + num2) %3 == 0)
//				.map(num2 -> "(" + num1 + "," + num2 + ")"))
//				.collect(Collectors.toList());
//		
//		System.out.println(combine);
//	}
//	@Test
//	public void test08() {
//		List<Integer> nums1 = Arrays.asList(1,2,3);
//		List<Integer> nums2 = Arrays.asList(4,5);
//		List<String> combine = nums1.stream().flatMap( num1 -> nums2.stream()
//				.map(num2 -> "(" + num1 + "," + num2 + ")"))
//		.collect(Collectors.toList());
//		
//		System.out.println(combine);
//	}
//	@Test
//	public void test07() {
//		Apple apple = apples().get(0);
//		Map<String, Object> map = new HashMap<>();
//		map.put("key", "测试");
//		map.put("apple", apple);
//		//map = JSON.parseObject(JSON.toJSONString(map));
//		String doPost = HttpClientUtils.doGet("https://www.baidu.com/", map);
//		System.out.println(doPost);
//	}
//	@Test
//	public void test05() {
//		List<Apple> apples = apples();
//		apples.sort(Comparator.comparing(Apple :: getWeight).reversed());
//		System.out.println(apples);
//	}
//	
//	@Test
//	public void test04() {
//		Function<Integer, Apple> c2 = Apple::new;//(w) -> new Apple(6,"",w,"");
//		Apple a2 = c2.apply(110);
//		System.out.println(a2);
//	}
//	@Test
//	public void test03() {
//		List<String> asList = Arrays.asList("a","v","m","p");
//		asList.sort(String::compareToIgnoreCase);
//		System.out.println(asList);
//	}
//	@Test
//	public void test02() {
//		Integer a  = 1;
//		Integer b  = 1;
//		System.out.println(a==b);
//	}
//	@Test
//	public void test01() {
//		List<Apple> filterApple = PredicateServiceImpl.filterApple(apples(), (a) -> a.getWeight() > 50);
//		System.out.println(filterApple);
//		List<Apple> filterApple2 = PredicateServiceImpl.filterApple(apples(), (a) -> a.getColor().equals("red"));
//		System.out.println(filterApple2);
//		System.out.println(PredicateServiceImpl.covernt(apples(), (Apple a) -> a.getWeight()));
//	}
//	public List<Apple> apples(){
//		Apple apple1 = new Apple(1, "red", 100, "红富士");
//		Apple apple2 = new Apple(2, "yellow", 150, "红富士");
//		Apple apple3 = new Apple(3, "green", 10, "红富士");
//		Apple apple4 = new Apple(4, "blank", 80, "红富士");
//		Apple apple5 = new Apple(5, "red", 50, "红富士");
//		List<Apple> apples = new ArrayList<>();
//		apples.add(apple2);
//		apples.add(apple1);
//		apples.add(apple3);
//		apples.add(apple4);
//		apples.add(apple5);
//		return apples;
//	}
//}

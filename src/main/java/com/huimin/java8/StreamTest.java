package com.huimin.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;



public class StreamTest {

	@Test
	public void test27() {
		
		artists().stream().collect(Collectors.groupingBy(Artist::getName,Collectors.groupingBy(Artist::getName)))
		.forEach((key, value) -> {
			value.forEach((key2, v2) -> {
				
			});
		});
	}
	@Test
	public void test26() {
		Assert.assertEquals(10, 10);
		Assert.assertEquals(10, 9);
		Assert.assertNotNull(null);
	}
	@Test
	public void test25() {
//		Stream<Integer> flatMap = artists().stream().flatMap(artist -> artist.getMembers().stream()
//				.map(artis -> artis.getAge()));
		int sum = artists().stream().flatMap(artist -> artist.getMembers().stream()
				.map(artis -> artis.getAge())).mapToInt(age -> age).sum();
		System.out.println(sum);
	}
	@Test
	public void test24() {
		ThreadLocal<Artist> threadLocal = ThreadLocal.withInitial(() ->{
			Artist artist = new Artist();
			artist.setAge(1000);
			return artist;
			});
		System.out.println(threadLocal.get().getAge());
	}
	@Test
	public void test23() {
		Integer[] arrays = new Integer[10];
		Arrays.parallelSetAll(arrays, i -> i );
		System.out.println(Arrays.asList(arrays));
	}
	@Test
	public void test22() {
//		int[] array = IntStream.range(0, 10).toArray();
//		for (int i : array) {
//			System.out.println(i);
//		}
//		artists().forEach(action -> {
//			
//		});
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
	
	@Test
	public void test21() {
		Map<String, Integer> map = new HashMap<>();
		map.put("test", 1);
		map.put("test2", 2);
		map.put("test3", 3);
		map.put("test4", 4);
		map.forEach((key, value) -> {
			System.out.println(key + "=" + value);
		});
		
		map.forEach((key, value) -> {
			System.out.println(key + "=" + value);
		});
		
	}
	@Test
	public void test20() {
	    String collect = artists().stream().map(Artist::getName).collect(Collectors.joining(",", "{", "}"));
		System.out.println(collect);
	}
	@Test
	public void test19() {
 Map<Boolean, List<Artist>> collect = artists().stream().collect(Collectors.groupingBy(artist -> artist.getAge() == 2));
		System.out.println(collect);
	}
	@Test
	public void test18() {
		Map<Boolean, List<Artist>> collect = artists().stream().collect(Collectors.partitioningBy(artist -> artist.getAge() > 2));
		System.out.println(collect);
	}
	@Test
	public void test17() {
		Function<Artist, Integer> aa = stre -> stre.getAge();
		Artist artist = artists().stream().collect(Collectors.maxBy(Comparator.comparing(aa))).get();
		System.out.println(artist);
	}
	@Test
	public void test16() {
		Stream<String> map = artists().stream().map(Artist::getName);
		System.out.println(map.collect(Collectors.toList()));
	}
	@Test
	public void test15() {
		int[] arry = {1,2,3,4,5};
		IntSummaryStatistics summaryStatistics = IntStream.of(arry).summaryStatistics();
		System.out.println(summaryStatistics.getSum());
	}
	@Test
	public void test14() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		IntSummaryStatistics summaryStatistics = list.stream().mapToInt(l -> l).summaryStatistics();
		System.out.println(summaryStatistics.getSum());
	}
	@Test
	public void test13() {
		IntStream intStream = artists().stream().mapToInt(artist -> artist.getAge());
		System.out.println(intStream);
		IntSummaryStatistics summaryStatistics = intStream.summaryStatistics();
		
		System.out.println(summaryStatistics);
		System.out.println(summaryStatistics.getMax());
		System.out.println(summaryStatistics.getMin());
		System.out.println(summaryStatistics.getCount());
		System.out.println(summaryStatistics.getSum());
	}
	@Test
	public void test12() throws Exception {
		byte[] decode = Base64.getUrlDecoder().decode("inHdWMy9XQ3NSduCKfZ1OKB5NwmKqZKPIj7eYx6YGlV3fJ3CJgUHptVSg6lXAxkQ5EZgaxGyyOz4MUAzKLZIgg==");
		System.out.println(new String(decode, "utf-8"));
	//	artists().stream().reduce((a,b) -> a.getName() + b.getName());
	}
	@Test
	public void test11() {
		long count = artists().stream().map(men -> men.getMembers().size())
				.reduce(0,(a,b) -> a+b);
		System.out.println(count);
	}
	@Test
	public void test10() {
		System.out.println(names(artists().stream()));
	}
	public List<String> names(Stream<Artist> ar){
		return ar.map(men -> men.toString()).collect(Collectors.toList());
	}
	@Test
	public void test09() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		System.out.println(sum(list.stream()));
	}
	
	
	public int sum(Stream<Integer> members) {
		return members.reduce(0, (a , b) -> a + b);
	}
	@Test
	public void test08() {
		List<Artist> artists = artists();
		List<String> names = artists.stream().
		flatMap(artist -> artist.getMembers().stream()
				.filter(member -> member.getAge() > 2)
				.map(member -> member.getName()))
		      .collect(Collectors.toList());
		System.out.println(names);
		
	}
	/**
	 * 处理双层循坏
	 */
	@Test
	public void test07() {
		List<String> list = new ArrayList<>();
		List<Artist> artists = artists();
		artists.stream().
		forEach(artist -> artist.getMembers().stream()
				.filter(menber -> menber.getAge() > 2)
				.map(mapper -> mapper.getName())
				.forEach(name -> list.add(name)))
		;
		System.out.println(list);
	}
	@Test
	public void test06() {
		List<Artist> artists = artists();
		artists.forEach(artist -> {
			if (artist.getAge() < 3) {
				artist.setAge(10);
			}
		});
		System.out.println(artists);
	}
	@Test
	public void test05() {
		List<Artist> artists = artists();
		Set<String> collect = artists.stream().map(artist -> artist.getName()).collect(Collectors.toSet());
		System.out.println(collect);
	}
	@Test
	public void test04() {
		int count = Stream.of(1, 2, 3)
				.reduce(0, (acc, element) -> acc + element);
	    System.out.println(count);
	}
	@Test
	public void test03() {
		List<Artist> artists = artists();
		Artist artist2 = artists.stream().min(Comparator.comparing(Artist::getAge)).get();
		System.out.println(artist2);
	}
	@Test
	public void test02() {
		List<Artist> artists = artists();
		List<Artist> collect = artists.stream().filter(artist -> artist.getOrigin().equals("北京")).collect(Collectors.toList());
		System.out.println(collect);
		
	}
	@Test
	public void test01() {
		List<Artist> artists = artists();
		long count = artists.stream().filter(artist -> artist.getOrigin().equals("北京")).count();
		System.out.println(count);
	}
	
	
	@Test
	public void test30() {
		artists().stream().reduce(null, (a, aa)->{
			return aa;
		});
	}
	
	public List<Artist> artists(){
		List<Artist> artists = new ArrayList<>();
		Artist artist = new Artist();
		artist.setName("张三");
		artist.setOrigin("北京");
		artist.setAge(1);
		Artist artist2 = new Artist();
		artist2.setName("李四");
		artist2.setOrigin("上海");
		artist2.setAge(2);
		Artist artist3 = new Artist();
		artist3.setName("诸葛亮");
		artist3.setOrigin("南阳");
		artist3.setAge(3);
		Artist artist4 = new Artist();
		artist4.setName("周瑜");
		artist4.setOrigin("江东");
		artist4.setAge(4);
		artists.add(artist4);
		artists.add(artist3);
		artists.add(artist2);
		artists.add(artist);
		artist.setMembers(artists);
		artist2.setMembers(artists);
		artist3.setMembers(artists);
		artist4.setMembers(artists);
		return artists;
	}
}

package com.huimin.java8.combat;
/**
 * 用于测试  不提供借口
 * @author zhuliang
 *
 * @Date 2018年1月30日下午2:38:30
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PredicateServiceImpl {

	public static <T> List<T> filterApple(List<T> list, Predicate<T> predicate){
		return list.stream().filter(t -> predicate.test(t))
				.collect(Collectors.toList());
	}
	
	public static <T, R> List<R> covernt(List<T> list, Function<T, R> function){
		List<R> covernt = new ArrayList<>();
		list.forEach(action -> {
			covernt.add(function.apply(action));
		});
		return covernt;
	}
}

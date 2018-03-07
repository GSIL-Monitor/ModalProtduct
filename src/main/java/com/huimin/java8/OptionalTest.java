package com.huimin.java8;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.huimin.java8.combat.Apple;
import com.huimin.java8.combat.Orchard;

public class OptionalTest {

	@Test
	public void test04() {
		
	}
	@Test
	public void test03() {
		
	}
	@Test
	public void test02() {
		Assert.assertEquals(500, 500);
	}
	@Test
	public void test01() {
		Orchard orchard = new Orchard();
		orchard.setNanme("苹果园");
		orchard.setPosition("北京");
//		Apple apple = new Apple(1, "red", 100, "红苹果");
//		orchard.setApple(apple);
//		orchard.setApple(null);
		System.out.println(JSON.toJSONString(orchard));
		String orElse = orchard.appleAsOptional().map(Apple::getName).orElse("hahahahha");
		System.out.println(orElse);
	}
}

package com.huimin.effective.test;

import java.util.Random;

import org.junit.Test;

import com.huimin.enun.Sex;

public class EnumSetTest {

	@Test
	public void test02() throws ClassNotFoundException {
	}
	@Test
	public void test01() throws ClassNotFoundException {
		System.out.println(Sex.FEMALE.getSql("student"));
		System.out.println(new Random().nextInt(100));
	}
}

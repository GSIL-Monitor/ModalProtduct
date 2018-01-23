package com.huimin.effective.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.huimin.effective.BuilderTest;

public class TestBuilder {
 
	@Test
	public void test02() {
		//BigInteger bigInteger = BigInteger.ONE;
		Integer[] arrys = new Integer[10];
		arrys[1]  = 10;
	    List<Integer> asList1 = Arrays.asList(arrys);
	    List<Integer> asList =new ArrayList<>();
	    asList.addAll(asList1);
	    System.out.println(asList);
	    asList.removeAll(Collections.singleton(null));
	    System.out.println(asList);
	    Integer[] array = asList.toArray(new Integer[asList.size()]);
	    System.out.println(Arrays.toString(array));
	}
	@Test
	public void test01() {
		
		BuilderTest clone;
		BuilderTest builderTest = BuilderTest.create().age(11).brithday(new Date()).id(1).name("张三").builder();
		System.out.println(JSON.toJSONString(builderTest));
		try {
			clone = builderTest.clone();
			System.out.println(JSON.toJSONString(clone));
			
			System.out.println(clone == builderTest);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

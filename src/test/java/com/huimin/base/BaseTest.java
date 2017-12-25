package com.huimin.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class BaseTest {

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

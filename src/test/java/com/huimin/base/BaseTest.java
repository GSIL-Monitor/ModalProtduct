package com.huimin.base;

import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class BaseTest {

	@Test
	public void test01() throws Exception{
        PasswordEncoder passwordEncoder= new Pbkdf2PasswordEncoder();
        String encode = passwordEncoder.encode("admin");
        System.out.println(encode);
	}
}

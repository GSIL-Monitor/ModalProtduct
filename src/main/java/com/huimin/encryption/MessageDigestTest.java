package com.huimin.encryption;

import java.security.MessageDigest;

import org.junit.Test;

public class MessageDigestTest {

	@Test
	public void test01() throws Exception {
		byte[] bytes = "sha".getBytes();
		MessageDigest digest = MessageDigest.getInstance("SHA");
		digest.update(bytes);
		byte[] digest2 = digest.digest();
		System.out.println(new String(digest2));
	}
}

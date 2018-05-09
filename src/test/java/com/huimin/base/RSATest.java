package com.huimin.base;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.huimin.util.Base64;
import com.huimin.util.RSAUtil;
import com.huimin.util.RSAUtils;

public class RSATest {

	@Test
	public void test04() throws Exception {
		Map<String, String> map = new HashMap<>(4);
		map.put("qqq", "qqq");
		map.put("qqq1", "qqq");
		System.out.println(map);
	}
	@Test
	public void test03() throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i =0; i < 10; i++) {
			stringBuilder.append("abc");
		}
		String str = stringBuilder.toString();
		System.out.println(str.length());
		String encryptByPrivateKey = RSAUtil.encryptByPrivateKey(str);
		System.out.println(encryptByPrivateKey);
		System.out.println(encryptByPrivateKey.length());
		System.out.println(RSAUtil.decryptByPublicKey(encryptByPrivateKey));
		
		String encryptByPublicKey = RSAUtil.encryptByPublicKey(str);
		System.out.println(encryptByPublicKey);
		System.out.println(encryptByPublicKey.length());
		System.out.println(RSAUtil.decryptByPrivateKey(encryptByPublicKey));
	}
	@Test
	public void test01() throws Exception {
		Map<String, Object> genKeyPair = RSAUtils.genKeyPair();
		String str = "test rsa good or not good";
		byte[] encryptByPrivateKey = RSAUtils.encryptByPrivateKey(str.getBytes(), RSAUtils.getPrivateKey(genKeyPair));
		String publicKey = RSAUtils.getPublicKey(genKeyPair);
		System.out.println("---->" + publicKey);
		System.out.println(Base64.decode(publicKey));
		String encode = Base64.encode(encryptByPrivateKey);
		System.out.println(encode);
		System.out.println(Base64.decode(encode));
		byte[] decryptByPublicKey = RSAUtils.decryptByPublicKey(encryptByPrivateKey, RSAUtils.getPublicKey(genKeyPair));
		System.out.println(new String(decryptByPublicKey));
	}
}

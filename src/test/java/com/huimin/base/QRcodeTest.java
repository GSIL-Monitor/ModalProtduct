package com.huimin.base;

import org.junit.Test;

import com.huimin.qrcode.QRcode;

public class QRcodeTest {

	@Test
	public void test02() throws Exception{
		String decode = QRcode.decode("C:/Users/ThinkPad/Desktop/21907676.jpg");
		System.out.println(decode);
	}
	@Test
	public void test01(){
		try {
			QRcode.encode("http://192.168.106.56:20000/swagger-ui.html#!/promotion-activity-controller/singleProductDiscountsCreateUsingPOST", "C:/Users/ThinkPad/Desktop/logo.png", "C:/Users/ThinkPad/Desktop");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

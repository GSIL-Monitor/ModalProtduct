package com.huimin.designpattern.proxy;

public class MySinger implements ISinger/*, ISinger2*/{

	@Override
	public void sing() {
		System.out.println("唱歌");
	}

//	@Override
//	public void eat() {
//       System.out.println("吃饭");		
//	}

}

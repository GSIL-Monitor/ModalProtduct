package com.huimin.designpattern.proxy.statics;

import com.huimin.designpattern.proxy.ISinger;
import com.huimin.designpattern.proxy.MySinger;

public class ISingerProxy implements ISinger{

	private ISinger iSinger;
	public ISingerProxy(ISinger iSinger) {
		this.iSinger = iSinger;
		
	}
	@Override
	public void sing() {
		System.out.println("开始执行方法");
		iSinger.sing();
		System.out.println("执行方法");
	}
	public static void main(String[] args) {
		new ISingerProxy(new MySinger()).sing();
	}

}

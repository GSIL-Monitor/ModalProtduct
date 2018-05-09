package com.huimin.designpattern.adapterPattern;

public class AdapterTest {

	public static void main(String[] args) {
		RocketSim rocketSim = new RocketAdapet(10);
		rocketSim.setTime(10);
		System.out.println(rocketSim.getMass());
		
		SkyRocket skyRocket = new SkyPocketAdapter(10);
		skyRocket.setTime(10);
		System.out.println(skyRocket.getMass());
	}
}

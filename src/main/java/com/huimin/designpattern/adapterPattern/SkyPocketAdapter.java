package com.huimin.designpattern.adapterPattern;

/**
 * 基于类的适配器 这种适配方式比基于接口的更加脆弱
 * @author zhuliang
 *
 * @Date 2018年4月28日上午10:28:03
 */
public class SkyPocketAdapter extends SkyRocket{

	private PhysicalRocket physicalRocket;
	public SkyPocketAdapter(PhysicalRocket physicalRocket) {
		this.physicalRocket = physicalRocket;
	}
	public SkyPocketAdapter(double fluemass) {
		physicalRocket = new PhysicalRocket();
		physicalRocket.setFuelMass(fluemass);
	}
	
	@Override
	double getMass() {
		return physicalRocket.fuelMass(getTime());
	}
}

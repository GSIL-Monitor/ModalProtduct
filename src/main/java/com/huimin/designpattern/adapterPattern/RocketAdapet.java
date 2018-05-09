package com.huimin.designpattern.adapterPattern;

/**
 * 适配器模式 实现类  将PhysicalRocket中的方法 是适配到接口RocketSim中  这种属于子类适配器
 * 基于接口的适配器
 * @author zhuliang
 *
 * @Date 2018年4月28日上午9:56:26
 */
public class RocketAdapet extends PhysicalRocket implements RocketSim{

	private  double time;
	
     public RocketAdapet(double fluemass) {
		super.setFuelMass(fluemass);
	}
	@Override
	public double getMass() {
		return fuelMass(time);
	}
	
	@Override
	public void setTime(double time) {
		this.time = time;
	}
	

}

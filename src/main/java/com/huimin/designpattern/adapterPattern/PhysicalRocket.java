package com.huimin.designpattern.adapterPattern;

public class PhysicalRocket {

	private double fuelMass;
	
	public double fuelMass(double time) {
		return this.fuelMass * time;
	}
	public double getFuelMass() {
		return fuelMass;
	}
	public void setFuelMass(double fuelMass) {
		this.fuelMass = fuelMass;
	}
	
}

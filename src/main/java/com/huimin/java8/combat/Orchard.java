package com.huimin.java8.combat;

import java.util.Optional;

public class Orchard {

	private String nanme;
	private String position;
	private Apple apple;
	
	
	public String getNanme() {
		return nanme;
	}
	public void setNanme(String nanme) {
		this.nanme = nanme;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	public Apple getApple() {
		return apple;
	}
	public void setApple(Apple apple) {
		this.apple = apple;
	}
	public Optional<Apple> appleAsOptional(){
		return Optional.ofNullable(apple);
	}
	@Override
	public String toString() {
		return "Orchard [nanme=" + nanme + ", position=" + position + ", apple=" + apple + "]";
	}
	
	
}

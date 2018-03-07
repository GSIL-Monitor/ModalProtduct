package com.huimin.java8.combat;

public class Apple {

	private Integer id;
	private String color;
	private Integer weight;
	private String name;
	
	public Apple() {
	}
	public Apple(Integer weight) {
		this.weight = weight;
	}
	public Apple(Integer id, String color, Integer weight, String name) {
		super();
		this.id = id;
		this.color = color;
		this.weight = weight;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Apple [id=" + id + ", color=" + color + ", weight=" + weight + ", name=" + name + "]";
	}
	
	public Apple reduce(Apple apple) {
		Apple apple2 = new Apple();
		apple2.setWeight(this.weight + apple.getWeight());
		return apple2;
	};
}

package com.huimin.effective.test;

import java.util.Date;

import org.junit.Test;

public class ExtendTest {

	@Test
	public void test02(){
		Date date = new Date();
		java.sql.Date date2 = new java.sql.Date(date.getTime());
		  System.out.println(date);
		  System.out.println(date2);
	}
	@Test
	public void test01(){
		Chrildren chrildren = new Chrildren();
		chrildren.setAge(10);
		chrildren.setName("张三");
		chrildren.setSchool("哈哈哈");
		System.out.println(chrildren);
		System.out.println(chrildren.getAge());
	}
}
class Parent{
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Parent [age=" + age + ", name=" + name + "]";
	}
	
}

class Chrildren extends Parent{
	private int age;
	private String school;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Chrildren [age=" + age + ", school=" + school + "]";
	}
	
}
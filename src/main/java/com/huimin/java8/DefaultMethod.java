package com.huimin.java8;

public class DefaultMethod {

	public static void main(String[] args) {
		new Per().method();
		
		Animal.test();
	}
}

interface Animal{
	public static void test() {
		System.out.println("test");
	}
	default void method() {
		System.out.println("animal");
	}
}
interface Botany{
	default void method() {
		System.out.println("botany");
	}
}

class Per implements Animal, Botany {

	@Override
	public void method() {
		Botany.super.method();
	}
	
}
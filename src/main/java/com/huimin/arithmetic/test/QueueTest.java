package com.huimin.arithmetic.test;

import com.huimin.arithmetic.MyQueue;

public class QueueTest {
  public static void main(String[] args) {
	MyQueue<Integer> queue = new MyQueue<>(10);
	for (int i =0; i < 10; i++) {
		queue.put(i);
	}
	System.out.println(queue.getSize());
	System.out.println("-------------------------------");
	System.out.println(queue.deque());
	queue.put(100);
	System.out.println(queue.getSize());
	queue.put(100);
 }
}

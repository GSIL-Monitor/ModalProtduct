package com.huimin.arithmetic.test;

import org.junit.Test;

import com.huimin.arithmetic.MyQueue;
import com.huimin.arithmetic.PriorityQueue;

public class QueueTest {
	
	@Test
	public void test02(){
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		priorityQueue.put(1);
		priorityQueue.put(2);
		priorityQueue.put(3);
		priorityQueue.put(4);
		while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.deque());			
		}
		
	}
	
 @Test
  public  void main() {
	MyQueue<Integer> queue = new MyQueue<>(10);
	for (int i =0; i < 10; i++) {
		queue.put(i);
	}
	while (!queue.isEmpty()) {
        System.out.println(queue.deque());			
	}
 }
}

package com.huimin.java8.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import org.junit.Test;


public class ThreadTest {

	@Test
	public void test01() throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService threadPool = Executors.newFixedThreadPool(1);
		Future<Integer> future = threadPool.submit(() -> {
			System.out.println("异步操作操作开始");
			return IntStream.iterate(0, a -> a+1)
			.limit(1001)
			.sum();
		});
		
		System.out.println("同步操作结束");
		System.out.println("异步执行结果: " + future.get(10, TimeUnit.SECONDS));
		threadPool.shutdown();
	}
}

package com.huimin.netty.nio1;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable{

	private int port;
	
	private CountDownLatch countDownLatch;
	private AsynchronousServerSocketChannel asynchronousServerSocketChannel;
	
	public AsyncTimeServerHandler(int port) {
		this.port = port;
		try {
			asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
		    asynchronousServerSocketChannel.bind(new InetSocketAddress(this.port));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	@Override
	public void run() {
		countDownLatch = new CountDownLatch(1);
		doAccept();
		try {
			countDownLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void doAccept() {
		asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
	}
	public AsynchronousServerSocketChannel getAsynchronousServerSocketChannel() {
		return asynchronousServerSocketChannel;
	}
	public void setAsynchronousServerSocketChannel(AsynchronousServerSocketChannel asynchronousServerSocketChannel) {
		this.asynchronousServerSocketChannel = asynchronousServerSocketChannel;
	}
	public CountDownLatch getCountDownLatch() {
		return countDownLatch;
	}
	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

}

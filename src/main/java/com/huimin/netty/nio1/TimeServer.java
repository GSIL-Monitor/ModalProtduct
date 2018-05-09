package com.huimin.netty.nio1;

public class TimeServer {

	public static void main(String[] args) {
		Integer port = 8080;
		MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(port);
		new Thread(multiplexerTimeServer, "NIO-TIMESERVER-001").start();
	}
}

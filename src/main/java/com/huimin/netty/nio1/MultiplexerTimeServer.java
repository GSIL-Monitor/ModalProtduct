package com.huimin.netty.nio1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class MultiplexerTimeServer implements Runnable {

	private Selector selector;

	private ServerSocketChannel serverSocketChannel;

	private volatile boolean stop = false;

	/**
	 * 初始化多路复用器 绑定监听端口
	 */

	public MultiplexerTimeServer(int port) {
		try {
			this.selector = Selector.open();
			this.serverSocketChannel = ServerSocketChannel.open();
			this.serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("timeServer start in port :" + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		stop = true;
	}

	@Override
	public void run() {
		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectedKeys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext()) {
					key = iterator.next();
					iterator.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		if (selector != null) {
			try {
				selector.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void handleInput(SelectionKey key) throws IOException {
		if (key.isValid()) {
			if (key.isAcceptable()) {
				ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
				SocketChannel socketChannel = serverSocketChannel.accept();
				socketChannel.configureBlocking(false);
				socketChannel.register(selector, SelectionKey.OP_READ);
			}

			if (key.isReadable()) {
				SocketChannel channel = (SocketChannel) key.channel();
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				int read = channel.read(buffer);
				if (read > 0) {
					buffer.flip();
					byte[] bytes = new byte[buffer.remaining()];
					buffer.get(bytes);
					String body = new String(bytes, "utf-8");
					System.out.println("the time serverreceive ordder :" + body);
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
							? new Date(System.currentTimeMillis()).toString()
							: "BADE ORDER";
					doWrite(channel, currentTime);
				} else if (read < 0) {
					key.cancel();
					channel.close();
				} else {
					// 读到字节0忽略
				}
			}
		}
	}

	private void doWrite(SocketChannel socketChannel, String response) throws IOException {
		if (StringUtils.isNoneBlank(response)) {
			byte[] bytes = response.getBytes();
			ByteBuffer allocate = ByteBuffer.allocate(bytes.length);
			allocate.put(bytes);
			allocate.flip();
			socketChannel.write(allocate);
		}
	}
}

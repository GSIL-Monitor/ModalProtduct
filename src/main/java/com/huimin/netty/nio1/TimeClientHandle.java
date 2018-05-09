package com.huimin.netty.nio1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClientHandle implements Runnable{

	private String host;
	private int port;
	private  Selector selector;
	private SocketChannel socketChannel;
	private volatile boolean stop;
	
	public TimeClientHandle(String host, int port) {
	  this.host = host == null ? "127.0.0.1" : host;
	  this.port = port;
	  try {
		selector = Selector.open();
		socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	@Override
	public void run() {
		try {
			doConnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		while (!stop) {
			try {
				selector.select(1000);
			    Set<SelectionKey> keys = selector.selectedKeys();
			    Iterator<SelectionKey> iterator = keys.iterator();
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
				System.exit(1);
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
			SocketChannel socketChannel = (SocketChannel) key.channel();
		    if (key.isConnectable()) {
				if (socketChannel.finishConnect()) {
					socketChannel.register(selector, SelectionKey.OP_READ);
				    doWrite(socketChannel);
				}else {
					System.exit(1);
				}
			}
		    
		    if (key.isReadable()) {
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				int read = socketChannel.read(buffer);
				
				if (read > 0) {
					buffer.flip();
					byte[] bytes = new byte[buffer.remaining()];
				    buffer.get(bytes);
				    String body = new String(bytes, "utf-8");
				    System.out.println("NOW is : " + body);
				    this.stop = true;
				}else if (read < 0) {
					key.cancel();
					socketChannel.close();
				}
			}
		}
	}
	
	private void doConnect() throws IOException {
		if (socketChannel.connect(new InetSocketAddress(host, port))) {
			socketChannel.register(selector, SelectionKey.OP_READ);
		    doWrite(socketChannel);
		}else {
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
		}
	}
	
	private void doWrite(SocketChannel socketChannel) throws IOException {
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer byteBuffer = ByteBuffer.allocate(req.length);
		byteBuffer.put(req);
		byteBuffer.flip();
		socketChannel.write(byteBuffer);
		if (!byteBuffer.hasRemaining()) {
			System.out.println("send order 2 success");
		}
	}
}

package com.huimin.netty.nio1;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer>{

	private AsynchronousSocketChannel asynchronousSocketChannel;
	
	public ReadCompletionHandler(AsynchronousSocketChannel socketChannel) {
	
		if (this.asynchronousSocketChannel == null) {
			asynchronousSocketChannel = socketChannel;
		}
	
	}
	@Override
	public void completed(Integer result, ByteBuffer attachment) {
		attachment.flip();
		byte[] bytes = new byte[attachment.remaining()];
		attachment.get(bytes);
		try {
			String req = new String(bytes, "utf-8");
			System.out.println("the timeServer receive order : " + req);
			String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req) ? new Date().toString() : "BAD ORDER";
		    doWrite(currentTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void failed(Throwable exc, ByteBuffer attachment) {
		try {
			asynchronousSocketChannel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doWrite(String time) {
		if (StringUtils.isNoneBlank(time)) {
			byte[] bytes = time.getBytes();
			ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
			buffer.put(bytes);
			buffer.flip();
			asynchronousSocketChannel.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
				@Override
				public void completed(Integer result, ByteBuffer attachment) {
					if (buffer.hasRemaining()) {
						asynchronousSocketChannel.write(buffer, buffer, this);
					}
				}
				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					try {
						asynchronousSocketChannel.close();
					} catch (Exception e) {
					}
				}
			});
		}
	}
}

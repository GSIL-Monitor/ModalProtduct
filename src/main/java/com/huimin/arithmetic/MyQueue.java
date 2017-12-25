package com.huimin.arithmetic;

/**
 * 自己用数组实现一个环绕队列数据结构 用于处理先进先出的问题
 * 
 * @author zhuliang
 *
 * @date 2017年12月23日
 */
public class MyQueue<T> {

	// 队列数组
	private Object[] queue;
	// 队列头部位置 默认为-1
	private int front = -1;
	// 队列尾的位置
	private int rear = -1;

	private int maxSize = 100;
	// 队列中元素的个数
	private int size = 0;

	public MyQueue() {
		queue = new Object[maxSize];
	}

	// 吐出队列的第一个元素
	public T deque() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		// 队头环绕移动
		if (front == maxSize) {
			front = 0;
		}
		size--;
		return corvent(queue[front++]);
	}

	public void put(T t) {
		if (isFull()) {
			throw new RuntimeException("队列已满");
		}
		// 到了队尾 则队尾环绕到队头
		if (++rear == maxSize) {
			rear = 0;
		}
		queue[rear] = t;
		if (isEmpty()) {
			front = rear;
		}
		size++;
	}

	public T peekFront() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return corvent(queue[front]);
	}

	public MyQueue(int size) {
		this.maxSize = size;
		queue = new Object[maxSize];
	}

	@SuppressWarnings("unchecked")
	protected T corvent(Object o) {
		return (T) o;
	}

	public boolean isEmpty() {
		return size <= 0;
	}

	public boolean isFull() {
		return size >= maxSize;
	}

	public int getSize() {
		return size;
	}

}

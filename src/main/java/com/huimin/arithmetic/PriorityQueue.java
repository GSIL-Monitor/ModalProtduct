package com.huimin.arithmetic;

/**
 * 优先级队列 不在环绕了 用于测试 不适用继承抽象
 * 
 * @author zhuliang
 *
 * @date 2017年12月23日
 */
public class PriorityQueue<T extends Comparable<T>> {
	// 队列数组
	private Object[] queue;
	// 队列头部位置 默认为-1
	private int front = -1;

	private int maxSize = 100;
	// 队列中元素的个数
	private int size = 0;

	public PriorityQueue() {
		queue = new Object[maxSize];
	}

	public PriorityQueue(int size) {
		this.maxSize = size;
		queue = new Object[maxSize];
	}

	// 吐出队列的第一个元素
	public T deque() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		size--;
		return corvent(queue[front--]);
	}

	public void put(T t) {
		if (isFull()) {
			throw new RuntimeException("队列已满");
		}
        queue[++front] = t;
        selectSort();
		size++;
	}

	public T peekFront() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return corvent(queue[front]);
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

	/**
	 * 选择排序法 由于队列始终是有序的 顾采用插入排序法
	 */
	private void selectSort() {
		int min = front;
		T temp = corvent(queue[front]);
		while (min > 0 && corvent(queue[min - 1]).compareTo(temp) > 0) {
			queue[min] = queue[min - 1];
			--min;
		}
		queue[min] = temp;
	}

}

package com.huimin.arithmetic;

/**
 * 
 * @author zhuliang
 *
 * @date 2017年12月25日
 */
public class OneWayLink<T> {
	
	private OneWayLink<T> next;
	
	private T data;
	
	public OneWayLink(T data){
		this.data = data;
	}
	public OneWayLink(){
	}
	
	public boolean hasNext(){
		return next != null;
	}
	
	public void put(T t){
		if (getData() == null) {
			this.data = t;
			return;
		}
		OneWayLink<T> next = this;
		while(next.hasNext()){
			next = next.getNext();
		}
		next.next = new OneWayLink<T>(t);
	}

	public OneWayLink<T> getNext() {
		return next;
	}

	public T getData() {
		return data;
	}
	
	
}


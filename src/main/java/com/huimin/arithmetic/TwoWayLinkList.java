package com.huimin.arithmetic;

import java.util.Iterator;

public class TwoWayLinkList<T> {

	private Link<T> first;
	
	private Link<T> last; 
	
	public void add(T elem){
		Link<T> link = new Link<>(elem, null, null);
		if (isEmpty()) {
			first = link;
			last = link;
		}else{
			link.pre = last;
			last.next = link;
			last = link;
		}
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	
	public Link<T> getFirst() {
		return first;
	}

	public void setFirst(Link<T> first) {
		this.first = first;
	}

	public Link<T> getLast() {
		return last;
	}

	public void setLast(Link<T> last) {
		this.last = last;
	}

	public Iterator<T> iterate() {
		return new Iterate<>(first);
	}
	public InvertedOrder<T> invertedOrder() {
		return new InvertedOrder<>(last);
	}

	private class Iterate<E> implements Iterator<E> {
		private Link<E> link;

		public Iterate(Link<E> link) {
			this.link = link;
		}

		@Override
		public boolean hasNext() {
			return link != null;
		}

		@Override
		public E next() {
			if (link == null) {
				return null;
			}
			E data = link.elem;
			link = link.next;
			return data;
		}

	}
	public class InvertedOrder<E> {
		private Link<E> link;
		
		public InvertedOrder(Link<E> link) {
			this.link = link;
		}
		
		public boolean hasPre() {
			return link != null;
		}
		
		public E pre() {
			if (link == null) {
				return null;
			}
			E data = link.elem;
			link = link.pre;
			return data;
		}
		
	}

	private class Link<E> {
		private E elem;
		private Link<E> pre;
		private Link<E> next;

		public Link(E elem, Link<E> pre, Link<E> next) {
			this.elem = elem;
			this.pre = pre;
			this.next = next;
		}
	}
}

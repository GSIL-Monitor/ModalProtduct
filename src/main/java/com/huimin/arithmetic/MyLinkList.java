package com.huimin.arithmetic;

import java.util.Iterator;

/**
 * 自己实现的链表集合
 * 
 * @author zhuliang
 *
 * @date 2017年12月25日
 */
public class MyLinkList<T> {
	private Link<T> frist;
	private Link<T> last;
	private int size;

	public void addFrist(T t) {
		Link<T> link = new Link<T>(t);
		if (isEmpty()) {
			frist = link;
		} else {
			link.next = frist;
			frist = link;
		}
		size++;
	}

	public T removeFirst() {
		T data = frist.getData();
		if (frist.hasNext()) {
			frist = frist.getNext();
		} else {
			frist = null;
		}
		size--;
		return data;
	}

	public T find(T t) {
		Link<T> current = frist;
		while (current != null) {
			if (current.getData().equals(t)) {
				return t;
			}
			current = current.next;
		}
		return null;
	}

	public T remove(T t) {
		Link<T> current = frist;
		Link<T> pervious = frist;
		if (frist.data.equals(t)) {
			frist = frist.next;
			return t;
		} else {
			current = current.next;
		}
		while (current != null) {
			T data = current.data;
			// pervious = current;
			if (data.equals(t)) {
				pervious.next = current.next;
				size--;
				return t;
			} else {
				pervious = current;
			}
			current = current.next;
		}
		return null;
	}

	// public T removeLast(){
	// Link<T> current = frist;
	// Link<T> pervious = null;
	// while (current.hasNext()) {
	// pervious = current;
	// current = current.getNext();
	// }
	// if (pervious == null) {
	// frist = null;
	// }else {
	// pervious.next = null;
	// }
	// size--;
	// return current.getData();
	// }
	public T removeLast() {
		T data = last.getData();
		if (frist == last) {
			frist = null;
			last = null;
		} else {
			Link<T> current = frist;
			while (current.hasNext()) {
				if (current.next == last) {
					current.next = null;
					last = current;
				} else {
					current = current.next;
				}
			}
		}
		size--;
		return data;
	}

	// public void add(T t) {
	// if (isEmpty()) {
	// frist = new Link<T>(t);
	// } else {
	// Link<T> next = frist;
	// while (next.hasNext()) {
	// next = next.getNext();
	// }
	// next.next = new Link<T>(t);
	// }
	// size++;
	// }
	public void add(T t) {
		Link<T> link = new Link<T>(t);
		if (isEmpty()) {
			frist = link;
			last = link;
		} else {
			last.next = link;
			last = link;
		}
		size++;
	}

	public boolean isEmpty() {
		return frist == null;
	}

	public Link<T> frist() {
		return frist;
	}

	public Link<T> last() {
		return last;
	}

	public int size() {
		return size;
	}

	public void setFrist(Link<T> frist) {
		this.frist = frist;
	}

	public Iterator<T> iterate() {
		return new Iterate<>(frist);
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
			E data = link.getData();
			link = link.next;
			return data;
		}

	}

	private class Link<E> {

		private Link<E> next;

		private E data;

		public Link(E data) {
			this.data = data;
		}

		public boolean hasNext() {
			return next != null;
		}

		public Link<E> getNext() {
			return next;
		}

		public E getData() {
			return data;
		}
	}
}

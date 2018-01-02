package com.huimin.arithmetic;

/**
 * 普通二叉树
 * 
 * @author zhuliang
 *
 * @date 2017年12月27日
 */
public class TreeList<T extends Comparable<T>> {

	protected Tree<T> tree;
	private int size = 0;

	public void traverse() {
		traverse(tree);
	}

	// 中序遍历 从小到大 遍历这颗树
	private void traverse(Tree<T> node) {
		if (node.hasLeft()) {
			traverse(node.left);
		}
		System.out.println(node.elum);
		if (node.hasRight()) {
			traverse(node.right);
		}
	}
	public void rearTraverse() {
		reaTtraverse(tree);
	}
	// 后序遍历 从大到小 遍历这颗树
	private void reaTtraverse(Tree<T> node) {
		if (node != null) {
			reaTtraverse(node.right);
			System.out.println(node.elum);
			reaTtraverse(node.left);
		}
		
	}
	public void preTraverse() {
		preTraverse(tree);
	}
	// 前序遍历 跟-左-右 遍历这颗树
	private void preTraverse(Tree<T> node) {
		if (node != null) {
			System.out.println(node.elum);
			preTraverse(node.left);
			preTraverse(node.right);
		}
		
	}

	/**
	 * 获取最小值
	 */
	public T getMin(){
		Tree<T> current = tree;
		while (current.hasLeft()) {
			current = current.left;
		}
		return current.elum;
	}
	/**
	 * 获取最小值
	 */
	public T getMax(){
		Tree<T> current = tree;
		while (current.hasRight()) {
			current = current.right;
		}
		return current.elum;
	}
	/**
	 * 删除一个普通二叉树的节点 1.找到需要被删除的节点 2.找到被删除节点的父节点 3.讲被删除的子节点的右节点的左左节点的引用
	 * 指向被删除节点的左节点 4.父节点的左或右节点指向将被删除的节点的右节点
	 * 
	 * @param elums
	 * @return
	 */
	public T remove(T elum) {
		if (elum == null) {
			throw new IllegalArgumentException("null is not support");
		}
		Tree<T> current = tree;
		Tree<T> parent = null;
		while (current != null) {
			int to = current.elum.compareTo(elum);
			if (to == 0) {
				Tree<T> nodeReplaceDelete = current.left;
				if (current.hasRight()) {
					Tree<T> leftbyright = current.right;
					while (leftbyright.hasLeft()) {
						leftbyright = leftbyright.left;
					}
					leftbyright.left = nodeReplaceDelete;
					nodeReplaceDelete = current.right;
				}
				if (parent == null) {
					tree = nodeReplaceDelete;
				} else if (parent.left == current) {
					parent.left = nodeReplaceDelete;
				} else {
					parent.right = nodeReplaceDelete;
				}
				size--;
				return current.elum;
			} else if (to < 0) {
				parent = current;
				current = current.right;
			} else {
				parent = current;
				current = current.left;
			}
		}
		return null;
	}

	public boolean isExsit(T elums) {
		if (tree == null) {
			return false;
		}
		Tree<T> current = tree;
		while (true) {
			int i = current.elum.compareTo(elums);
			if (i == 0) {
				return true;
			} else if (i < 0) {
				if (current.hasRight()) {
					current = current.right;
					continue;
				}
				return false;
			} else {
				if (current.hasLeft()) {
					current = current.left;
					continue;
				}
				return false;
			}
		}
	}

	public int getSize() {
		return size;
	}

	public void add(T t) {
		if (t == null) {
			throw new IllegalArgumentException("null is not support");
		}
		Tree<T> node = new Tree<>(t, null, null);
		if (tree == null) {
			tree = node;
		} else {
			Tree<T> current = tree;
			while (true) {
				int i = current.elum.compareTo(t);
				if (i == 0) {
					// 如果相等 则用新添加的数 替换掉老的数据
					node.left = current.left;
					node.right = current.right;
					current = node;
					return;
				} else if (i < 0) {
					if (current.hasRight()) {
						current = current.right;
					} else {
						current.right = node;
						break;
					}
				} else {
					if (current.hasLeft()) {
						current = current.left;
					} else {
						current.left = node;
						break;
					}
				}
			}
		}
		size++;
	}

	public boolean isEmpty() {
		return size < 1;
	}

	protected class Tree<E extends Comparable<E>> {
		private E elum;
		private Tree<E> left;
		private Tree<E> right;

		public Tree(E elum, Tree<E> left, Tree<E> right) {
			this.elum = elum;
			this.left = left;
			this.right = right;
		}

		public boolean hasLeft() {
			return left != null;
		}

		public boolean hasRight() {
			return right != null;
		}

		public Tree<E> getLeft() {
			return left;
		}

		public void setLeft(Tree<E> left) {
			this.left = left;
		}

		public Tree<E> getRight() {
			return right;
		}

		public void setRight(Tree<E> right) {
			this.right = right;
		}

		public E getElum() {
			return elum;
		}
		
	}
}
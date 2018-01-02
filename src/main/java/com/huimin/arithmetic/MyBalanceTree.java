package com.huimin.arithmetic;

/**
 * 自己实现的自平衡树
 * 
 * @author zhuliang
 *
 * @date 2017年12月28日
 */
public class MyBalanceTree<T extends Comparable<T>> extends MyTreeList<T> {

	public void adjustTree(){
		rightHandedRotationAdjustTree(tree);
	}
	public void rightHandedRotationAdjustTree(Tree<T> root) {
		Tree<T> newRoot = findMiddle(root);
		if (!newRoot.hasParent()) {
			return;
		}
		Tree<T> oldRoot = root;
		Tree<T> newRootparent = newRoot.getParent();
		if (newRoot == newRootparent.getRight()) {
			Tree<T> newRootParentLeft = newRootparent;
			Tree<T> oldnewRootLeft = newRoot;
			while(oldnewRootLeft.hasLeft()){
				oldnewRootLeft = oldnewRootLeft.getLeft();
			}
			newRootParentLeft.setParent(oldnewRootLeft);
			oldnewRootLeft.setLeft(newRootParentLeft);
			newRootparent = newRootparent.getParent();
		}
		Tree<T> newRootparentFor = newRootparent;
		while (newRootparentFor.hasParent()) {
			Tree<T> parentFor = newRootparentFor.getParent();
			newRootparentFor.setRight(parentFor);
			newRootparentFor.setParent(newRootparentFor.getLeft());
			newRootparentFor.setLeft(null);
			newRootparentFor = parentFor;
		}
		oldRoot.setParent(newRootparentFor);;
		oldRoot.setLeft(null);
		Tree<T> oldnewRootRight = newRoot;
		while(oldnewRootRight.hasRight()){
			oldnewRootRight = oldnewRootRight.getRight();
		}
		oldnewRootRight.setRight(newRootparent);
		newRootparent.setParent(oldnewRootRight);
		
		newRoot.setParent(null);
		root = newRoot;
	}
	public void leftHandedRotationAdjustTree(Tree<T> root) {
		Tree<T> newRoot = findMiddle(root);
		if (!newRoot.hasParent()) {
			return;
		}
		Tree<T> oldRoot = root;
		Tree<T> newRootparent = newRoot.getParent();
		if (newRoot == newRootparent.getRight()) {
			Tree<T> newRootParentLeft = newRootparent.getLeft();
			Tree<T> oldnewRootLeft = newRoot;
			while(oldnewRootLeft.hasLeft()){
				oldnewRootLeft = oldnewRootLeft.getLeft();
			}
			newRootParentLeft.setParent(oldnewRootLeft);
			oldnewRootLeft.setLeft(newRootParentLeft);
		}
		Tree<T> newRootparentFor = newRootparent.getParent();
		while (newRootparentFor.hasParent()) {
			Tree<T> parentFor = newRootparentFor.getParent();
			newRootparentFor.setParent(newRootparentFor.getRight());
			newRootparentFor.setLeft(newRootparentFor.getParent());
			newRootparentFor.setRight(null);
			newRootparentFor = parentFor;
		}
		oldRoot.setParent(newRootparentFor);;
		oldRoot.setRight(null);
		Tree<T> oldnewRootRight = newRoot;
		while(oldnewRootRight.hasRight()){
			oldnewRootRight = oldnewRootRight.getRight();
		}
		oldnewRootRight.setRight(newRootparent);
		newRootparent.setParent(oldnewRootRight);
		
		newRoot.setParent(null);
		root = newRoot;
	}

	public Tree<T> findMiddle(Tree<T> root) {
		
		class Tr<E extends Comparable<E>> {
			int i;
			Tree<E> node;
            public Tr(Tree<E> node) {
            	this.node = node;
            	i = 0;
			}
			void traverse(Tree<E> tree) {
				if (tree.hasLeft()) {
					traverse(tree.getLeft());
				}
				if (i++ == getSize() / 2) {
					node = tree;
					return;
				}
				if (tree.hasRight()) {
					traverse(tree.getRight());
				}

			}

			public Tree<E> getNode() {
				traverse(node);
				return node;
			}
		}
		return new Tr<T>(root).getNode();
	}

}

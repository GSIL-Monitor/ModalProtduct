package com.huimin.arithmetic.test;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.huimin.arithmetic.MyBalanceTree;
import com.huimin.arithmetic.MyTreeList;
import com.huimin.entity.Student;

public class MyTreeListTest {

	//测试右旋调整二叉树
	@Test
	public void test06(){
		MyBalanceTree<Integer> list = new MyBalanceTree<>();
		list.add(200);
		list.add(90);
		list.add(46);
		list.add(23);
		list.add(19);
		list.add(18);
		list.add(10);
		list.add(6);
		list.add(5);
		list.add(2);
		list.add(1);
		//list.adjustTree();
		list.add(1);
	}
	//测试遍历二叉树
	@Test
	public void test05(){
		MyBalanceTree<Integer> list = new MyBalanceTree<>();
		list.add(10);
		list.add(2);
		list.add(18);
		list.add(5);
		list.add(23);
		list.add(19);
		list.add(1);
		list.add(6);
		list.add(200);
		list.add(46);
		list.add(90);
		list.adjustTree();
	}
	//测试遍历二叉树
	@Test
	public void test04(){
		MyTreeList<Integer> list = new MyTreeList<>();
		list.add(10);
		list.add(2);
		list.add(18);
		list.add(5);
		list.add(23);
		list.add(19);
		list.add(1);
		list.add(6);
		list.add(200);
		list.add(46);
		list.add(90);
		System.out.println(list.getMin());
		System.out.println(list.getMax());
	}
	@Test
	public void test03(){
		MyTreeList<Integer> list = new MyTreeList<>();
		list.add(10);
		list.add(2);
		list.add(18);
		list.add(5);
		list.add(23);
		list.add(19);
		list.add(1);
		list.add(6);
		list.add(200);
		list.add(46);
		list.add(90);
		list.remove(10);
		//list.traverse();
		//list.rearTraverse();
		list.preTraverse();
	}
	@Test
	public void test02(){
		Set<Object> set = new TreeSet<>();
		set.add(new Student());
		set.add(new Student());
	}
	@Test
	public void test01(){
		MyTreeList<Integer> list = new MyTreeList<>();
		list.add(10);
//		list.add(2);
//		list.add(18);
//		list.add(5);
//		list.add(23);
//		list.add(18);
		list.remove(10);
		System.out.println(list.isExsit(23));
		System.out.println(list.isExsit(7));
	}
}

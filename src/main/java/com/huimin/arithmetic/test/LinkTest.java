package com.huimin.arithmetic.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.huimin.arithmetic.MyLinkList;
import com.huimin.arithmetic.OneWayLink;
import com.huimin.arithmetic.TwoWayLinkList;
import com.huimin.entity.Student;

public class LinkTest {

	
	
	@Test
	public void test07(){
		Map<Student, Object> map = new HashMap<>(4);
		Map<Student, Object> map2 = new TreeMap<>();
		map.put(new Student(), 1);
		map.put(new Student(), 1);
		map.put(new Student(), 1);
		map.put(new Student(), 1);
		map.put(new Student(), 1);
		map.put(new Student(), 1);
		map.put(new Student(), 1);
		map.put(new Student(), 1);
		map.put(new Student(), 1);
		map.put(new Student(), 1);
		map.put(new Student(), 1);
		int size = map.size();
		System.out.println(size);
	}
	@Test
	public void test06(){
		TwoWayLinkList<Integer> list = new TwoWayLinkList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		TwoWayLinkList<Integer>.InvertedOrder<Integer> invertedOrder = list.invertedOrder();
		while (invertedOrder.hasPre()) {
			System.out.println(invertedOrder.pre());			
		}
	}
	@Test
	public void test05(){
		TwoWayLinkList<Integer> list = new TwoWayLinkList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Iterator<Integer> iterate = list.iterate();
		while (iterate.hasNext()) {
           System.out.println(iterate.next());			
		}
	}
	
	@Test
	public void test04(){
		MyLinkList<Integer> linkList = new MyLinkList<>();
		linkList.add(1);
		linkList.add(2);
		linkList.add(3);
		linkList.add(4);
		linkList.add(5);
		linkList.addFrist(100);
		linkList.remove(11);
		Iterator<Integer> iterate = linkList.iterate();
		while (iterate.hasNext()) {
			System.out.println(iterate.next());			
		}
	}
	@Test
	public void test03(){
		MyLinkList<Integer> linkList = new MyLinkList<>();
		linkList.add(1);
		linkList.add(2);
		linkList.add(3);
		linkList.add(4);
		linkList.add(5);
		linkList.addFrist(100);
		linkList.removeLast();
		Iterator<Integer> iterate = linkList.iterate();
		while (iterate.hasNext()) {
           System.out.println(iterate.next());			
		}
	}
	@Test
	public void test02(){
		MyLinkList<Integer> linkList = new MyLinkList<>();
		linkList.add(1);
		linkList.add(2);
		linkList.add(3);
		linkList.add(4);
		linkList.add(5);
		linkList.addFrist(100);
//		linkList.removeFirst();
		linkList.removeLast();
		System.out.println(linkList.size());
		Iterator<Integer> iterate = linkList.iterate();
		while (iterate.hasNext()) {
           System.out.println(iterate.next());			
		}
	}
	@Test
	public void test01(){
		OneWayLink<Integer> oneWayLink = new OneWayLink<Integer>();
		oneWayLink.put(1);
		oneWayLink.put(2);
		oneWayLink.put(3);
		oneWayLink.put(4);
		oneWayLink.put(5);
		oneWayLink.put(100);
		
		while(true){
			System.out.println(oneWayLink.getData());	
			if (oneWayLink.hasNext()) {
				oneWayLink = oneWayLink.getNext();
			}else {
				break;
			}
		}
	}
}

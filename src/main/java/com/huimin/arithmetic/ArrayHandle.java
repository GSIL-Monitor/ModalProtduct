package com.huimin.arithmetic;

import java.util.Arrays;
import java.util.List;

/**
 * 数组排序类
 * @author zhuliang
 *
 * @date 2017年12月23日
 */
public class ArrayHandle {

	public static void main(String[] args) {
		Integer[] arrays = {1,4,56,3,34,3,12,6};
	     List<Integer> asList = Arrays.asList(arrays);
	     System.out.println(asList.contains(34));
		//bubblingSort(arrays, true);
		//insertSort(arrays, false);
		System.out.println(dichotomy(arrays, 34));
		for (Integer integer : arrays) {
			System.out.print(integer + " ");
		}
	}
	
	/**
	 * 二分法查找是否存在
	 * @param arrays
	 * @param num
	 * @param low
	 * @param hig
	 * @return
	 */
	public static <T extends Comparable<T>> boolean dichotomy(T[] arrays, T num){
		if (arrays == null || num == null) {
			return false;
		}
		insertSort(arrays, true);
		if (num.compareTo(arrays[0]) < 0 || num.compareTo(arrays[arrays.length - 1]) > 0) {
			return false;
		}
		return dichotomy(arrays, num, 0, arrays.length -1);
	}
	
	private static<T extends Comparable<T>> boolean dichotomy(T[] arrays, T num, int low, int hig) {
		
		if (low > hig) {
			return false;
		}
		int middle = low + (hig - low) / 2;
		
		if (num.compareTo(arrays[middle]) > 0) {
			low = middle + 1;
			return dichotomy(arrays, num, low, hig);
		}else if (num.compareTo(arrays[middle]) < 0) {
			hig = middle -1;
			return dichotomy(arrays, num, low, hig);
		}else {
			return true;
		}
	}
	
	/**
	 * 选择排序法
	 */
	public static <T extends Comparable<T>> void selectSort(T[] arrays, boolean isAsc) {
		for (int i = 0; i < arrays.length - 1; i++) {
			for (int j = i + 1; j < arrays.length; j++) {
				if (isAsc) {
					if (arrays[i].compareTo(arrays[j]) > 0) {
						exchange(arrays, i , j);
					}
				}else {
					if (arrays[i].compareTo(arrays[j]) < 0) {
						exchange(arrays, i , j);
					}
				}
			}
		}
	}
	/**
	 * 冒泡排序法
	 */
	public static <T extends Comparable<T>> void bubblingSort(T[] arrays, boolean isAsc) {
		for (int i = 0; i < arrays.length - 1; i++) {
			for (int j = 0; j < arrays.length - i - 1; j++) {
				if (isAsc) {
					if (arrays[i].compareTo(arrays[j]) > 0) {
						exchange(arrays, j , j +1);
					}
				}else {
					if (arrays[i].compareTo(arrays[j]) < 0) {
						exchange(arrays, j , j +1);
					}
				}
			}
		}
	}
	/**
	 * 插入排序
	 */
	public static <T extends Comparable<T>> void insertSort(T[] arrays, boolean isAsc) {
		for (int i = 0; i < arrays.length; i++) {
			int min = i;
			T temp = arrays[i];
			if (isAsc) {
				while (min > 0 && arrays[min -1].compareTo(temp) > 0) {
					arrays[min] = arrays[min -1];
					--min;
				}
			}else {
				while (min > 0 && arrays[min -1].compareTo(temp) < 0) {
					arrays[min] = arrays[min -1];
					--min;
				}
			}
			arrays[min] = temp;
		}
	}
	
	private static <T extends Comparable<T>> void exchange(T[] arrays , int i, int j){
		T temp = arrays[i];
		arrays[i] = arrays[j];
		arrays[j] = temp;
	}
	
}

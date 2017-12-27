package com.huimin.arithmetic;

/**
 * 递归
 * @author zhuliang
 *
 * @date 2017年12月26日
 */
public class Recursion {

	public static void main(String[] args) {
		System.out.println(power(2, 4));
		//System.out.println(moniChengFa(3, 4));
//		move(4, 'A', 'B', 'C');
//		System.out.println(factorial(9));
		// 1 3 6 10 15
//		System.out.println(triangular(1000));
//		int sum = 0;
//		int t = 0;
//		for (int i = 1; i <= 5; i++) {
//			t += i;
//			sum += t;
//		}
//		System.out.println(sum);
	}
	
	public static int power(int num, int x){
		if (x == 1) {
			return num;
		}
		return num * power(num, x - 1);
	}
	public static int moniChengFa(int x, int y){
		if (x == 1) {
			return y;
		}
		return y + moniChengFa(x -1, y);
	}

	public static void move(int top, char from, char inner, char to){
		if (top == 1) {
			System.out.println("from:" + from + " to:" + to);
		}else {
			move(top - 1, from, to, inner);
			System.out.println("from:" + from + " to:" + to);
			move(top - 1, inner, from, to);
		}
	}
	public static int factorial(int n){
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	
	/**
	 * 计算三角数  1 3 6 10 15
	 * @param i
	 * @return
	 */
	public static  int triangular(int i){
		if (i == 1) {
			return 1;
		}
		return i + triangular(i - 1);
	} 
}

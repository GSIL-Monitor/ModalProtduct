package com.huimin.arithmetic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 用栈数据结构实现 Java代码 符号使用的检查
 * @author zhuliang
 *
 * @date 2017年12月23日
 */
public class StackTest {
	public static void main(String[] args) {

		boolean match = isMatch(
				"D:/workspace/cms/ModalProtduct/src/main/java/com/huimin/entity/security/UserRole.java");
		System.out.println(match);

		// MyStack<Integer> stack = new MyStack<Integer>();
		// stack.push(1);
		// stack.push(2);
		// stack.push(3);
		// stack.push(4);
		// while (!stack.isEmpty()) {
		// System.out.println(stack.pop());
		// }
		// 倒序字符串
		// String str = "abcdefg";
		// MyStack<Character> stack = new MyStack<Character>(str.length());
		// for (int i = 0; i < str.length(); i++) {
		// stack.push(str.charAt(i));
		// }
		// while (!stack.isEmpty()) {
		// System.out.print(stack.pop());
		// }
	}

	// 匹配Java程序中{ ( [ " 符号是否成对出现
	public static boolean isMatch(File javaFile) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(javaFile)));
			StringBuilder builder = new StringBuilder();
			String readLine;
			while ((readLine = reader.readLine()) != null) {
				builder.append(readLine);
			}
			reader.close();
			String source = builder.toString();
			return isMatch(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean isMatch(String source) {
		MyStack<Character> stack = new MyStack<Character>();
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				if (stack.isEmpty()) {
					stack.push(c);
				}else {
					if (stack.peek() != '"') {
						stack.push(c);
					}
				}
			}
			if (c == '}' || c == ']' || c == ')') {
				if (!stack.isEmpty()) {
					Character top = stack.peek();
					if ((c == '}' && top == '{') || (c == ']' && top == '[') || (c == ')' && top == '(')) {
						stack.pop();
					}else if (top != '"') {
						return  false;
					}
				} else {
					return false;
				}
			}
			if (c == '"') {
				if (i == 0) {
					// 不可能为转义的" 直接加入栈中
					stack.push(c);
				} else {
					// 栈为空的情况 检查其是否为转义字符
					char at = source.charAt(i - 1);
					if (at != '\\') {
						if (stack.isEmpty()) {
							stack.push(c);
						}else {
							Character t = stack.peek();
							if (t == '"') {
								stack.pop();
							}else {
								stack.push(c);
							}
						}
					}
				}
			}
		}

		return stack.isEmpty();
	}
}

/**
 * 基于数组自己实现的栈数据接口 由于测试用的 数组大小固定 不能用于扩容
 * 
 * @author zhuliang
 *
 * @date 2017年12月23日
 */
class MyStack<T> {
	// 栈用数组来是实现
	private Object[] stack;
	// 用于标记栈顶的位置 初始值为-1
	private int top = -1;

	private int maxSize = 100;

	public MyStack() {
		stack = new Object[maxSize];
	}

	public MyStack(int size) {
		if (size < 0) {
			throw new IllegalArgumentException();
		}
		maxSize = size;
		stack = new Object[maxSize];
	}

	@SuppressWarnings("unchecked")
	private T corvent(Object o) {
		return (T) o;
	}

	public void push(T t) {
		if (isFull()) {
			throw new RuntimeException("栈已满 无法新增元素");
		}
		stack[++top] = t;
	}

	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈中没有元素");
		}
		return corvent(stack[top--]);
	}

	public T peek() {
		if (top < 0) {
			throw new RuntimeException("栈中没有元素");
		}
		return corvent(stack[top]);
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public boolean isFull() {
		return top >= maxSize - 1;
	}
}
package com.huimin.arithmetic;

/**
 * 解析算数表达式
 * 
 * @author zhuliang
 *
 * @date 2017年12月25日
 */
public class ArithmeticExpression {

	// 算数表达式的每一个值
	private MyStack<Integer> enums;
	// 算数表达式的符号
	private MyStack<Character> opThis;
	// 后缀表达式的符号值
	private MyStack<Character> opThat;

	public ArithmeticExpression() {
		enums = new MyStack<>();
		opThis = new MyStack<>();
		opThat = new MyStack<>();
	}

	public void parseExpression(String expression) {
		if (expression == null || expression.trim() == "") {
			throw new IllegalArgumentException("算数表达式不能为空");
		}
		for (int i = 0; i < expression.length(); i++) {
			char num = expression.charAt(i);
			if (num >= 0 && num <= 9) {
				enums.push((int) num);
			} else {
				handleSymbol(num);
			}
		}
	}

	private void handleSymbol(char num) {
		opThis.push(num);
		switch (num) {
		case '+':
		case '-':
			if (opThat.isEmpty()) {
				opThat.push(num);
			} else {

			}
			break;
		case '*':
		case '/':
			break;

		default:
			break;
		}
	}
}

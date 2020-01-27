package com.revature.javacore;

public class QuestionFifteen implements QuestionFiteenn {
	@Override
	public int subtraction(int a, int b) {
		return a - b;

	}

	@Override
	public int addition(int a, int b) {

		return a + b;
	}

	@Override
	public int multiplication(int a, int b) {

		return a * b;
	}

	@Override
	public int division(int a, int b) {

		return a / b;
	}

	public static void main(String[] args) {
		QuestionFifteen qf = new QuestionFifteen();
		int a = 4;
		int b = 2;
		System.out.println(qf.addition(a, b));
		System.out.println(qf.subtraction(a, b));
		System.out.println(qf.multiplication(a, b));
		System.out.println(qf.division(a, b));
	}

}

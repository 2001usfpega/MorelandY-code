package com.revature.javacore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionFifteenTest {

	@Test
	void test() {
		
		
		QuestionFifteen qf = new QuestionFifteen();
		int a = 4;
		int b = 2;
		int expecteds = 6;
		int acturals = qf.addition(a, b);
		assertEquals (expecteds, acturals);
		System.out.println(qf.addition(a, b));
		
		int c = 5;
		int d = 3;
		int expecteds1 = 0;
		int acturals1 = qf.subtraction(c, d);
		assertEquals (expecteds, acturals);
		System.out.println(qf.subtraction(c, d));
		
		int e = 2;
		int f = 1;
		int expecteds2 = 2;
		int acturals2 = qf.multiplication(e, f);
		assertEquals (expecteds, acturals);
		System.out.println(qf.multiplication(e, f));
		
		int g = 10;
		int h = 2;
		int expecteds3 = 5;
		int acturals3 = qf.division(g, h);
		assertEquals (expecteds, acturals);
		System.out.println(qf.division(g, h));
		
	
	}

}

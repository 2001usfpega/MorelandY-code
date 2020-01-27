package com.revature.javacore;

public class QuestionEighteen2 extends QuestionEighteen {

	public boolean eat() {
		
		String s = "LETS EAT";
		String t = s.toLowerCase();
		
	//	System.out.println("LETS EAT");
		
		if(t == s) {
			System.out.println("False\n");
			return false;
		}else {
			System.out.println("True\n");
			return true;
		}
		
	}

	public void walk() {
		
		String lower = "i walk";
		System.out.println("lowercase to UPPEERCASE");
		System.out.println(lower.toUpperCase() + "\n");

//		System.out.println(" ");

	//	System.out.println();
		
	//	System.out.println("i walk");
	}

	public void grow() {
		
		int i = Integer.parseInt("8") + 10;
		System.out.println(i);
		
		System.out.println("I'm a big kid now");
	}

}

package com.revature.javacore;

public class QuestionThree {

	public static void main(String[] args) {
		//original string
		String theGreat = "Yzairyen";
		//reverse string
		String taergEht= "";
		//repeats the string in reverse
		for (int i = theGreat.length()-1; i >= 0; i --) {
			taergEht += theGreat.charAt(i); 
		}

		System.out.println(taergEht); 

	}

}

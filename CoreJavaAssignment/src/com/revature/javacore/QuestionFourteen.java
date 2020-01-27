package com.revature.javacore;

import java.time.LocalDate;

public class QuestionFourteen {
	// Switch Case
	public static void main(String[] args) {

		int java = 3;

		switch (java) {

		default:
			System.out.println("ROll TIDE!!");
		case 1:
			System.out.println(Math.sqrt(9));
		case 2:
			LocalDate now = LocalDate.now();
			System.out.println(now);
		case 3:
			String strang = "I am learning core Java";
			// a space is added between the quotations so that the system knows to split
			// every time there is a space
			String str[] = strang.split(" ");

			for (int i = 0; i < str.length; i++) {
				System.out.println(str[i] + " ");
			}

		}

	}

}

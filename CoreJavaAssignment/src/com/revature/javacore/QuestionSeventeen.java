package com.revature.javacore;

import java.util.Scanner;

public class QuestionSeventeen {
	//Prinicple, Rate, Time and Interest

	public static void main(String[] args) {
		// created a scanner obj so that the user can input their own values
		
		Scanner QuestionSeventeen = new Scanner(System.in);
		
		// all values to be entered by user: principle, rate, and time the system
		// will print out the value for interest based on the numbers entered.
		
		double principle;
		double rate;
		double time;
		
		// the system will print out the result for the interest based on the numbers entered for principle, rate and time
		
		double result;
		System.out.print("Enter Principle : ");
		principle = QuestionSeventeen.nextDouble();

		System.out.print("Enter Rate : ");
		rate = QuestionSeventeen.nextDouble();

		System.out.print("Enter Time : ");
		time = QuestionSeventeen.nextDouble();

		result = principle * rate * time / 100;
		System.out.println("Interest : " + result);

	}
}

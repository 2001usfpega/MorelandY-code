package com.revature.javacore;

public class QuestionTwo {
	//Fibonacci Numbers

	public static void main(String[] args) {
		//Set variables and values
		 int c, b = 1, a = 1;
		 
		 c = 0;
		 System.out.println("0");
		 System.out.println("1");
		 
		 //We want to print out 25 numbers in the series. I was able to find out that 50000 gives us 25 numbers in the series by trial and error, so we want to set 4000 as the value that the code will stop at once it gets to be less than or equal to that number. 
		 while (a <= 50000) {
		//The Fibonacci series is a series where the following term in the series is the sum of the previous first two terms. 
		//So, we want to have an equation that represents this action; c = b + a. We want to set the value of b = to a and a = to c for the following values so that the series will continue to follow the equation of adding the first two number together to produce the next value and continue to produce the Fibonacci series.	 
			 c = b + a;
			 System.out.println(a + " ");
			 b = a;
			 a = c;
			 
		 }

	}

}
//Reference: Programiz
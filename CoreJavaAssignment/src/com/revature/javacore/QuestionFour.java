package com.revature.javacore;

public class QuestionFour {
	
//N Factorial
	
	public static void main(String[] args) {
		System.out.println(fact( 5));
	}
//with n factorial we are telling the system to print the value equal to the value inputed times n-1 and have it loop back around to continue doing n-1 until it gets to 1.
	public static long fact(long n) {
		if ( n <= 1)
			return 1;
		else 
			return n * fact(n-1);
		
	}
	}
// in my example I used 5. The system checks if 5 is less than or equal to 1, it is not, so it moves on to the else statement and runs the value of 5 * 5-1. Once this is executed the code loops around and runs the value for 4 and so on.
	
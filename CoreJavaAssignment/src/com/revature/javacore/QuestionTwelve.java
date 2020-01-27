package com.revature.javacore;

public class QuestionTwelve {
	//Array 1 to 100 even numbers only

	public static void main(String[] args) {
	// we have to set a variable "i" that we can use to test the values from 1 to 100.
		int i;
	// we have to set an index for our array. Because the array index begins at 0, 
	// if we set the index to be 100, then once the code runs it will stop at 98 and throw an exception.
	// I set the array index to be 101, so that when I set the loop to test the value to 100, 100 will be inculded in the loop.
		 int a[] = new int [101];
		 for (i = 1; i <= 100; i++) {
			 a [i] = i + 1;
	// we use the modulus to check to see if the values are divisible by 2 to check if each value is even or odd. 
			 if (i % 2 == 0)
			 System.out.println(i);
			 
		 }
	// if the numbers pass through the condition and are found to be even, they will be printed to the console.

	}

}

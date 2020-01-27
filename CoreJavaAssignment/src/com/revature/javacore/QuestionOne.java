package com.revature.javacore;

public class QuestionOne {
	//Bubble Sort
		
	public static void bubble_srt(int[] ar) {
	//Here we want to test the numbers in the sequence and check the values. If the second number in the sequence is less than the first number given then a swap will be performed, placing the smaller number before the larger number. We want this to continue to happen throughout the series.
		int a = ar.length;
		int b;
		for (int c = a; c >= 0; c--) {
			for (int i = 0; i < a -1; i ++) {
				b = i + 1;
				if (ar[i] > ar[b]) {
					swapNumbers(i, b, ar);
				}
				
				}
			printNumbers (ar);
			
		}
		}
	public static void swapNumbers(int i, int j, int[]ar) {
		int temp;
		temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
		
	}
	
		public static void printNumbers(int [] input) {
			
			for (int i = 0; i < input.length; i++) {
				System.out.print(input[i]);
			
			}
				System.out.println();
			}
		public static void main(String []args) {
			int[]input = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
			bubble_srt(input);
			
			
		}
			
			
		}
//The Array runs through and checks the value of the number behind it, if the number is smaller, that the code moves the number in front of the initial value. The code then loops around to check the following value in the same way and continues to do so until all values have been checked and re-arranged.
//Reference: MyCodeSchool
		
	
	



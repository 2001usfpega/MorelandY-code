package com.revature.javacore;

import java.util.ArrayList;
import java.util.Iterator;

public class QuestionNineteen {

	// ArrayList, add even numbers, add odd numbers, remove all prime numbers

	public static void main(String[] args) {

		int y = 10;
		ArrayList<Integer> a = new ArrayList<Integer>(y);
		for (int i = 1; i <= y; i++)
			a.add(i);

		System.out.println(a);

		int z = 0;
		//using for loop to print out the sum of the even numbers
		for (int i = 1; i <= y; i += 2) {
			z = z + a.get(i);

		}

		System.out.println("Sum of even nummas: " + z);

		int g = 0;
		//using another for loop to print out the sum of the odd numbers
		for (int i = 0; i <10; i +=2) {
			g = g + a.get(i);
		}
		System.out.println("Sum of odd nummas: " + g);
	
	

//	int h =0;
//		    QuestionNineteen(int y){
//		        for(int i = 2;i<y;i++){
//		            if(y%i == 0) {
//		                System.out.println(i);
//		            }
//		        }
//				
//		   }
		ArrayList <Integer> b = new ArrayList<Integer>(y);
		 int c = 10;
		 //finds out what numbers are prime
		 for(int i = 2;i<=y;i++) {
			 boolean u = true;
			 for( int j : b) {
				 //if statement checks the values and if prime, puts it in arralist b
				 if(i % j == 0) {
					 u =false;
					 break;
				 }
			 }
			 if(u == true) {
				 b.add(i);
			 }
		 }
		 //compares all the numbers in arraylist a and arraylist b and takes the numbers out of a that arent in b
		 Iterator<Integer> q = a.iterator();
		 while(q.hasNext()) {
			 if(b.contains(q.next()))
				 q.remove();
			 
		 }
		 System.out.println(a);
	}
}





//	boolean isPrime(Integer integer) {
//		// TODO Auto-generated method stub
//		return;
//	}

//
//	private static boolean isPrime(Integer integer) {
//		// TODO Auto-generated method stub
//		return false;

//	private static boolean isPrime(Integer integer) {
//		// TODO Auto-generated method stub
//		return false;
//	}

//}

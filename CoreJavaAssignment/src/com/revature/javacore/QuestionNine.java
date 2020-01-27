package com.revature.javacore;

import java.util.ArrayList;

public class QuestionNine {

	public static void main(String[]args) {
		ArrayList <Integer> a = new ArrayList <Integer> ();


		for( int i = 1; i <= 100; i++) {
			a.add(i);


		}
		for(int i = 0; i < 100; i++) {
			
			if( isPrime(a.get(i)) ) 
				System.out.println(a.get(i));
		





		}
		

	}





	 static boolean isPrime(int n) 
	    { 
	        // Corner case 
	        if (n <= 1) 
	            return false; 
	       
	        // Check from 2 to n-1 
	        for (int i = 2; i < n; i++) 
	            if (n % i == 0) 
	                return false; 
	       
	        return true; 
	    } 



}



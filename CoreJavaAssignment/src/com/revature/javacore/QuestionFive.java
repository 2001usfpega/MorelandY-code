package com.revature.javacore;

public class QuestionFive {
//Substring
	public static void main(String[] args) {
		String strang= "abcde";
		String answer = "";
		
		int a = 4;
		answer = substrang(strang , a);
		System.out.println(answer);
	}
	
	public static String substrang(String str, int idx) {
		

			String strang = "";
			for (int i = 0; i < idx; i ++) {
			strang = strang + str.charAt(i);
			
		}
			
		return strang;
		
		
		
		
	}

}

	

	







		
	



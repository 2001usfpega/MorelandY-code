package com.revature.javacore;

public class QuestionThirteen {
	//Triangle 

	public static void main(String[] args) {
		int tri = 0;
		
		for( int i = 0; i < 4; i ++) {
			//System.out.println("0");
			
			for (int j = 0; j <= i; j++) {
				//System.out.print("1");		
				System.out.print(tri);
				tri = 1 - tri;	
			}
			
			
			System.out.println();
		}

	}

}

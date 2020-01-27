package com.revature.javacore; 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class QuestionTwenty {

	public static void main(String[] args) {
		
		File f = new File("/Users/Yzairyen/Documents/workspace-spring-tool-suite-4-4.5.0.RELEASE/CoreJavaAssignment/Data.txt");
		Scanner v;
		try {
			v = new Scanner(f);
		
		while(v.hasNextLine()) {
			String a = v.nextLine();
			String ar[] = a.split(":");
			System.out.println("Name: " + ar[0] + " " + ar[1]);
			System.out.println("Age: " + ar [2] + " " +"years");
			System.out.println("State: " + ar[3] + " " + "State");
			System.out.println(" ");
		}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Lots of trial and error with this one, but we made it! *slaps forehead* :)");
	}	
}
	

	

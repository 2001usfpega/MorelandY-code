package com.revature.banking;

import java.util.Scanner;

public class Options {
	public static void main(String []args) {
	Scanner c = new Scanner(System.in);
	String content;
	content = c.next();
	
	System.out.println("Welcome to Java Bank!");
	System.out.println("Are you a new or returning customer?");
	content = c.next();
	System.out.println("1. New Customer");
	System.out.println("2.Returning Customer");
	content = c.next();
	if(content.equals("1.")) {
		System.out.println("Apply for an Account");
	}else if(content.equals("2.")) {
	System.out.println("Log In");
	}else {
		System.out.println("Invalid Input");
	}
	

	}
 }

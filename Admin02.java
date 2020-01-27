package com.revature;

import java.util.Scanner;

public class Admin02 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your username and password.");
		System.out.println("Username:");
		String username = sc.nextLine();
		System.out.println("Password:");
		String password = sc.nextLine();
		System.out.println("Welcome back, Admin! What would you like to do today?");
		System.out.println("Menu Options:");
		System.out.println("1. View Customer Account Information");
		System.out.println("2. Approve/Deny Account Applications");
		System.out.println("3. Edit Customer Account");
		System.out.println("4. Cancel Customer Account");
		int num = sc.nextInt();
		switch(num) { 
		case 1:	
			System.out.println("Here is the account information for " );			
			//call account info
			break;
		case 2:
			System.out.println("Will this account be approved or denied? Enter 1 for yes or 2 for no.");
			int num1 = sc.nextInt();
			switch(num1) {
			case 1:
				System.out.println("This request has been approved.");
				break;
			case 2: 
				System.out.println("This account has been denied.");
				break;
			default:
				System.out.println("Return to menu.");
			}
			break;
		case 3:
			System.out.println("How would you like to edit this account? Enter 1 to withdraw, 2 to deposit or 3 to transfer.");
			int num2 = sc.nextInt();
			switch(num2) {
			case 1:
				//call withdraw method
				System.out.println("Withdrawal completed.");
				break;
			case 2: 
				//call deposit method
				System.out.println("Deposit completed.");
				break;
			case 3:
				//call transfer method
				System.out.println("Transfer completed.");
				break;
			default:
				System.out.println("Return to menu.");	
			}
			break;
		case 4:
			System.out.println("This account has been removed.");
			break;
		default:
			System.out.println("Return to menu.");
		}
	}
}

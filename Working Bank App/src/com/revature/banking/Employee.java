package com.revature.banking;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
	public static ArrayList<EmpAdm> ba = new ArrayList<EmpAdm>();
	
	public static void mainEmp(){
		try{
			FileInputStream file=new FileInputStream("Data.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			ba=(ArrayList<EmpAdm>)in.readObject();
			in.close();
			file.close();

			}catch(
			FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();

			}catch(
			ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();}catch(
			IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		Scanner ac = new Scanner(System.in);
		System.out.println("Please enter your username and password.");
		System.out.println("Username:");
		String username = ac.nextLine();
		System.out.println("Password:");
		String password = ac.nextLine();
		System.out.println("Welcome back, Employee! What would you like to do today?");
		System.out.println("Menu Options:");
		System.out.println("1. View Customer Account Information");
		System.out.println("2. Approve/Deny Account Applications");
		int num = ac.nextInt();
		switch(num) { 
		case 1:	
			System.out.println("Here is the account information for your most recent customers: " );			
			//call account info
			for (EmpAdm eachAcct : ba) {
				System.out.println(eachAcct);
			}
			break;
		case 2:
			System.out.println("Will this account be approved or denied? Enter 1 for yes or 2 for no.");
			int num1 = ac.nextInt();
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
		default:
			System.out.println("Return to menu.");
		}				
	}
}

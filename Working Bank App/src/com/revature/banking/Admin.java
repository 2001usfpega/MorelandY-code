package com.revature.banking;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;



public class Admin extends EmpAdm {

	public static ArrayList<EmpAdm> ba = new ArrayList<EmpAdm>();

	public static void mainAdm(){


	//	setDefault(true);






		try
		{
			FileInputStream file = new FileInputStream("Bank.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			ba = (ArrayList<EmpAdm>) in.readObject();
			in.close();
			file.close();

		}catch(
				FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

		}catch(
				ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(
				IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		ArrayList<EmpAdm> ba = new ArrayList<EmpAdm>();
		//		 for (EmpAdm unsort: ba) {
		//			 System.out.println(ba);
		//		 }
		Admin admin = new Admin();
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

		switch(num)
		{ 
		case 1:	
			System.out.println("Here is the account information for your most recent customers: ");	

			AdminImpl ai = new AdminImpl();
			System.out.println(ai.selectAllCustomer());
			
			

			//System.out.println(ba.size());
			//			
			//			File f = new File();
			//			Scanner v;
			//			try {
			//				v = new Scanner(f);
			//			
			//			while(v.hasNextLine()) {
			//				String ba = v.nextLine();
			//				String ar[] = ba.split(",");
			//				System.out.println(ar[0] + ar[1] + ar[3] + ar[4]);
			//				System.out.println(ar[5] + ar [6] + ar[7] + ar[8]);
			//			}
			//			}catch (FileNotFoundException e) {
			//				e.printStackTrace();
			//System.out.println(ba.size());
//			for (EmpAdm eachAcct : ba) {
//				System.out.println(eachAcct);
//			}
			//			ArrayList<EmpAdm> ba = new ArrayList<EmpAdm>();
			//			 for (EmpAdm unsort: ba) {
			//				 System.out.println(ba);
			//}

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
	
	
	public static void setDefault(boolean setDefault) {
		if(setDefault) {
			ba.add(new EmpAdm("Llangford","Encapsulation","Lauren Lanford",1));
			ba.add(new EmpAdm("Ymore","Abstraction","Yzairyen Moreland",2));
			ObjectOutputStream objectOut;
			try {
				objectOut = new ObjectOutputStream(new FileOutputStream("Bank.txt"));// highlights file not found so do try
																						// catch block
				objectOut.writeObject(ba);// pass in person file
				objectOut.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return;
		}
	}
}

package com.revature.bank;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bankcustomer.Customer;
import com.revature.bankdao.AdminImpl;
import com.revature.bankdao.CustomerImpl;

public class BankDriver2{
	
	private static String url = System.getenv("url");
	private static String username = System.getenv("username");
	private static String password = System.getenv("password");

	public static void main(String[] args) {
//		Employee e = new Employee();
//		Admin a = new Admin();

		Scanner c = new Scanner(System.in);
		String content;

		CustomerImpl ci = new CustomerImpl();
		
		System.out.println("Welcome to Java Bank!");
		System.out.println("Are you a new or returning customer?");

		System.out.println("1. New Customer");
		System.out.println("2. Returning Customer");
		System.out.println("3. Employee Log In");
		System.out.println("4. Admin Log In");
		content = c.next();
		if (content.equals("1.")) {
			System.out.println("1. Apply for an individual account");
			System.out.println("2. Apply for a joint account");
			content = c.next();

			if (content.equals("1.")) {
				System.out.println("First Name: ");
				content = c.next();
				System.out.println("Last Name: ");
				content = c.next();
				System.out.println("Phone Number: ");
				content = c.next();
				AdminImpl ai = new AdminImpl();
				System.out.println(ai.selectAllCustomer());
				System.out.println(
						"Thank you for applying! At this time we are reviewing your application. A branch administrator will contact you shortly.");
			} else if (content.equals("2.")) {

				System.out.println("Primary First Name: ");
				content = c.next();
				System.out.println("Primary Last Name: ");
				content = c.next();
				System.out.println("Primary Phone Number: ");
				content = c.next();
				System.out.println("Joint First Name: ");
				content = c.next();
				System.out.println("Joint Last Name: ");
				content = c.next();
				System.out.println("Joint Phone Number: ");
				content = c.next();
				System.out.println(
						"Thank you for applying! At this time we are reviewing your application. A branch administrator will contact you shortly.");
			} else {
				System.out.println("Invalid Request");
			}
		} else if (content.equals("2.")) {
			System.out.println("Welcome Back!");

			Scanner sc = new Scanner(System.in);
			String contents;

			System.out.print("Enter Username: ");
			contents = sc.next();

			System.out.print("Enter Password: ");
			System.out.println(" ");
			String s1 = sc.next();

			System.out.println(" ");
			System.out.println("Menu Options");
			String options;

			System.out.println("1. Balance");
			System.out.println("2. Withdraw");
			System.out.println("3. Transfer");
			System.out.println("4. Account Info");

			Scanner nsc = new Scanner(System.in);
			contents = nsc.next();

			//Account save = new Account();
		//	save.balance = 10000;

		//	Account check = new Account();
		//	check.balance = 2000;

			switch (contents) {
			// balance
			case "1.":
			//	Account custo1 = new Account();
				System.out.println("Which account balance would you like?");
				System.out.println("1. Checking");
				System.out.println("2. Savings");

				contents = nsc.next();

			//	if (contents.equals("1.")) {
			//		System.out.println("Your available Checking Account balance is: " + "$" + check.getBalance());
			//	} else {
			//		System.out.println("Your available Savings Account balance is: " + "$" + save.getBalance());
			//	}

				contents = sc.next();
				break;
			case "2.":

				System.out.println("What account would you like to withdraw from?");
				System.out.println("1. Checking");
				System.out.println("2. Savings");
				contents = sc.next();

				System.out.println("How much would you like to withdraw?");

				if (contents.equals("1.")) {
					System.out.println("Your new Checking Account balance is: " + "$" + (2000 - sc.nextInt()));
				} else {
					System.out.println("Your new Savings Account balance is: " + "$" + (10000 - sc.nextInt()));
				}

				break;
			case "3.":

				System.out.println("");
				System.out.println("How much would you like to transfer?");
				contents = nsc.next();
				String h = contents;
				System.out.println("");
				System.out.println("How would you like to transfer?");

				System.out.println("1. Checking Account to Saving Account");
				System.out.println("2. Savings Account to Checking Account");
				System.out.println(" ");
				contents = nsc.next();

				if (contents.equals("1.")) {
					System.out.println("Your new Checking Account balance is: " + "$" + (2000 - Integer.parseInt(h)));
					System.out.println("Your new Savings Account balance is: " + "$" + (2000 + Integer.parseInt(h)));
				} else if (contents.equals("2.")) {
					System.out.println("Your new Savings Account balance is: " + "$" + (2000 - Integer.parseInt(h)));
					System.out.println("Your new Checking Account balance is: " + "$" + (2000 + Integer.parseInt(h)));
				} else {
					System.out.println("Invalid Selection");
				}
				contents = nsc.next();
				break;
			case "4.":
				System.out.println("");
				///////////////////////////////////////////
				Customer custos = new Customer();
			String customer_username = " ";
				try (Connection conn = DriverManager.getConnection(url, username, password)) {
					String sql = "SELECT * FROM customer where customer_username =?";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, customer_username);

					ResultSet rs = ps.executeQuery();
					rs.next();

					custos.setCustomer_id(rs.getInt(1));
					custos.setCustomer_firstname(rs.getString(2));
					custos.setCustomer_lastname(rs.getString(3));
					custos.setCustomer_username(rs.getString(4));
					custos.setCustomer_password(rs.getString(5));
					custos.setCustomer_accountnumber(rs.getInt(6));
					custos.setChecking_balance(rs.getInt(7));
					custos.setSaving_balance(rs.getInt(8));
				
					
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
			
				System.out.println(custos);
				
				
			
				//////////////////////////////////////////
				//System.out.println(ci.selectAllCustomer());
//				System.out.println("Username: ");
//				System.out.println("Password: ");
//				System.out.println("Account ID: ");
				break;
			}

		//} else if (content.equals("3.")) {
			//Employee.mainEmp();
		} else if (content.equals("4.")) {
			Admin.mainAdm();
		}
	}
	
//	String customer_username = "Ymore";
//	String customer_password = "Hi";
//	String customer_firstname = "Wendy";
//	String customer_lastname = "Moreland";
//	int customer_id = 82792;
//	int checking_balance = 0;
//	int saving_balance = 0;
//	int customer_accountnumber = 12;
//	
//AdminImpl ai = new AdminImpl();
//	
//	ai.addCusto(customer_id, customer_firstname, customer_lastname, customer_username,
//			customer_password, customer_accountnumber, checking_balance, saving_balance);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//	System.out.println(ai.selectAllCustomer());
	
	
	
}

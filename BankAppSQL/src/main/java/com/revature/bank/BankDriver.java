package com.revature.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankcustomer.Customer;
import com.revature.bankdao.CustomerImpl;

public class BankDriver {
	private static String url = System.getenv("url");
	private static String username = System.getenv("username");
	private static String password = System.getenv("password");
	static Customer co;
	static boolean yesyesyes = true;

	public static void main(String[] args) {


		CustomerImpl ci = new CustomerImpl();
		Scanner c = new Scanner(System.in);
		String content;

		menu();

		content = c.next();
		if (content.equals("1.")) {
			System.out.println("1. Apply for an individual account");
			System.out.println("2. Apply for a joint account");
			content = c.next();

			if (content.equals("1.")) {
				//System.out.println("Customer ID: ");
				//int customer_id = c.nextInt();
				System.out.println("First Name: ");
				String customer_firstname = c.next();
				System.out.println("Last Name: ");
				String customer_lastname = c.next();
				System.out.println("Username: ");
				String customer_username = c.next();
				System.out.println("Password: ");
				String customer_password = c.next();
				//System.out.println("Account Number: ");
				//int customer_accountnumber = c.nextInt();
				System.out.println("Deposit into Checking Account: ");
				int checking_balance = c.nextInt();
				System.out.println("Deposit into Saving Account: ");
				int saving_balance = c.nextInt();

				
				ci.addCusto(customer_firstname, customer_lastname, customer_username, customer_password,
						checking_balance, saving_balance);
//////////////////////////////////////////////////////////////////////////////////////////

				/////////////////////////////////////////////////////////////////////
				System.out.println("Congratulations! You now have two new accounts.");

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
			String un = sc.next();

			System.out.print("Enter Password: ");
			System.out.println(" ");
			String s1 = sc.next();

			System.out.println(" ");
			System.out.println("Menu Options");
			String options;

			System.out.println("1. Balance");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Delete Account");
			System.out.println("5. Account Info");

			Scanner nsc = new Scanner(System.in);
			contents = nsc.next();

			switch (contents) {
			// balance
			case "1.":
				// Account custo1 = new Account();
				System.out.println("Which account balance would you like?");
				System.out.println("1. Checking");
				System.out.println("2. Savings");

				contents = nsc.next();

				contents = nsc.next();
				break;

			case "2.":

				try (Connection conn = DriverManager.getConnection(url, username, password)) {
					do {
						System.out.println("What account would you like to withdraw from?");
						System.out.println("1. Checking");
						System.out.println("2. Savings");
						contents = nsc.next();

						System.out.println("How much would you like to withdraw?");
						int amount = nsc.nextInt();

						String sql = "SELECT checking_balance, saving_balance FROM customer where customer_username=?";

						PreparedStatement ps = conn.prepareStatement(sql);

						ps.setString(1, un);
						ResultSet rs = ps.executeQuery();

						if (rs.next()) {
							int check = rs.getInt(1);
							int savei = rs.getInt(2);
							if (contents.equals("1.")) {
								check -= amount;
								System.out.println("Your new Checking Account balance is: " + "$" + check);

							} else {
								savei -= amount;
								System.out.println("Your new Savings Account balance is: " + "$" + check);
							}
							sql = "UPDATE customer SET checking_balance= ? , saving_balance= ? where customer_username= ?";

							ps = conn.prepareStatement(sql);
							ps.setInt(1, check);
							ps.setInt(2, savei);
							ps.setString(3, un);
							ps.executeUpdate();
						}

						System.out.println("");
						System.out.println("Would you like to make another withdrawal?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						contents = nsc.next();

						if (contents != "1.") {
							yesyesyes = false;
							System.out.println(
									"Thank you! You will now be logged out. Please log back in for more transactions.");
							break;

						}

					} while (yesyesyes);

				} catch (SQLException e) {
					e.printStackTrace();

				}
				// System.out.println("You will now be logged out. Log back in to update another
				// account.");
				break;

			case "3.":
				try (Connection conn = DriverManager.getConnection(url, username, password)) {
					do {
						System.out.println("What account would you like to Deposit into?");
						System.out.println("1. Checking");
						System.out.println("2. Savings");
						contents = nsc.next();

						System.out.println("How much would you like to Deposit?");
						int amount = nsc.nextInt();

						String sql = "SELECT checking_balance, saving_balance FROM customer where customer_username=?";

						PreparedStatement ps = conn.prepareStatement(sql);

						ps.setString(1, un);
						ResultSet rs = ps.executeQuery();

						if (rs.next()) {
							int check = rs.getInt(1);
							int savei = rs.getInt(2);
							if (contents.equals("1.")) {
								check += amount;
								System.out.println("Your new Checking Account balance is: " + "$" + check);

							} else {
								savei += amount;
								System.out.println("Your new Savings Account balance is: " + "$" + check);
							}
							sql = "UPDATE customer SET checking_balance= ? , saving_balance= ? where customer_username= ?";

							ps = conn.prepareStatement(sql);
							ps.setInt(1, check);
							ps.setInt(2, savei);
							ps.setString(3, un);
							ps.executeUpdate();
						}

						System.out.println("");
						System.out.println("Would you like to make another Deposit?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						contents = nsc.next();

						if (contents != "1.") {
							yesyesyes = false;
							System.out.println(
									"Thank you! You will now be logged out. Please log back in for more transactions.");
							break;

						}

					} while (yesyesyes);

				} catch (SQLException e) {
					e.printStackTrace();

				}
				
				break;

			case "4.":

				System.out.println("");
				System.out.println("Delete All accounts?");

				String h = contents;

				System.out.println("1. Yes");
				System.out.println("2. No");
				System.out.println(" ");
				contents = nsc.next();

				if (contents.equals("1.")) {
					ci.deleteCustomer(un);
					System.out.println();
				} else if (contents.equals("2.")) {

					System.out.println("You will now be logged out of your account.");

				} else {
					System.out.println("Invalid Selection");
				}
				contents = nsc.next();
				break;
			case "5.":

				ci.selectCustomerByUsername(un);

				break;
			}

		} else if (content.equals("3.")) {
			// Employee.mainEmp();
		} else if (content.equals("4.")) {
			Admin.mainAdm();
		}

	}

	public static void menu() {
		System.out.println("Welcome to Java Bank!");
		System.out.println("Are you a new or returning customer?");

		System.out.println("1. New Customer");
		System.out.println("2. Returning Customer");
		System.out.println("3. Employee Log In");
		System.out.println("4. Admin Log In");
	}




}

package com.revature.bank;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.bankdao.AdminImpl;

public class Admin extends EmpAdm {

	public static ArrayList<EmpAdm> ba = new ArrayList<EmpAdm>();

	private static String url = System.getenv("url");
	private static String username = System.getenv("username");
	private static String password = System.getenv("password");

	public static void mainAdm() {

		Admin admin = new Admin();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your username and password.");
		System.out.println("Username:");
		String admin_username = sc.nextLine();
		System.out.println("Password:");
		String admin_password = sc.nextLine();
		System.out.println("Welcome back, Admin! What would you like to do today?");
		System.out.println("Menu Options:");
		System.out.println("1. View Customer Account Information");
		System.out.println("2. Create User Account");
		System.out.println("3. Update Customer Account");
		System.out.println("4. Cancel Customer Account");
		String num = sc.next();

		AdminImpl ai = new AdminImpl();
		switch (num) {
		case "1.": // view
			System.out.println("Here is the account information for your most recent customers: ");
			System.out.println(ai.selectAllCustomer());

			break;
		case "2.": // create
			// System.out.println("Account ID: ");
			// int customer_id = sc.nextInt();
			System.out.println("First Name: ");
			String customer_firstname = sc.next();
			System.out.println("Last Name: ");
			String customer_lastname = sc.next();
			System.out.println("Username: ");
			String customer_username = sc.next();
			System.out.println("Password: ");
			String customer_password = sc.next();
			// System.out.println("Account Number: ");
			// int customer_accountnumber = sc.nextInt();
			System.out.println("Checking Account Balance: ");
			int checking_balance = sc.nextInt();
			System.out.println("Saving Account Balance: ");
			int saving_balance = sc.nextInt();
			System.out.println("New User Account Created");

			ai.addCusto(customer_firstname, customer_lastname, customer_username, customer_password, checking_balance,
					saving_balance);
			break;
		// System.out.println("New User Account Created");
		// break;

		case "3.": // update
			System.out.println("Would you like to edit this account?");

			String options;

			System.out.println("1. Yes");
			System.out.println("2. No");
			String contents;

			Scanner nsc = new Scanner(System.in);
			contents = nsc.next();

			switch (contents) {
			// balance

			case "1.":

				System.out.println("What account would you like to withdraw from?");
				System.out.println(" ");
				System.out.println("Enter Customer First Name:");
				customer_firstname = sc.next();
				System.out.println("1. Checking");
				System.out.println("2. Savings");
				contents = sc.next();

				System.out.println("How much would you like to withdraw?");
				int amount = sc.nextInt();

				checking_balance = 0;
				saving_balance = 0;

				try (Connection conn = DriverManager.getConnection(url, username, password)) {
					String sql = "SELECT checking_balance, saving_balance FROM customer where customer_firstname=?";

					PreparedStatement ps = conn.prepareStatement(sql);

					ps.setString(1, customer_firstname);

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
						sql = "UPDATE customer SET checking_balance= ? , saving_balance= ? where customer_firstname= ?";

						ps = conn.prepareStatement(sql);
						ps.setInt(1, check);
						ps.setInt(2, savei);
						ps.setString(3, customer_firstname);
						ps.executeUpdate();
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("You will now be logged out. Log back in to update another account.");
				break;
			}
				break;
		case "4.":

			System.out.println("Which account would you like to cancel?");

			System.out.println("");
			System.out.println("Customer First Name");
			customer_firstname = sc.next();
			System.out.println("Customer Last Name:");
			customer_lastname = sc.next();
			ai.deleteCusto(customer_firstname, customer_lastname);

			System.out.println("Customer account has been deleted.");

			break;

		}
	}

	public static void setDefault(boolean setDefault) {
		if (setDefault) {
			ba.add(new EmpAdm("Llangford", "Encapsulation", "Lauren Lanford", 1));
			ba.add(new EmpAdm("Ymore", "Abstraction", "Yzairyen Moreland", 2));
			ObjectOutputStream objectOut;
			try {
				objectOut = new ObjectOutputStream(new FileOutputStream("Bank.txt"));// highlights file not found so do
																						// try
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

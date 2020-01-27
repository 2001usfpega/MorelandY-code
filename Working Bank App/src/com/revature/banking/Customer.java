package com.revature.banking;



import java.util.Scanner;

public class Customer extends Menu {

	public static void main(String[] args) {
		Employee e = new Employee();
		Admin a = new Admin();

		Scanner c = new Scanner(System.in);
		String content;

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

			Account save = new Account();
			save.balance = 10000;

			Account check = new Account();
			check.balance = 2000;

			switch (contents) {
			// balance
			case "1.":
				Account custo1 = new Account();
				System.out.println("Which account balance would you like?");
				System.out.println("1. Checking");
				System.out.println("2. Savings");

				contents = nsc.next();

				if (contents.equals("1.")) {
					System.out.println("Your available Checking Account balance is: " + "$" + check.getBalance());
				} else {
					System.out.println("Your available Savings Account balance is: " + "$" + save.getBalance());
				}

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
				
				System.out.println("Username: ");
				System.out.println("Password: ");
				System.out.println("Account ID: ");
				break;
			}

		} else if (content.equals("3.")) {
			Employee.mainEmp();
		} else if (content.equals("4.")) {
			Admin.mainAdm();
		}
	}
}

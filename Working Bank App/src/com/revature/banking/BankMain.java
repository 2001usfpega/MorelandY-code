package com.revature.banking;


import com.revature.banking.Account;

public class BankMain {

	public static void main(String[] args) {
		// Create a new account for custo 1

		Account custo1 = new Account();
		custo1.balance(100);

		// Create new acct for custo2
		Account custo2 = new Account();
		custo2.withdraw(300);
		
		System.out.println("Customer 1 has a balance of: " +"$" + custo1.getBalance());
		System.out.println("Customer 2 has a balance of: " +"$" + custo2.getBalance());
	}

}

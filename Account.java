package com.revature;



public class Account {

	public double balance;

	// set balance
	public Account() {
		//balance = 0.0;

	}

	// set deposit
	public void deposit(double amount) {
		balance = balance + amount;

	}

	// withdraw
	public void withdraw(double amount) {
		balance = balance + amount;
		if (amount <= balance) {
			balance = balance + amount;
		} // if balance enters negative amount cancel transaction
		else if (amount > balance) {
			balance = balance - amount;
			System.out.println("Transaction cancelled due to insufficient funds");
		}
	}


	

	// get balance
	public double getBalance() {
		return balance;

	}
//	public int getBalance() {
//		return (int) balance;

	//}

	public Account(int i) {
		// TODO Auto-generated method stub

	}

	public int withdraw() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double balance(double i) {
		return i;
		// TODO Auto-generated method stub

	}

	public void account(int i) {
		// TODO Auto-generated method stub
		
	}
}


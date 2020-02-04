package com.revature.bankcustomer;

public class Customer {
	

	public Customer() {
		
	}
	private int customer_id;
	private String customer_firstname;
	private String customer_lastname;
	private String customer_username;
	private String customer_password; 
	private int customer_accountnumber;
	private int checking_balance;
	private int saving_balance;
	public Customer(int customer_id, String customer_firstname, String customer_lastname, String customer_username,
			String customer_password, int customer_accountnumber, int checking_balance, int saving_balance) {
		super();
		this.customer_id = customer_id;
		this.customer_firstname = customer_firstname;
		this.customer_lastname = customer_lastname;
		this.customer_username = customer_username;
		this.customer_password = customer_password;
		this.customer_accountnumber = customer_accountnumber;
		this.checking_balance = checking_balance;
		this.saving_balance = saving_balance;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_firstname() {
		return customer_firstname;
	}
	public void setCustomer_firstname(String customer_firstname) {
		this.customer_firstname = customer_firstname;
	}
	public String getCustomer_lastname() {
		return customer_lastname;
	}
	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname = customer_lastname;
	}
	public String getCustomer_username() {
		return customer_username;
	}
	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	public int getCustomer_accountnumber() {
		return customer_accountnumber;
	}
	public void setCustomer_accountnumber(int customer_accountnumber) {
		this.customer_accountnumber = customer_accountnumber;
	}
	public int getChecking_balance() {
		return checking_balance;
	}
	public void setChecking_balance(int checking_balance) {
		this.checking_balance = checking_balance;
	}
	public int getSaving_balance() {
		return saving_balance;
	}
	public void setSaving_balance(int saving_balance) {
		this.saving_balance = saving_balance;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_firstname=" + customer_firstname
				+ ", customer_lastname=" + customer_lastname + ", customer_username=" + customer_username
				+ ", customer_password=" + customer_password + ", customer_accountnumber=" + customer_accountnumber
				+ ", checking_balance=" + checking_balance + ", saving_balance=" + saving_balance + "]";
	}
	
	
}
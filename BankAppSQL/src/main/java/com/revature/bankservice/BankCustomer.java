package com.revature.bankservice;

import java.util.List;

import com.revature.bankcustomer.Customer;

public interface BankCustomer {
	
	
	public List<Customer>getAllCustomer();
	public Customer getCustomer(Customer custo);
	public void accountCreate(String user);//could be a user object
	public boolean checkUsernameAndPassword(String u, String p);
	public boolean login(String u, String p);

}

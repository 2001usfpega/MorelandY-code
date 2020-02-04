package com.revature.bankservice;

import java.util.List;

import com.revature.bankcustomer.Customer;
import com.revature.bankdao.CustomerDao;
import com.revature.bankdao.CustomerImpl;



public class BankCustomerImpl implements BankCustomer {

	private CustomerDao custoDao = new CustomerImpl();

	@Override
	public List<Customer> getAllCustomer() {
		// our pre database call business logic would go here
		List <Customer> mylist = (List<Customer>) custoDao.selectAllCustomer();
		//our post db call business logic would go here
		return null;
	}

	@Override
	public Customer getCustomer(Customer custo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accountCreate(String user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkUsernameAndPassword(String u, String p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(String u, String p) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

package com.revature.bankdao;

import java.util.List;

import com.revature.bankcustomer.Customer;

public interface CustomerDao {
	
	//CREATE
		public Customer insertCustomer(int customer_id, String customer_firstname, String customer_lastname, String customer_username, String customer_password,int customer_accountnumber, int checking_balance, int saving_balance);
		//Read
		public Customer selectAllCustomer();
		//view
		public Customer selectCustomerByUsername(String customer_username);
		//Update
		public Customer updateCustomer(int checking_balance, int saving_balance, String customer_firstname);
		
		public Customer addCusto(String customer_firstname, String customer_lastname, String customer_username,
			String customer_password, int checking_balance, int saving_balance);

		public Customer deleteCustomer(String customer_username);
		
		
		//create
		public void addCusto( String customer_firstname, String customer_lastname, String customer_username, String customer_password);
		//view
		public int getCustoById(int customer_id);
		//Update
		public int updateCusto(int checking_balance, int saving_balance, String customer_firstname, String customer_lastname);
		//Delete
		public String deleteCusto(String customer_firstname, String customer_lastname);
		
		
}






//CREATE
	//public int insertFood(Food food);
	//Read
	//public List<Food>selectAllFood();
	//public Food selectFoodById(int id);
	//public Food selectFoodByName(String name);
	//Update
	//public int updateFood(Food food);
	//Delete
	//public int deleteFood(Food food);
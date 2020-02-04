package com.revature.bankdao;

public interface AdminDao {
	
	public void addCusto(int customer_id, String customer_firstname, String customer_lastname, String customer_username, String customer_password, int customer_accountnumber, int checking_balance, int saving_balance);
	//view
	public int getCustoById(int customer_id);
	//Update
	public int updateCusto(int checking_balance, int saving_balance, String customer_firstname, String customer_lastname);
	//Delete
	public String deleteCusto(String customer_firstname, String customer_lastname);
	

}

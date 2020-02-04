package com.revature.bankdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankcustomer.Customer;

public class CustomerImpl1 implements CustomerDao {

	/*
	 * For ORACLE DBMS specifically the url patter is:
	 * 
	 * private static String url=
	 * "jdbc:oracle:thin:@[endpoint]:[port]:[database-name]";
	 * 
	 * for local dbms: "jdbc:oracle:thin:@localhost:1521:xe";
	 */
	private static String url = System.getenv("url");
	private static String username = System.getenv("username");
	private static String password = System.getenv("password");

	public Customer insertCustomer(String customer_firstname, String customer_lastname, String customer_username, String customer_password) {
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			String sql = "INSERT INTO customer VALUES(customer_id = null , customer_firstname = ?, "
					+ "customer_lastname = ?, customer_username = ?, customer_password =?, customer_accountnumber = null)";
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, customer_id);//first question mark
			ps.setString(2, customer_firstname);
			ps.setString(3, customer_lastname);
			ps.setString(4, customer_username);
			ps.setString(5, customer_password);
		//	ps.setInt(6, customer_accountnumber);
			
			return null;
		}
	
		
		
			public List<Customer>selectAllCustomer(){
			List<Customer> custos = new ArrayList<>();
			
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				String sql = "SELECT * FROM customer";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
				custos.add(
							new Customer()
					
				);
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return (Customer) custos;
		}
//		@Override
//		public Customer selectCustomerById(int customer_id) {
//				try (Connection conn = DriverManager.getConnection(url, username, password)) {
//					/*
//					 * prepared statments guard against sql injections bc it is pre-complied 
//					 * (which also makes it faster)
//					 */
//					
//					String sql = "SELECT * FROM customer where(customer_id)= ?";
//					
//					PreparedStatement ps = conn.prepareStatement(sql);
//					ps.setInt(1, customer_id);//first question mark
//					
//
//					ps.executeUpdate();
//
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			
//			
//			return null;
//		}
		@Override 
		Customer selectCustomerByName(String customer_firstname, String customer_lastname) {

			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				
				
				String sql = "SELECT * FROM customer where customer_firstname= ? and customer_lastname= ?";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, customer_firstname);
				ps.setString(2, customer_lastname);

				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		@Override
		public int updateCustomer(int checking_balance, int saving_balance, String customer_firstname) {
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				
				String sql = "UPDATE customer SET checking_balance= ? , saving_balance= ? where customer_firstname= ?";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, checking_balance);
				ps.setInt(2, saving_balance);
				ps.setString(3, customer_firstname);
				

				ps.executeUpdate();

			} catch (SQLException e)  {
				e.printStackTrace();
			}
			return null;
		}
//		@Override
//		public int deleteCustomer(Customer custo) {
//			try (Connection conn = DriverManager.getConnection(url, username, password)) {
//			
//				
//				String sql = "SELECT * FROM customer where(customer_id)= ?";
//				
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ps.setInt(1, customer_id);//first question mark
//				//ps.setString(2, f_recipe);//second question mark
//
//				ps.executeUpdate();
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return 0;
//		}

	
		
}

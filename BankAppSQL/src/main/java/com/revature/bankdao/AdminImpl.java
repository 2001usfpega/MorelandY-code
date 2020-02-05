package com.revature.bankdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.revature.bankcustomer.Customer;

//import com.revature.bankdao.CustomerImpl.Admin;

public class AdminImpl implements AdminDao {

	private static String url = System.getenv("url");
	private static String username = System.getenv("username");
	private static String password = System.getenv("password");

	@Override
	public void addCusto(String customer_firstname, String customer_lastname, String customer_username,
			String customer_password, int checking_balance, int saving_balance) {
		
		
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO customer(customer_firstname, customer_lastname, customer_username, customer_password, checking_balance, saving_balance) VALUES(?,?,?,?,?,?)";

			
			PreparedStatement ps = conn.prepareStatement(sql);
			;
			ps.setString(1, customer_firstname);
			ps.setString(2, customer_lastname);
			ps.setString(3, customer_username);
			ps.setString(4, customer_password);
			ps.setInt(5, checking_balance);
			ps.setInt(6, saving_balance);


			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
		public List<Customer> selectAllCustomer() {
			
			
			List<Customer> customers = new ArrayList<>();
			
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				String sql = "SELECT * FROM customer ORDER BY customer_id";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					customers.add(
							new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
									rs.getInt(6), rs.getInt(7), rs.getInt(8))
					);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return customers;
		
	}
	@Override
	
	public int getCustoById(int customer_id) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			/*
			 * prepared statments guard against sql injections bc it is pre-complied (which
			 * also makes it faster)
			 */

			String sql = "SELECT * FROM customer where(customer_id)= ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer_id);// first question mark

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}		return 0;
	}

	@Override
	public int updateCusto(int checking_balance, int saving_balance, String customer_firstname,
			String customer_lastname) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "UPDATE customer SET checking_balance= ? , saving_balance= ? where customer_firstname= ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, checking_balance);
			ps.setInt(2, saving_balance);
			ps.setString(3, customer_firstname);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String deleteCusto(String customer_firstname, String customer_lastname) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "DELETE customer where customer_firstname= ? and customer_lastname = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customer_firstname);
			ps.setString(2, customer_lastname);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}		return null;
	}

	

}

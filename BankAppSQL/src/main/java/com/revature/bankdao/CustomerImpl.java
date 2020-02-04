package com.revature.bankdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankcustomer.Customer;

public class CustomerImpl implements CustomerDao {

	private static String url = System.getenv("url");
	private static String username = System.getenv("username");
	private static String password = System.getenv("password");

	@Override
	public Customer insertCustomer(int customer_id, String customer_firstname, String customer_lastname, String customer_username,
			String customer_password, int customer_accountnumber, int checking_balance, int saving_balance) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO customer VALUES(customer_id = ? , customer_firstname = ?, customer_lastname = ?, customer_username = ?, customer_password =?, customer_accountnumber = ?, checking_balance = ?, saving_balance = ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer_id);//first question mark
			ps.setString(2, customer_firstname);
			ps.setString(3, customer_lastname);
			ps.setString(4, customer_username);
			ps.setString(5, customer_password);
			ps.setInt(6, customer_accountnumber);
			ps.setInt(7, checking_balance);
			ps.setInt(8, saving_balance);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Customer selectAllCustomer() {
		Customer custos = new Customer();
		String customer_username = " ";
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM customer where customer_username =?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customer_username);

			ResultSet rs = ps.executeQuery();
			rs.next();

			custos.setCustomer_id(rs.getInt(1));
			custos.setCustomer_firstname(rs.getString(2));
			custos.setCustomer_lastname(rs.getString(3));
			custos.setCustomer_username(rs.getString(4));
			custos.setCustomer_password(rs.getString(5));
			custos.setCustomer_accountnumber(rs.getInt(6));
			custos.setChecking_balance(rs.getInt(7));
			custos.setSaving_balance(rs.getInt(8));
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(custos);
		return custos;
	}

	@Override
	public Customer selectCustomerByName(String customer_firstname, String customer_lastname) {
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
	public Customer updateCustomer(int checking_balance, int saving_balance, String customer_firstname) {
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
		return null;
	}

	@Override
	public void addCusto(int customer_id, String customer_firstname, String customer_lastname, String customer_username,
			String customer_password, int customer_accountnumber) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCustoById(int customer_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCusto(int checking_balance, int saving_balance, String customer_firstname,
			String customer_lastname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String deleteCusto(String customer_firstname, String customer_lastname) {
		// TODO Auto-generated method stub
		return null;
	}

}

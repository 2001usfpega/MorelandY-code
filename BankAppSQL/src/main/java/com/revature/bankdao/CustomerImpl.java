package com.revature.bankdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankcustomer.Customer;

public class CustomerImpl implements CustomerDao {

	private static String url = System.getenv("url");
	private static String username = System.getenv("username");
	private static String password = System.getenv("password");

	@Override
	public Customer insertCustomer(int customer_id, String customer_firstname, String customer_lastname,
			String customer_username, String customer_password, int customer_accountnumber, int checking_balance,
			int saving_balance) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO customer VALUES(customer_id = ? , customer_firstname = ?, customer_lastname = ?, customer_username = ?, customer_password =?, customer_accountnumber = ?, checking_balance = ?, saving_balance = ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer_id);// first question mark
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
	public Customer selectCustomerByUsername(String customer_username) {
		Customer us = new Customer();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "SELECT * FROM customer where customer_username= ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customer_username);
			// ps.setString(2, customer_lastname);

			ResultSet rs = ps.executeQuery();
			rs.next();

			us.setCustomer_id(rs.getInt(1));
			us.setCustomer_firstname(rs.getString(2));
			us.setCustomer_lastname(rs.getString(3));
			us.setCustomer_username(rs.getString(4));
			us.setCustomer_password(rs.getString(5));
			us.setCustomer_accountnumber(rs.getInt(6));
			us.setChecking_balance(rs.getInt(7));
			us.setSaving_balance(rs.getInt(8));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(us);
		return us;
	}

	@Override
	public Customer updateCustomer(int checking_balance, int saving_balance, String customer_username) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "UPDATE customer SET checking_balance= ? , saving_balance= ? where customer_username= ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, checking_balance);
			ps.setInt(2, saving_balance);
			ps.setString(3, customer_username);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer addCusto(String customer_firstname, String customer_lastname,
			String customer_username, String customer_password, int checking_balance,
			int saving_balance) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "INSERT INTO customer(customer_firstname, customer_lastname, customer_username, customer_password, checking_balance, saving_balance) VALUES(?,?,?,?,?,?)";

			Customer us = new Customer();
			PreparedStatement ps = conn.prepareStatement(sql);
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
		return null;
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
	public Customer deleteCustomer(String customer_username) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			      String sql = "SELECT checking_balance, saving_balance FROM customer WHERE customer_username = ?";

			      PreparedStatement ps = conn.prepareStatement(sql);
			      ps.setString(1,  customer_username);
			      ResultSet rs = ps.executeQuery();

			      if (rs.next() && rs.getInt(1) == 0 &&
			            rs.getInt(2) == 0) {
			         sql = "DELETE FROM customer WHERE customer_username = ?";

			         ps = conn.prepareStatement(sql);
			         ps.setString(1, customer_username);
			         ps.executeUpdate();
			         System.out.println("Your accounts have been successfully deleted.");
			         
			      }else{
			         System.out.println("You can not delete your account at this time.");
			      }

			         }catch(SQLException e){
			         e.printStackTrace();
			   }
		
			   return null;
			}

	

	@Override
	public void addCusto(String customer_firstname, String customer_lastname, String customer_username,
			String customer_password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String deleteCusto(String customer_firstname, String customer_lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	

		
	

}

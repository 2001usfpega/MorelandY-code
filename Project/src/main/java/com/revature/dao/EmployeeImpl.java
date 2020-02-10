package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;

public class EmployeeImpl {

	
	
	private static String url= System.getenv("PROJECT_UNO");
	private static String username= System.getenv("PROJECT_UNO_USER");
	private static String password=System.getenv("PROJECT_UNO_PASSWORD");
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public Employee selectEmployeeByUserName(String user_name) {
		List<Employee> empl = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "Select * from emp where username=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user_name);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				empl.add(
						new Employee( rs.getInt(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7)));
						
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return (empl.get(0) != null)? empl.get(0): null;
	}
	
	
	
	
	
	
	
	
//	public void create(int userid, String expensetype, int amount, int subdate, String status, String details) {
//		try (Connection conn = DriverManager.getConnection(url, username, password)) {
//			String sql = "INSERT INTO ticket(userid, expensetype, amount, subdate, status, details) VALUES(?,?,?,SYSTIMESTAMP,?,?)";
//
//			
//			PreparedStatement ps = conn.prepareStatement(sql);
//			;
//			ps.setInt(1, userid);
//			ps.setString(2, expensetype);
//			ps.setInt(3, amount);
//			ps.setString(5, status);
//			ps.setString(6, details);
//			
//
//
//			ps.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		}
	
	public void selectAllTickets(int userid, String expensetype, int amount, int subdate, String status, String details) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO ticket(userid, expensetype, amount, subdate, status, details) VALUES(?,?,?,SYSTIMESTAMP,?,?)";

			
			PreparedStatement ps = conn.prepareStatement(sql);
			;
			ps.setInt(1, userid);
			ps.setString(2, expensetype);
			ps.setInt(3, amount);
			ps.setString(5, status);
			ps.setString(6, details);
			


			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
	
	
	
	
	
}

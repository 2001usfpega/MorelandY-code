package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Ticket;

public class TicketImpl {
	
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

	
	public Ticket create(int userid, String expensetype, int amount, String status, String details) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO ticket(userid, expensetype, amount, subdate, status, details) VALUES(?,?,?, SYSTIMESTAMP,?,?)";

			
			PreparedStatement ps = conn.prepareStatement(sql);
			//ResultSet rs = ps.executeQuery();
			
			ps.setInt(1, userid);
			ps.setString(2, expensetype);
			ps.setInt(3, amount);
			ps.setString(4, status);
			ps.setString(5, details);
			


			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		}
	
	
		static {try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
	public static List<Ticket> selectAllTicket() {
		

		//{DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());}
		
		List<Ticket> tickets = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM ticket";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tickets.add(
						new Ticket(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
								rs.getString(6), rs.getString(7), rs.getString(8))
				);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return tickets;
	
}

}

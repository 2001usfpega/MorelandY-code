package com.revature.main;

import java.util.List;

import com.revature.dao.TicketImpl;
import com.revature.model.Ticket;

public class Main {
	private static String url= System.getenv("PROJECT_UNO");
	private static String username= System.getenv("PROJECT_UNO_USER");
	private static String password=System.getenv("PROJECT_UNO_PASSWORD");
	public static void main(String[] args) {
		TicketImpl ti = new TicketImpl();
		List<Ticket> tick = TicketImpl.selectAllTicket();
	//	EmployeeImpl  emp = new EmployeeImpl();
		
		
	
		
		
		
		
		//Employee em = new Employee();
		
		ti.create(23, "lodging", 75, " ", "Hotel for conference");
		
	tick = ti.selectAllTicket();
		
		System.out.println();
	}

}

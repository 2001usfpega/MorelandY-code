package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.EmployeeImpl;
import com.revature.dao.TicketImpl;
import com.revature.model.Employee;
import com.revature.model.Ticket;


//
//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.model.Ticket;
//
public class TicketController {

	public static String login(HttpServletRequest req) {
		
		
		String username = (String) req.getAttribute("uname");// name of the box. has to match what it is in "login
		String password = (String) req.getAttribute("passs");

		System.out.println(username);
		System.out.println(password);
		
		EmployeeImpl emp = new EmployeeImpl();
		Employee em = new Employee();
		
		TicketImpl ti = new TicketImpl();
		List<Ticket> tick = TicketImpl.selectAllTicket();
		Ticket tock = new Ticket();
		System.out.println(ti.selectAllTicket());
		tick = ti.selectAllTicket();

		req.getParameterMap().forEach((t,tt)->System.out.println(t +"  "+Arrays.toString(tt)));
		System.out.println(tick);
		
		int userid = ((Employee) req.getSession().getAttribute("employee")).getUserid();
		//int userid = Integer.parseInt(req.getParameter("userid"));
		String expensetype = req.getParameter("Type");
		System.out.println(expensetype);
		int amount = Integer.parseInt(req.getParameter("Amount"));
		
		String status = "pending";
		String details = req.getParameter("Details");
		
		System.out.println(expensetype);

		
//			req.getSession().setAttribute("loggedusername", username);
//			req.getSession().setAttribute("loggedpassword", password);
			ti.create(userid, expensetype, amount, status, details);
			return "resources/html/TicketTY.html";
		}
	
				
				
				
				
	//} Ticket(int userid, int ticketid, String expensetype, int amount, String subdate, String datereso,
//			String status, String details) {
//	
//	public static Ticket(HttpServletRequest req, HttpServletResponse res)
//			throws JsonProcessingException, IOException {
//		Ticket ti = new Ticket(expensetype =?, amount =?, details=?);
//		res.getWriter().write(new ObjectMapper().writeValueAsString(ti));
//	}
//
//}
//}

//Ticket tock = new Ticket();
//
//System.out.println(ti.selectAllTicket());
//tick = ti.selectAllTicket();
//
//System.out.println(tick);
//
//int userid = tock.getUserid();
//String expensetype = tock.getExpensetype();
//int amount = tock.getAmount();
//String status = tock.getStatus();
//String details = tock.getDetails();
//ti.create(userid, expensetype, amount, status, details);
	}

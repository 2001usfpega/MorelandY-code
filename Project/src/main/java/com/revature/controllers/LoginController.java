package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.EmployeeImpl;
import com.revature.dao.TicketImpl;
import com.revature.model.Employee;
import com.revature.model.Ticket;

public class LoginController {

	public static String login(HttpServletRequest req) {

		// return "resources/html/EmpHome.html";
		// System.out.println("anything");
		if (req.getMethod().equals("GET")) {
			return "/Login.change";
		}

		String username = req.getParameter("uname");// name of the box. has to match what it is in "login
														// placeholder" under login.html
		String password = req.getParameter("pass");

		System.out.println(username);
		System.out.println(password);

		EmployeeImpl emp = new EmployeeImpl();
		Employee em = emp.selectEmployeeByUserName(username);
		
		System.out.println("\nhi"+em);
		TicketImpl ti = new TicketImpl();
		List<Ticket> tick = TicketImpl.selectAllTicket();
		Ticket tock = new Ticket();

		System.out.println(ti.selectAllTicket());
		tick = ti.selectAllTicket();

		System.out.println(tick);
		
		int userid = tock.getUserid();
		String expensetype = tock.getExpensetype();
		int amount = tock.getAmount();
		String status = tock.getStatus();
		String details = tock.getDetails();
		
		System.out.println(em);

		if (em.getEmppassword()==password) {
			return "resources/html/Login.html";
		} else {

			req.getSession().setAttribute("employee", em);
			//req.getSession().setAttribute("loggedpassword", password);
			ti.create(userid, expensetype, amount, status, details);
			return "resources/html/TicketHome.html";
		}
	}

}

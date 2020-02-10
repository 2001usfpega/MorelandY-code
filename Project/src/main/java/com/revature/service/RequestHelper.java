package com.revature.service;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.controllers.HomeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.TicketController;



public class RequestHelper {
	
		
		public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
			System.out.println(req.getRequestURI());
			
			switch(req.getRequestURI()) {
//			case "/Project/EmpHome":
//				System.out.println("EmpHome");
//				return LoginController.login(req);
			case "/HomeController/Login.html":
				System.out.println("in home.change");
				return HomeController.home(req);
			case "/Project/Login.change":
				return LoginController.login(req);
			case "/Project/submit.change":
				return TicketController.login(req);
			case "/Project/admin.change":	
			default:
				System.out.println("in default case");
				return "resources/html/Login.html";
			}
		

	}

}

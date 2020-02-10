package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

public class HomeController {

	//one line of code
	public static String home(HttpServletRequest req) {
		return "/resources/html/TicketHome.html";
	}

}

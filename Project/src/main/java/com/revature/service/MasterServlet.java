package com.revature.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MasterServlet
 */
@WebServlet("/MasterServlet")
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.getWriter().append("Served at: ").append(request.getContextPath());

	//	if (!username.equals("YM") && password.equals("More")) {
			//HttpSession session = request.getSession();
			//session.setAttribute("username", username);
			
			
//			response.sendRedirect("/Project/resources/html/Login.html");
//				
//			
//			
//
//		} else {
//			response.sendRedirect("/Project/resources/html/Login.html");
//
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.getRequestDispatcher(RequestHelper.process(request,response)).forward(request, response);
		
	}

}

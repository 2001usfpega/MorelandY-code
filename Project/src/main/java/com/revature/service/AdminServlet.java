package com.revature.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.TicketImpl;
import com.revature.model.Ticket;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	}
//		TicketImpl ti = new TicketImpl();
//		List<Ticket> tick = TicketImpl.selectAllTicket();
//		
//		PrintWriter out = res.getWriter();
//		System.out.println("<html>");
//		System.out.println("<title> Reimbursement Requests </title>");
//		System.out.println("<body>");
//		System.out.println("<h2> Reimbursement Requests </h2>");
//		
//		System.out.println("<table>");
//		System.out.println("<tr> <th>Userid</th> <th>Ticketid</th><th>ExpenseType</th>"
//				+ "<th>Amount</th><th>SubDate</th><th>DateReso</th>"
//				+ "<th>Status</th><th>Details</th>");
		
//		For(Tick ti: tick){
//			System.out.println("<tr> <td>" + ((Tick) ti).getUserid() + "</td>"
//									+ "<td>" + ti.getUsername() + "</td>"
//									+ "<td>" + ti.getTicketId() + "</td>"
//									+ "<td>" + ti.getExpensetype() + "</td>"
//									+ "<td>" + ti.getAmount() + "</td>"
//									+ "<td> + ti.getSubDate() + "</td>"
//									+ "<td>" + ti.DateReso() + "</td>"
//									+ "<td>" + ti.getStatus() + "</td>"
//									+ "<td>" + it.getDetails() + "</td>");
//		
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

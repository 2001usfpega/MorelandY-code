package com.revature.model;

public class Ticket {
	public Ticket() {
	}
		private int userid;
		private int ticketid;
		private String expensetype;
		private int amount;
		private String subdate;
		private String  datereso;
		private String status;
		private String details;
		public Ticket(int userid, int ticketid, String expensetype, int amount, String subdate, String datereso,
				String status, String details) {
			
			this.userid = userid;
			this.ticketid = ticketid;
			this.expensetype = expensetype;
			this.amount = amount;
			this.subdate = subdate;
			this.datereso = datereso;
			this.status = status;
			this.details = details;
		}
		
		
		public Ticket(int userid, String expensetype, int amount, String status, String details) {
			
			this.userid = userid;
			this.expensetype = expensetype;
			this.amount = amount;
			this.status = status;
			this.details = details;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public int getTicketid() {
			return ticketid;
		}
		public void setTicketid(int ticketid) {
			this.ticketid = ticketid;
		}
		public String getExpensetype() {
			return expensetype;
		}
		public void setExpensetype(String expensetype) {
			this.expensetype = expensetype;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getSubdate() {
			return subdate;
		}
		public void setSubdate(String subdate) {
			this.subdate = subdate;
		}
		public String getDatereso() {
			return datereso;
		}
		public void setDatereso(String datereso) {
			this.datereso = datereso;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		@Override
		public String toString() {
			return "Ticket [userid=" + userid + ", ticketid=" + ticketid + ", expensetype=" + expensetype + ", amount="
					+ amount + ", subdate=" + subdate + ", datereso=" + datereso + ", status=" + status + ", details="
					+ details + "]";
		}
		
		
		

}

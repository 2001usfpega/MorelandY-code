package com.revature.model;

public class Employee {

	public Employee() {

	}

	private int userid;
	private String username;
	private String emppassword;
	private String firstname;
	private String lastname;
	private int ticketid;
	private boolean is_manager;
	public Employee(int userid, String username, String emppassword, String firstname, String lastname, int ticketid,
			boolean is_manager) {
		super();
		this.userid = userid;
		this.username = username;
		this.emppassword = emppassword;
		this.firstname = firstname;
		this.lastname = lastname;
		this.ticketid = ticketid;
		this.is_manager = is_manager;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmppassword() {
		return emppassword;
	}
	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getTicketid() {
		return ticketid;
	}
	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}
	public boolean isIs_manager() {
		return is_manager;
	}
	public void setIs_manager(boolean is_manager) {
		this.is_manager = is_manager;
	}
	@Override
	public String toString() {
		return "Employee [userid=" + userid + ", username=" + username + ", emppassword=" + emppassword + ", firstname="
				+ firstname + ", lastname=" + lastname + ", ticketid=" + ticketid + ", is_manager=" + is_manager + "]";
	}
	
	
	

}

package com.revature.banking;

//package com.revature;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import com.revature.bean.Person;
//import com.revature.io.IOWithCollections;

public class EmpAdm implements Serializable {
	public static final long serialVersionID = 12345678L;
	private static final String inFile = ("Bank.txt");

	private String username;
	private String password;
	private String name;
	private int ID;
	static ArrayList<EmpAdm> ba = new ArrayList<EmpAdm>();
	//static ArrayList<BaAdm>

	public EmpAdm() {

	}

	public EmpAdm(String username, String password, String name, int ID) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.ID = ID;
	}

	@Override
	public String toString() {
		return "Account \nUsername= " + username + "\nPassword= " + password + "\nName= " + name + " \nID= " + ID +  "\n";
	}


	
	public List<EmpAdm> getList() {
		return ba;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		//initalizeTestArray();
		loadAll();
		
		for(EmpAdm a: ba) {
			System.out.println(a.toString()); 
		}
		
		saveAll();
	}

	// serialization
	public static void saveAll() {
		try {
			ObjectOutputStream out = null;
			FileOutputStream file = null;
			
			// Saving of object in a file
			
			file = new FileOutputStream("Data.txt");
			//Users//Yzairyen//Documents//workspace-spring-tool-suite-4-4.5.0.RELEASE//Working Bank App//src//com//revature//banking//Data.txt"
			out = new ObjectOutputStream(file);
			// (/Users/Yzairyen/Documents/workspace-spring-tool-suite-4-4.5.0.RELEASE/BankingApp/src/com/revature/Bank.txt);
			// Method for serialization of object
			out.writeObject(ba);

			out.close();
			file.close();

			System.out.println("Object has been serialized\n" + "Data before Deserialization.");

		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
		
	}
	
	public static void loadAll() {
		try{
			FileInputStream file = new FileInputStream("Data.txt");
					
			ObjectInputStream in = new ObjectInputStream(file);
			ba=(ArrayList<EmpAdm>)in.readObject();
			in.close();
			file.close();

			}catch(
			FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();

			}catch(
			ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();}catch(
			IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	public static void initalizeTestArray() {
		ba.add(new EmpAdm("Llangford","Encapsulation","Lauren Lanford",1));
		ba.add(new EmpAdm("Ymore","Abstraction","Yzairyen Moreland",2));
	}
	

	
	//ArrayList<EmpAdm> ba = new ArrayList<EmpAdm>();
//	 for (EmpAdm unsort: ba) {
//		 System.out.println(ba);
//	 }

//	// write method
	public static void writeOutputStreamContents(String contents) {
		ObjectOutputStream objectOut;
		try {
			objectOut = new ObjectOutputStream(new FileOutputStream("Data.txt"));// highlights file not found so do try
																					// catch block
			objectOut.writeObject(ba);// pass in person file
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}

//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getID() {
//		return ID;
//	}
//	public void setID(int iD) {
//		ID = iD;
//	}
////	@Override
////	public String toString() {
////		return "Account [username=" + username + ", password=" + password + ", name=" + name + ", ID=" + ID + "]";
////	}	
//
//}
//class BankAccount{
//	double balanceChecking;
//	double balanceSaving;
//	
//	void deposit(double amount) {
//		balanceChecking += amount;
//		balanceSaving += amount;		
//	}
//	
//}

	// Reading the object from a file
	

	// Method for deserialization of object

	// file.close();
//	System.out.println("Object has been deserialized\n"+"Data after Deserialization.");
//	InputStream is = null;
//	// reference to file
//	File fi = new File("Bank.txt");
//	StringBuilder s = new StringBuilder();// use string builder bc it is readable (memory management)
//	try{is=new FileInputStream(fi);// set input stream to a new file
//	// create an int variable b make it equal to something bc it does not get a
//	// default value (block scope doesnt get default value)
//	int b = 0;// initialize an int variable to that we can go from that char to whatever int
//				// value
//	try
//	{
//		while ((b = is.read()) != -1) {// data being read is binary//-1 is the end of the string
//			char c = (char) b;// take char and reference int variable (b)
//			s.append(c);
//
//		}
//		is.close();
//	}catch(
//	FileNotFoundException e)
//	{// FNF must go before IO exception bc a FNF exception is an IO expection
//
//		e.printStackTrace();
//	}}catch(
//	IOException e)
//	{
//
//		e.printStackTrace();
//	}

//		 IOWithCollections.readPersonFile();
//		 System.out.println(IOWithCollections.personList.toString());
	// System.out.println("z = " + object1.z);
//	class IOWithCollections{
			
//			private static final String personFile = "Bank.txt";
//			public static List<EmpAdm> ba = new ArrayList<EmpAdm>();
//		IOWithCollections.writePersonFile();
//		 IOWithCollections.readPersonFile();
//		 System.out.println(IOWithCollections.ba.toString());
		
		
//catch (IOException ex) { 
//  System.out.println("IOException is caught"); 
//} 
//
//catch (ClassNotFoundException ex) { 
//  System.out.println("ClassNotFoundException" + 
//                      " is caught"); 
////}
//
//		for (EmpAdm eachAcct : ba) {
//			System.out.println(eachAcct);
//		}
//	}
//}
//experiment

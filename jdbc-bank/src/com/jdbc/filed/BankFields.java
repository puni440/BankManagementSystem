package com.jdbc.filed;

public class BankFields {
	public static final String Bank_Name = " BCA FRIENDS BANK";
	public static int Acc_no;
	public static String Name;
	public static int DOB;
	public static String Address;
	public static Long Phone_no;
	public static int Amount;
	public static String Complaint;
	
	
	public BankFields(String name, int dob, String address, Long ph, int money,String complaint) {
		super();
		Name = name;
		DOB = dob;
		Address = address;
		Phone_no = ph;
		Amount = money;
		Complaint = complaint;
		
		
	}


	public BankFields(int acc_no, String name, int dob, String address, long ph, int money, String complaint) {
		// TODO Auto-generated constructor stub
		super();
		Acc_no =acc_no;
		Name = name;
		DOB = dob;
		Address = address;
		Phone_no = ph;
		Amount = money;
		Complaint = complaint;
	}


	public BankFields(int aCC, String com) {
		// TODO Auto-generated constructor stub
		Acc_no=aCC;
		Complaint =com;
	}


	public BankFields(int aCC, int amount) {
		// TODO Auto-generated constructor stub
		Acc_no = aCC;
		Amount = amount;
	}
	
	

}

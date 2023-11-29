package com.jdbc.database;

public class DbQuery {
	
	public static String openAccountQuery() {
		
		return "INSERT INTO BANK_MANAGEMENT(NAME,DOB,ADDRESS,PHONE_NUMBER,BALANCE) VALUES(?,?,?,?,?)";
		
	}

	public static String viewAllProfiletQuery() {
		
		return "SELECT *FROM BANK_MANAGEMENT";
	}

	public static String deleteAccQuery(int acc) {
		// TODO Auto-generated method stub
		
		return "DELETE FROM BANK_MANAGEMENT WHERE ACCOUNT_NUMBER = "+acc;
	}

	public static String viweByAccNoQuery(int acc) {
		// TODO Auto-generated method stub
		return "SELECT * FROM BANK_MANAGEMENT WHERE ACCOUNT_NUMBER = "+acc;
	}

	public static String complaintQuery(int acc) {
		// TODO Auto-generated method stub
		return "UPDATE BANK_MANAGEMENT SET BALANCE = BALANCE - ?  WHERE ACCOUNT_NUMBER = "+acc;
	}

	public static String withdrawnQuery(int acc_no) {
		// TODO Auto-generated method stub
		return "";
	}


}

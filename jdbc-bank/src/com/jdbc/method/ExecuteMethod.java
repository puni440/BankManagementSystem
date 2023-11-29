package com.jdbc.method;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


import com.jdbc.database.DbCon;
import com.jdbc.database.DbQuery;
import com.jdbc.filed.BankFields;

public class ExecuteMethod {

	DbCon dbcon = new DbCon();

	@SuppressWarnings({ "static-access" })
	private void print(BankFields bankFields) {

		System.out.println("\n\n          :-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-:\n");
		System.out.println("          *******" + bankFields.Bank_Name + "*****\n\n\n");
		System.out.println("          Account Number :- " + bankFields.Acc_no);
		System.out.println("          Account Holder Name :- " + bankFields.Name);
		System.out.println("          Date of Birth :- " + bankFields.DOB);
		System.out.println("          Address :- " + bankFields.Address);
		System.out.println("           Mobile NO :-" + bankFields.Phone_no);
		System.out.println("           Balance :- " + bankFields.Amount);
		System.out.println("           Complaint :- " + bankFields.Complaint);
		System.out.println("\n          :-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-:\n\n");

	}// end of printStudent();

	@SuppressWarnings("static-access")
	public void openAccount(BankFields bankFields) throws SQLException {

		try (Connection connection = dbcon.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DbQuery.openAccountQuery());) {

			preparedStatement.setString(1, bankFields.Name);
			// preparedStatement.setInt(2,bankFields.Acc_no);
			preparedStatement.setInt(2, bankFields.DOB);
			preparedStatement.setString(3, bankFields.Address);
			preparedStatement.setLong(4, bankFields.Phone_no);
			preparedStatement.setInt(5, bankFields.Amount);

			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("Acount opened Successfull ");
				System.out.println("Remember Your Account Number ");
			} else {
				System.out.println("Failed to Open account ");
			}

		}

	}// End of openAccount();

	public void viewAllProfile() throws SQLException {

		try (Connection connection = dbcon.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(DbQuery.viewAllProfiletQuery());) {

			while (resultSet.next()) {

				print(new BankFields(resultSet.getInt("ACCOUNT_NUMBER"), resultSet.getString("NAME"),
						resultSet.getInt("DOB"), resultSet.getString("ADDRESS"), resultSet.getLong("PHONE_NUMBER"),
						resultSet.getInt("BALANCE"), resultSet.getString("COMPLAINT")));
			}

		}

	}// End of viewAllProfile();

	public void deleteAcc(int acc) throws SQLException {
		// TODO Auto-generated method stub

		try (Connection connection = dbcon.getConnection(); Statement statement = connection.createStatement();) {
			int rows = statement.executeUpdate(DbQuery.deleteAccQuery(acc));
			if (rows > 0) {
				System.out.println("YOUR ACCOUNT IS CLOSED");
			} else {
				System.out.println("Failed to close your account try again..");
			}

		}

	}// End of deleteAcc();

	public void viewByAccNo(int acc) throws SQLException {

		@SuppressWarnings("unused")
		boolean isFound = false;

		try (Connection connection = dbcon.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(DbQuery.viweByAccNoQuery(acc));) {

			if (resultSet.next()) {
				isFound = true;
				print(new BankFields(resultSet.getInt("ACCOUNT_NUMBER"), resultSet.getString("NAME"),
						resultSet.getInt("DOB"), resultSet.getString("ADDRESS"), resultSet.getLong("PHONE_NUMBER"),
						resultSet.getInt("BALANCE"), resultSet.getString("COMPLAINT")));

			} else {
				System.out.println("      Account not Found !!!!  ");
			}
		}

	}

	@SuppressWarnings({ "unused", "resource" })
	public void editAccount(int acc) {
		// TODO Auto-generated method stub

		System.out.println("Which Data You want to Edit ? ");
		System.out.println("chouse the number which you want to change \n"
				+ " 1.Name , 2.Date of birth , 3.Adress ,5.Phone Number");
		int choice;
		String name;
		int dob;
		Scanner scan = new Scanner(System.in);
		while (true) {

			choice = scan.nextInt();
			switch (choice) {
			case 1:

				break;

			default:
				break;
			}
			break;
		}

	}// End of editAccount();

	@SuppressWarnings("static-access")
	public void complaint(BankFields bankFields) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection connection = dbcon.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(DbQuery.complaintQuery(bankFields.Acc_no));) {
			preparedStatement.setString(1, bankFields.Complaint);
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("...Complaint raised successfully ...");
			} else {
				System.out.println("...Failed to Complaint ...");
			}

		}

	}// End of complaint();

	@SuppressWarnings("static-access")
	public void withdrawn(BankFields bankFields) throws SQLException {
		// TODO Auto-generated method stub

		try (Connection connection = dbcon.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(DbQuery.withdrawnQuery(bankFields.Acc_no));) {
			preparedStatement.setInt(1, bankFields.Amount);
			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {
				System.out.println("...Money Withdrawn successfully ...");
			} else {
				System.out.println("...Failed to Get Money ...");
			}

		}

	}// End of withdrawn();

}

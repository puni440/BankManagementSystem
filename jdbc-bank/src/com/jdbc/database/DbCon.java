package com.jdbc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbCon {
	
	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcdb";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "puni352004";

	public DbCon() {
		try {
			Class.forName(DRIVER_PATH);
		} catch (Exception e) {
			throw new RuntimeException("\n\n.....Somthing went worng...." + e);
		}
	}// End of Constructor()

	public Connection getConnection() throws SQLException {

		return DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
	}// End of getConnection()

}

package com.myjdbc.mypsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
//			TODO See password for Sandip
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/temp_db", "sandip", null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}

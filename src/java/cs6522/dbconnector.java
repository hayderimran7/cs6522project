/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs6522;

import java.sql.*;

/**
 *
 * @author imalik
 */
public class dbconnector {

	public Connection conn;
	public Statement stmt;

	public dbconnector() throws Exception {
		try {
			String username = "root";
			String password = "";
			String url = "jdbc:mysql://127.0.0.1/cs6522project?allowMultiQueries=true";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.err
					.println("DB Connection failed. See Error Below \n");
			System.err.println(e.getMessage());
			throw (e);
		}

	}

	public void closeConnection() throws Exception {
		conn.close();
	}
}

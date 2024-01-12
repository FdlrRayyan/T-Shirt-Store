package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	private final String USERNAME = "root"; 	// MySQL Username
	private final String PASSWORD = ""; 		// MySQL Password
	private final String DATABASE = "t_shirt";	// MySQL Database
	private final String HOST = "localhost:3306"; // MySQL Host
	
	// format Connection
	// //%s/%s
	// HOST DATABASE
	private final String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);
	
	private Connection connection;
	private Statement statement;
	public ResultSet rs;
	
	private static Connect instance;

	private Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			statement = connection.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connect getInstance() {
		if (instance == null) {
			instance = new Connect();
		}
		return instance;
	}
	
	public ResultSet execQuery(String query) {
		try {
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void execUpdate(String query) {
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PreparedStatement prepareStatement(String query) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}


}

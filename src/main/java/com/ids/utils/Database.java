package com.ids.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class Database {
	public final static String DB_URL = "jdbc:postgresql://localhost/facture";
	public final static String DB_USER = "postgres";
	public final static String DB_PASSWORD = "fwefwe";
	
	public Connection getConnection() throws SQLException {
//        Class.forName("org.postgresql.Driver");
		Properties props = new Properties();
		props.setProperty("user", DB_USER);
		props.setProperty("password", DB_PASSWORD);
		return DriverManager.getConnection(DB_URL, props);
	}
	
	
	public void execute(String sql) throws SQLException {
//		DataSource ds = null;
//		ds.get
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		statement.execute(sql);
		statement.close();
		connection.close();
	}
	
}

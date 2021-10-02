package com.ids.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Cleanup;

@Component
public class Database {
//	public final static String DB_URL = "jdbc:postgresql://localhost/facture";
//	public final static String DB_USER = "postgres";
//	public final static String DB_PASSWORD = "postgres";
	
	@Autowired
	private DataSource dataSource;
	
	public Connection getConnection() {
//        Class.forName("org.postgresql.Driver");
//		Properties props = new Properties();
//		props.setProperty("user", DB_USER);
//		props.setProperty("password", DB_PASSWORD);
//		return DriverManager.getConnection(DB_URL, props);
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void execute(String sql) {
		try {
			@Cleanup Connection connection = getConnection();
			Statement statement = connection.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void execute(String sql, Object[] args) {
		try {
			@Cleanup Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				statement.setObject(i + 1, args[i]);
			}
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public <T> List<T> query(String sql, Object[] args, Function<ResultSet, T> mapper) {
		List<T> list = new ArrayList<>();
		try {
			@Cleanup Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					statement.setObject(i + 1, args[i]);
				}
			}
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				// creation d un article a partir d un resultset
//				Article a = new Article(rs.getString("id"), rs.getString("designation"), rs.getDouble("pu"), rs.getString("unite"));
				list.add(mapper.apply(rs));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

}

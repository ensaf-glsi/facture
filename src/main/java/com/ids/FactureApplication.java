package com.ids;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ids.utils.Database;

@SpringBootApplication
public class FactureApplication implements CommandLineRunner {
	
	@Autowired
	private Database database;

	public static void main(String[] args) {
		SpringApplication.run(FactureApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Connection connection = database.getConnection();
		System.out.println("connexion a la bd cree avec succes  :  " + connection);
	}

}

package com.ids;

import java.sql.Connection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ids.entity.Article;
import com.ids.repository.JdbcArticleRepository;
import com.ids.utils.Database;

@SpringBootApplication
public class FactureApplication implements CommandLineRunner {
	
	@Autowired
	private Database database;
	
	@Autowired
	private JdbcArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(FactureApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Connection connection = database.getConnection();
		System.out.println("connexion a la bd cree avec succes  :  " + connection);
		
//		articleRepository.save(Article.builder()
//				.id(UUID.randomUUID().toString())
//				.designation("clavier")
//				.pu(30.)
//				.unite("U")
//				.build()
//				
//		);
//		articleRepository.update(Article.builder()
//				.id("20fe781e-bd6e-4961-83ec-c759b3d67ff4")
//				.designation("souris")
//				.pu(35.)
//				.unite("U")
//				.build()
//				
//		);
		articleRepository.findById("20fe781e-bd6e-4961-83ec-c7593d67ff4").ifPresent(System.out::println);
//		Optional<Article> article = articleRepository.findById("20fe781e-bd6e-4961-3ec-c759b3d67ff4");
//		System.out.println(article);
		
		articleRepository.findAll().forEach(System.out::println);
	}

}

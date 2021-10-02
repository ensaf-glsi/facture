package com.ids;

import java.sql.Connection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ids.entity.Client;
import com.ids.repository.ClientRepository;
import com.ids.repository.JdbcArticleRepository;
import com.ids.utils.Database;

@SpringBootApplication
public class FactureApplication implements CommandLineRunner {
	
	@Autowired
	private Database database;
	
	@Autowired
	private JdbcArticleRepository articleRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
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

//		clientRepository.save(
//			Client.builder().id(UUID.randomUUID().toString())
//					.nom("Anwar").ice("1234114").email("anwar@gmail.com")
//					.build()
//				
//		);

//		clientRepository.update(Client.builder().id("80b3c640-f6d0-4fbe-8780-1eeeacfd25cf")
//				.nom("Khaled").ice("123456").email("khaled@gmail.com")
//				.build());
		
		System.out.println("=== nom client par id");
		clientRepository.findNameById("80b3c640-f6d0-4fbe-8780-1eeeacfd25cf ").ifPresent(System.out::println);
		System.out.println("=== client par id");
		clientRepository.findById("80b3c640-f6d0-4fbe-8780-1eeeacfd25cf").ifPresent(System.out::println);
		System.out.println("=== liste des clients");
		clientRepository.findAll().forEach(System.out::println);

	}

}

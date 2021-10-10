package com.ids;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ids.entity.Article;
import com.ids.entity.Client;
import com.ids.repository.ArticleRepository;
import com.ids.repository.ClientRepository;

@SpringBootApplication
public class FactureApplication implements CommandLineRunner {
	
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FactureApplication.class, args);
	}
	
	void ex1() {
		articleRepository.save(
				Article.builder().designation("clavier").pu(40.).build()
		);
		articleRepository.findAll().forEach(System.out::println);
	}
	
	void ex2() {
		clientRepository.save(
				Client.builder().nom("zouhir").ice("1234")
				.email("zouhir@gmail.com").build()
		);
		clientRepository.findAll().forEach(System.out::println);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

//		ex1();
		ex2();
	}

}

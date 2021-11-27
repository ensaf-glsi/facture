package com.ids;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ids.contact.Article;
import com.ids.contact.ArticleService;
import com.ids.contact.Client;
import com.ids.contact.ClientService;

@SpringBootApplication
@EnableFeignClients
public class Application {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private ArticleService articleService;

	void exClient() {
		System.out.println("Avant :" + clientService.list().size());
		Client c = clientService.save(Client.builder().email("zineb@gmail.com").nom("zineb").build());
		System.out.println(c);
		System.out.println("Apres :" + clientService.list().size());
		clientService.delete(c.getId());
		System.out.println("Apres suppression :" + clientService.list().size());
	}
	
	void exArticle() {
		System.out.println("Avant :" + articleService.list().size());
		Article c = articleService.save(Article.builder().designation("clavier bt").pu(60d).build());
		System.out.println(c);
		System.out.println("Apres :" + articleService.list().size());
		articleService.delete(c.getId());
		System.out.println("Apres suppression :" + articleService.list().size());
	}
	
	@PostConstruct
	void init() {
		exArticle();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

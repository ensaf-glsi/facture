package com.ids;

import java.sql.Connection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ids.entity.Article;
import com.ids.repository.ArticleRepository;
import com.ids.repository.JdbcArticleRepository;
import com.ids.utils.Database;

//@EnableJdbcRepositories
@SpringBootApplication
public class FactureApplication implements CommandLineRunner {
	
	@Autowired
	private Database database;
	
	@Autowired
	private JdbcArticleRepository jdbcArticleRepository;
	
	@Autowired
	private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(FactureApplication.class, args);
	}
	
	void nbrArticles() {
		System.out.println("Nombre des articles ");
		System.out.println(articleRepository.count());		
	}
	void listArticles() {
		System.out.println("liste des articles");
		articleRepository.findAll().forEach(System.out::println);		
	}
	
	@Override
	public void run(String... args) throws Exception {
		Connection connection = database.getConnection();
		System.out.println("connexion a la bd cree avec succes  :  " + connection);
		
		System.out.println(articleRepository);
		
		nbrArticles();
		listArticles();
		
		System.out.println("recuper un article par id");
		articleRepository.findById("3546b474-0ecb-4bc0-bc39-2bec612ebf96").ifPresent(System.out::println);
		System.out.println("article existe par id : " + articleRepository.existsById("3546b474-0ecb-4bc0-bc39-2bec612ebf96"));
		articleRepository.deleteById("3546b474-0ecb-4bc0-bc39-2bec612ebf96");
		nbrArticles();

		System.out.println("update d un article");
		articleRepository.save(Article.builder()
				.id("20fe781e-bd6e-4961-83ec-c759b3d67ff4")
				.designation("souris")
				.pu(38.)
				.unite("U")
				.build()
				
		);
		System.out.println("ajout d un article");
		articleRepository.save(Article.builder()
				.designation("claver")
				.pu(45.)
				.unite("U")
				.build()
				
				);
		listArticles();
		
//		articleRepository.update(Article.builder()
//				.id("20fe781e-bd6e-4961-83ec-c759b3d67ff4")
//				.designation("souris")
//				.pu(35.)
//				.unite("U")
//				.build()
//				
//		);
//		jdbcArticleRepository.findById("20fe781e-bd6e-4961-83ec-c7593d67ff4").ifPresent(System.out::println);
////		Optional<Article> article = articleRepository.findById("20fe781e-bd6e-4961-3ec-c759b3d67ff4");
////		System.out.println(article);
//		
//		jdbcArticleRepository.findAll().forEach(System.out::println);
	}

}

package com.ids;


import java.sql.Connection;
import java.time.Instant;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ids.entity.Article;
import com.ids.entity.Client;
import com.ids.entity.Facture;
import com.ids.repository.ArticleRepository;
import com.ids.repository.ClientRepository;
import com.ids.repository.FactureRepository;
import com.ids.utils.Database;


@SpringBootApplication
public class FactureApplication implements CommandLineRunner {
	
	@Autowired
	private Database database;
	
//	@Autowired
//	private JdbcArticleRepository jdbcArticleRepository;
	
	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private FactureRepository factureRepository;
	
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
		
//		System.out.println("recuper un article par id");
//		articleRepository.findById("20fe781e-bd6e-4961-83ec-c759b3d67ff4").ifPresent(System.out::println);
//		System.out.println("article existe par id : " + articleRepository.existsById("3546b474-0ecb-4bc0-bc39-2bec612ebf96"));
//		articleRepository.deleteById("3546b474-0ecb-4bc0-bc39-2bec612ebf96");
//		nbrArticles();

//		System.out.println("update d un article");
//		articleRepository.save(Article.builder()
//				.id("20fe781e-bd6e-4961-83ec-c759b3d67ff4")
//				.designation("souris")
//				.pu(38.)
//				.uniteVente("U")
//				.uniteStock("US")
//				.build()
//				
//		);
//		System.out.println("ajout d un article");
//		articleRepository.save(Article.builder()
//				.designation("ecran")
//				.pu(1100.)
//				.uniteVente("U")
//				.build()
//				
//				);
//		listArticles();
		
		
//		clientRepository.save(Client.builder().email("zouhir@gmail.com").nom("zouhir").build());
//		clientRepository.findAll().forEach(System.out::println);
//		System.out.println("clients par nom");
//		clientRepository.findByNom("zouhir").forEach(System.out::println);
//		System.out.println("un client par email");
//		clientRepository.findFirstByEmail("zouhir@gmail.com").ifPresent(System.out::println);
//
//		System.out.println("clients par %nom%");
//		clientRepository.findByNomContainingIgnoreCase("H").forEach(System.out::println);
//		
////		clientRepository.deleteClientWithIceNull();
//		
//		System.out.println("client : utilisation @query");
//		clientRepository.findByNomOrEmail("%zouHir%").forEach(System.out::println);

//		factureRepository.save(
//				Facture.builder()
//				.dateFacturation(LocalDate.now()).build());
		factureRepository.save(
				Facture.builder()
				.id(4l).build());
		factureRepository.findAll().forEach(System.out::println);
		
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
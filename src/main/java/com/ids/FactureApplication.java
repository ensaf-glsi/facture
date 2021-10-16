package com.ids;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.ids.entity.Article;
import com.ids.entity.Category;
import com.ids.entity.Client;
import com.ids.entity.Facture;
import com.ids.entity.LigneFacture;
import com.ids.repository.ArticleRepository;
import com.ids.repository.CategoryRepository;
import com.ids.repository.ClientRepository;
import com.ids.service.FactureService;

@SpringBootApplication
public class FactureApplication implements CommandLineRunner {
	
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FactureService factureService;
	
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
				Client.builder().nom("zouhir").ice(UUID.randomUUID().toString())
				.email(UUID.randomUUID().toString() + "@gmail.com").build()
		);
		clientRepository.findAll().forEach(System.out::println);
	}
	
	void ex3() {
		Category cat = Category.builder().nom("ecrans").build();
		String id = UUID.randomUUID().toString();
		cat.setId(id);
		System.out.println("--- categorie avant insertion");
		System.out.println(cat);
		Category c = categoryRepository.save(cat);
		System.out.println("--- categorie apres insertion");
		System.out.println(c);
		c.setNom("Ecrans");
		categoryRepository.save(c);
		System.out.println("--- récuperer une categorie par son id");
		categoryRepository.findById(id).ifPresent(System.out::println);
		System.out.println("--- liste des categories");
		categoryRepository.findAll().forEach(System.out::println);
	}
	
	void ex4() {
		System.out.println("--- chercher la liste des articles contenant le mot 'avier'");
		articleRepository.findByDesignationContaining("avier").forEach(System.out::println);
		articleRepository.findByDesignationContainingNative("avier").forEach(System.out::println);
	}
	
	void ex5() {
		System.out.println("--- exemple de sort by id");
		clientRepository.findByAndSort("zouhir", Sort.by("id"))
			.forEach(System.out::println);
		System.out.println("--- exemple de sort by ville");
		clientRepository.findByAndSort("zouhir", Sort.by("adresse.ville").descending())
			.forEach(System.out::println);
		System.out.println("--- exemple de sort by pays and ville");
		clientRepository.findByAndSort("zouhir", Sort.by("adresse.pays").and(Sort.by("adresse.ville")))
			.forEach(System.out::println);
		
		
	}
	Long newClient() {
		return clientRepository.save(
				Client.builder().nom("khaled").ice(UUID.randomUUID().toString())
				.email(UUID.randomUUID().toString() + "@gmail.com").build()
		).getId();
	}
	
	Long newArticle(String designation, Double pu) {
		return articleRepository.save(
				Article.builder().designation(designation).pu(pu).build()
		).getId();
	}
	
	void ex6() {
		clientRepository.findByIce("123").forEach(System.out::println);
	}
	
	void ex7() {
		Long clientId = newClient();
		Long p1 = newArticle("Ecran", 1300.);
		Long p2 = newArticle("UC HP i5", 2500.);
		
//		List<LigneFacture> lignes = new ArrayList<LigneFacture>();
//		lignes.add(LigneFacture.builder()
//				.article(new Article().id(p1))
//				.quantite(3d)
//				.pu(1200.)
//				.build()
//		);
//		lignes.add(LigneFacture.builder().article(new Article().id(p2))
//			.quantite(3d).pu(3200.).build())
//		);
//		
//		Facture f1 = Facture.builder().client(new Client().id(clientId))
//				.dateFacturation(LocalDate.now()).lignes(lignes)
//			.build();

		Facture f1 = Facture.builder().client(new Client().id(clientId))
				.dateFacturation(LocalDate.now())
				.ligne(
						LigneFacture.builder().article(new Article().id(p2))
							.quantite(3d).pu(3200.).build())
				.ligne(LigneFacture.builder().article(new Article().id(p1))
						.quantite(3d).pu(1200.).build())
			.build();
		System.out.println("Creation d'une facture");
		f1 = factureService.save(f1);
		
		System.out.println("--- liste des factures");
		factureService.findAll().forEach(System.out::println);
		
//		System.out.println("--- modification d'une facture");
//		
//		Facture facture1 = Facture.builder().client(new Client().id(clientId))
//				.ligne(
//						LigneFacture.builder().article(new Article().id(p2))
//							.quantite(3d).pu(3200.).build())
//			.build().id(f1.getId());
//		factureRepository.save(facture1);
//		System.out.println("suppression d une facture");
//		factureRepository.deleteById(f1.getId());
		
		System.out.println("Recuperation des lignes");
		Optional<Facture> facture1 = factureService.findById(f1.getId());
//		facture1.get().getLignes().forEach(System.out::println);
		
	}

	@Override
	public void run(String... args) throws Exception {

//		ex1();
//		ex2();
//		ex3();
//		ex4();
//		ex5();
//		ex6();
		ex7();
	}

}

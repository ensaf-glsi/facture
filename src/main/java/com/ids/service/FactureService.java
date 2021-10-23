package com.ids.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ids.entity.Article;
import com.ids.entity.Client;
import com.ids.entity.Facture;
import com.ids.entity.LigneFacture;
import com.ids.repository.ArticleRepository;
import com.ids.repository.ClientRepository;
import com.ids.repository.FactureRepository;

@Transactional(readOnly = true)
@Service
public class FactureService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private FactureRepository factureRepository;

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ClientRepository clientRepository;
	

	public <T> Collection<T> findAllProjectedBy(Class<T> projection) {
		return factureRepository.findAllProjectedBy(projection);
	}

	@Transactional(readOnly = false)
	public Facture save(Facture facture) {
		log.debug("creation de la facture : {}", facture);
		return factureRepository.save(facture);
	}

	public Optional<Facture> findById(Long id) {
		Optional<Facture> facture = factureRepository.findById(id);
		facture.ifPresent(f -> f.getLignes().size());
		return facture;
	}

	public boolean existsById(Long id) {
		return factureRepository.existsById(id);
	}

	public Iterable<Facture> findAll() {
		return factureRepository.findAll();
	}

	public long count() {
		return factureRepository.count();
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		factureRepository.deleteById(id);
	}
	
	Long newClient() {
		return clientRepository.save(
				Client.builder().nom("Ahmed").ice(UUID.randomUUID().toString())
				.email(UUID.randomUUID().toString() + "@gmail.com").build()
		).getId();
	}
	
	Long newArticle(String designation, Double pu) {
		return articleRepository.save(
				Article.builder().designation(designation).pu(pu).build()
		).getId();
	}

	@Transactional(readOnly = false)
	public void exempleTransaction() {
		Long clientId = newClient();
		Long p1 = newArticle("MAC", 13000.);
		Long p2 = newArticle("Tablette", 2500.);
		
		Facture f1 = Facture.builder().client(new Client().id(clientId))
				.dateFacturation(LocalDate.now())
				.ligne(
						LigneFacture.builder().article(new Article().id(p2))
							.quantite(3d).pu(3200.).build())
				.ligne(LigneFacture.builder().article(new Article().id(1000l))
						.quantite(3d).pu(1200.).build())
			.build();
		System.out.println("Creation d'une facture");
		save(f1);
	}
	
	public void exTransactionAvecEm() {
		try {
			em.getTransaction().begin();
			// inserts, updates or deletes
			
			// si condition est vrai em.getTransaction().rollback(); 
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}
	
}

package com.ids.service;

import java.util.Collection;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ids.dto.FactureDto;
import com.ids.entity.Client;
import com.ids.entity.Facture;
import com.ids.model.FactureCriteria;
import com.ids.repository.FactureRepository;
import com.ids.support.aop.Supervision;

@Transactional(readOnly = true)
@Service
public class FactureService implements IFactureService {
	
	final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private FactureRepository factureRepository;

	public <T> Collection<T> findAllProjectedBy(Class<T> projection) {
		return factureRepository.findAllProjectedBy(projection);
	}

	@Supervision
	@Transactional(readOnly = false)
	public Facture save(FactureDto factureDto) {
		//TODO utilisation des mappers 
		// https://www.baeldung.com/java-performance-mapping-frameworks
		Facture facture = new Facture();
		facture.setClient(new Client().id(factureDto.getClientId()));
		facture.setDateFacturation(factureDto.getDateFacturation());
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

	@Supervision
	public Iterable<Facture> findAll(FactureCriteria criteria) {
		return factureRepository.findAll();
	}

	public long count() {
		return factureRepository.count();
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		factureRepository.deleteById(id);
	}
	
}

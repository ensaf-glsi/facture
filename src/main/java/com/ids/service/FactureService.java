package com.ids.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ids.entity.Facture;
import com.ids.repository.FactureRepository;

@Transactional //TODO a voir en détail
@Service
public class FactureService {

	@Autowired
	private FactureRepository factureRepository;

	public Facture save(Facture entity) {
		return factureRepository.save(entity);
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

	public void deleteById(Long id) {
		factureRepository.deleteById(id);
	}
	
}

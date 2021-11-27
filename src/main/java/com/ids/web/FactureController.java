package com.ids.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.dto.FactureDto;
import com.ids.entity.Facture;
import com.ids.model.FactureCriteria;
import com.ids.projections.FactureClientProjection;
import com.ids.service.IFactureService;

@RestController
@RequestMapping("/facture")
public class FactureController {
	
	final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IFactureService factureService;

	@PostMapping
	public Facture save(FactureDto facture) {
		log.debug("Ajout d'une facture: {}", facture);
		return factureService.save(facture);
	}

	@GetMapping
	public Iterable<FactureClientProjection> list(FactureCriteria criteria) {
		log.debug("chercher des factures : {}", criteria);
		return factureService.findAllProjectedBy(FactureClientProjection.class);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Facture> findOne(@PathVariable Long id) {
		return factureService.findById(id);
	}
	

}
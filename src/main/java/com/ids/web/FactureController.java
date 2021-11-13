package com.ids.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ids.dto.FactureDto;
import com.ids.model.FactureCriteria;
import com.ids.service.IFactureService;

@Controller
@RequestMapping("/facture")
public class FactureController {
	
	final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IFactureService factureService;

	@GetMapping("/edit")
	public String edit(Model model) {
		log.debug("Affichage du formulation d'ajout d'une facture");
		model.addAttribute("item", new FactureDto());
		return "facture/edit";
	}

	@PostMapping
	public String save(FactureDto facture) {
		log.debug("Ajout d'une facture: {}", facture);
		factureService.save(facture);
//		model.addAttribute("criteria", criteria);
//		model.addAttribute("items", factureService.findAll());
		return "redirect:/facture";
	}

	@GetMapping
	public String list(FactureCriteria criteria, Model model) {
		log.debug("chercher des factures : {}", criteria);
		model.addAttribute("criteria", criteria);
		model.addAttribute("items", factureService.findAll());
		return "facture/liste";
	}
	
	@GetMapping(path = "/{id}")
	public String detail(@PathVariable Long id, @RequestParam Optional<String> name) {
		log.debug("detail de la facture : {}, nom : {}", id, name);
		return "facture/detail";
	}
	

}
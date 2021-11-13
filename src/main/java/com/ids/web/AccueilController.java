package com.ids.web;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ids.entity.Facture;

@Controller
public class AccueilController {
	
	final Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping(path = "/")
	public String accueillir(@RequestHeader("Accept-Language") Optional<String> languages, 
			@SessionAttribute("facture") Optional<Facture> facture, Model model) {
		log.info("Page d'accueil - langages acceptés : {}", languages);
		model.addAttribute("now", new Date());
		return "accueil";
	}

}
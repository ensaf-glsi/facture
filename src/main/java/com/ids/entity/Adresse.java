package com.ids.entity;

import org.springframework.data.annotation.Transient;

import lombok.Data;

@Data
public class Adresse {
	
	@Transient
	private String coordonnees;
	private String ville;
	private String pays;
	@Transient
	private String codePostal;

}

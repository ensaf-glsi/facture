package com.ids.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Adresse {
	
	private String coordonnees;
	private String ville;
	private String pays;
	@Column(name = "cp")
	private String codePostal;

}

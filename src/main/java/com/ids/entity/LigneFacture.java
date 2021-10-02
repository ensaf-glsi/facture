package com.ids.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class LigneFacture {
	
	private String id;
	private Facture facture;
	private Article article;
	private Double quantite;
	private Double pu;
	

}

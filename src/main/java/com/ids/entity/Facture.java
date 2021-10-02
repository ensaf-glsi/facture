package com.ids.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Facture {
	
	private String id;
	private Instant dateCreation;
	private LocalDate dateFacturation;
	private Client client;
	private List<LigneFacture> lignes;

}

package com.ids.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ids.support.jpa.CustomAbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Entity

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Facture extends CustomAbstractPersistable<Long> {
	
	private Instant dateCreation;
	private LocalDate dateFacturation;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Client client;
	
	//TODO voir cascade = persist
	@JsonIgnore
	@Singular
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "facture_id")
	private List<LigneFacture> lignes;

}

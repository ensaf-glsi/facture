package com.ids.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class LigneFacture extends AbstractPersistable<Long> {
	
//	private Facture facture;
	@ManyToOne
	private Article article;
	private Double quantite;
	private Double pu;
	

}

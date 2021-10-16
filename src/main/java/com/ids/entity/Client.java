package com.ids.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.ids.support.jpa.CustomAbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class Client extends CustomAbstractPersistable<Long> {
	
	private String nom;
	@Column(unique = true)
	private String ice;
	private String tel;
	private String mobile;
	@Column(unique = true)
	private String email;
	
	@Embedded
	private Adresse adresse;

	@Embedded
	@AttributeOverrides({
	       @AttributeOverride(name="coordonnees", column=@Column(name = "coordonnees_fact")),
	       @AttributeOverride(name="ville", column=@Column(name = "ville_fact")),
	       @AttributeOverride(name="pays", column=@Column(name = "pays_fact")),
	       @AttributeOverride(name="codePostal", column=@Column(name = "cp_fact"))
	 })
	private Adresse adresseFacturation;
	
	
//	public Client(Long id) {
//		setId(id);
//	}

}

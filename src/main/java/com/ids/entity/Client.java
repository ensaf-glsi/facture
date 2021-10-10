package com.ids.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Client {
	
	@Id
	@GeneratedValue
	private Long id;
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

}

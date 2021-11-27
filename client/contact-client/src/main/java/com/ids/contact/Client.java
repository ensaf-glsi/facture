package com.ids.contact;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter
@ToString
public class Client {

	private Long id;

	private String nom;
	private String ice;
	private String tel;
	private String email;

//	private String mobile;
//	@Column(unique = true)
//	
//	@Embedded
//	private Adresse adresse;
//
//	@Embedded
//	@AttributeOverrides({
//	       @AttributeOverride(name="coordonnees", column=@Column(name = "coordonnees_fact")),
//	       @AttributeOverride(name="ville", column=@Column(name = "ville_fact")),
//	       @AttributeOverride(name="pays", column=@Column(name = "pays_fact")),
//	       @AttributeOverride(name="codePostal", column=@Column(name = "cp_fact"))
//	 })
//	private Adresse adresseFacturation;

//	public Client(Long id) {
//		setId(id);
//	}

}

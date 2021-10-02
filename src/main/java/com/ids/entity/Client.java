package com.ids.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Client {
	
	private String id;
	private String nom;
	private String ice;
	private String tel;
	private String mobile;
	private String email;
	
	private Adresse adresse;
	private Adresse adresseFacturation;

}

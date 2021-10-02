package com.ids.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/*

	create table client (
		id varchar(60) primary key,
		nom varchar(100),
		ice varchar(30),
		tel varchar(20),
		mobile varchar(20),
		email varchar(60)
	)
 */
@Builder
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor @NoArgsConstructor
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

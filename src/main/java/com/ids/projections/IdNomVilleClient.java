package com.ids.projections;

public interface IdNomVilleClient extends IdNomClient {

	Ville getAdresse(); //TODO voir optimisation de la projection
	
//	@Value("#{target.id + '-' + target.nom}")
//	String getIdNom();

	default void print() {
		System.out.println("Client [" + getIdNom() + ", " + getAdresse().getVille() + "]");
	}
	
}

package com.ids.projections;

import org.springframework.beans.factory.annotation.Value;

public interface IdNomClient {

	Long getId();
	String getNom();
	
	@Value("#{target.id + '-' + target.nom}")
	String getIdNom();

//	default String getIdNom() {
//		return getId() + "-" + getNom(); 
//	}
	
	default void print() {
		System.out.println("Client [" + getIdNom() + "]");
//		System.out.println("Client [" + getId() + ", " + getNom() + "]");
	}
	
}

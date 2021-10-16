package com.ids.repository;

import org.springframework.data.repository.CrudRepository;

import com.ids.entity.LigneFacture;

public interface LigneFactureRepository 
		extends CrudRepository<LigneFacture, String> {

}

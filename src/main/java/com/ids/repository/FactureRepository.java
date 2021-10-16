package com.ids.repository;

import org.springframework.data.repository.CrudRepository;

import com.ids.entity.Facture;

public interface FactureRepository 
		extends CrudRepository<Facture, Long> {

}

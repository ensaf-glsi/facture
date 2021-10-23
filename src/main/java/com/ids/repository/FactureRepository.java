package com.ids.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.ids.entity.Facture;

public interface FactureRepository 
		extends CrudRepository<Facture, Long> {
	
	<T> Collection<T> findAllProjectedBy(Class<T> projection);

}

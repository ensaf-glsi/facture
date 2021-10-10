package com.ids.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ids.entity.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Long> {

}

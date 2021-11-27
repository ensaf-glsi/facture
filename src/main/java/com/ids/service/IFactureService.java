package com.ids.service;

import java.util.Collection;
import java.util.Optional;

import com.ids.dto.FactureDto;
import com.ids.entity.Facture;
import com.ids.model.FactureCriteria;

public interface IFactureService {

	<T> Collection<T> findAllProjectedBy(Class<T> projection);

	Facture save(FactureDto facture);

	Optional<Facture> findById(Long id);

	Iterable<Facture> findAll(FactureCriteria criteria);

	long count();

	void deleteById(Long id);

}
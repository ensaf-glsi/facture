package com.ids.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ids.entity.Client;
import com.ids.support.jpa.CutomJpaRepository;

public interface ClientRepository extends CutomJpaRepository<Client, Long> {
	

	Collection<Client> findByAdresseVille(String ville);

	@Query("select c from Client c where lower(nom) like %?1%")
	Collection<Client> findByAndSort(String nom, Sort sort);

	@Query("select c from Client c where ice like %:ice%")
	Collection<Client> findByIce(@Param("ice") String iceParm);
	
	
	<P> Collection<P> findByNomContainsIgnoreCase(String nom, 
			Class<P> projection);

//	Collection<IdNomClientDto> findByNomContainsIgnoreCase(String nom);
//	Collection<IdNomVilleClient> findByNomContainingIgnoreCase(String nom);

//	Collection<IdNomClientDto> findAllDtoedBy();
//	Collection<IdNomClientDto> findAllProjectedBy();
//	Collection<IdNomClient> findAllSummarizedBy();
}

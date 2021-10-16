package com.ids.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ids.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	

	List<Client> findByAdresseVille(String ville);

	@Query("select c from Client c where lower(nom) like %?1%")
	List<Client> findByAndSort(String nom, Sort sort);

	@Query("select c from Client c where ice like %:ice%")
	List<Client> findByIce(@Param("ice") String iceParm);
}

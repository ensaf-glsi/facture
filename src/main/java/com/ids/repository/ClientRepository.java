package com.ids.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ids.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {
	
	
	// select * from client where nom like '%' + {nom} + '%'
	List<Client> findByNomContainingIgnoreCase(String nom);
	// select * from client where nom like {nom}
	List<Client> findByNom(String nom);
	// select * from client where email like {e} limit 1
	Optional<Client> findFirstByEmail(String e);
	
	@Query("select * from client where nom ilike :c or email ilike :c")
	List<Client> findByNomOrEmail(@Param("c") String criteria);
	
	@Modifying
	@Query("delete from client where ice is null")
	void deleteClientWithIceNull();

}

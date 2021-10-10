package com.ids.repository;

import org.springframework.data.repository.CrudRepository;

import com.ids.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}

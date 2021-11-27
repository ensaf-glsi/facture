package com.ids.service;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.ids.entity.Client;
import com.ids.repository.ClientRepository;
import com.ids.support.exception.BadRequestException;

@Transactional(readOnly = true)
@Service
public class ClientService {

	final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ClientRepository clientRepository;

	public <T> Collection<T> findAllProjectedBy(Class<T> projection) {
		return clientRepository.findAllProjectedBy(projection);
	}

	//ajout ou modification d'un client
	@Transactional(readOnly = false)
	public Client save(Client entity) {
		// nouveau client
		if (entity.isNew()) {
			// chercher l'unicite de l'email
//			if (clientRepository.existsByIdNotAndEmail("", entity.getEmail())) {
//				throw new BadRequestException("Un client avec le meme email existe deja !");
//			}
			if (clientRepository.existsByEmail(entity.getEmail())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Un client avec le meme email existe deja !");
			}
			// chercher l'unicite de l'ice
			if (clientRepository.existsByIce(entity.getIce())) {
				throw new BadRequestException("Un client avec le meme ice existe deja !");
			}
		} else {
			// modification
			if (clientRepository.existsByIdNotAndEmail(entity.getId(), entity.getEmail())) {
				throw new BadRequestException("Un client avec le meme email existe deja !");
			}
			if (clientRepository.existsByIdNotAndIce(entity.getId(), entity.getIce())) {
				throw new BadRequestException("Un client avec le meme ice existe deja !");
			}
		}
		
		return clientRepository.save(entity);
	}

	public Optional<Client> findById(Long id) {
		return clientRepository.findById(id);
	}

	public boolean existsById(Long id) {
		return clientRepository.existsById(id);
	}

	public Iterable<Client> findAll() {
		return clientRepository.findAll();
	}

	public long count() {
		return clientRepository.count();
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}

}

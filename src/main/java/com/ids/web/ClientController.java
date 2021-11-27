package com.ids.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ids.entity.Client;
import com.ids.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@GetMapping
	public Iterable<Client> list() {
		return clientService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Client findById(@PathVariable Long id) {
		return clientService.findById(id).get();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Client save(@RequestBody Client object) {
		return clientService.save(object);
	}

	@PutMapping
	public Client update(@RequestBody Client object) {
		return clientService.save(object);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		clientService.deleteById(id);
	}
}

package com.ids.contact;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface GenericFeignClient<T, ID> {

	@GetMapping
	public Collection<T> list();

	@GetMapping(value = "/{id}")
	public T findById(@PathVariable("id") ID id);

	@PostMapping
	public T save(@RequestBody T object);
//
//	@PutMapping
//	public Client update(@RequestBody Client object);
//
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") ID id);

}

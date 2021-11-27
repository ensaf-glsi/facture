package com.ids.contact;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ClientService", path = "/client", url = "${feign.contact.base-url}")
public interface ClientService extends GenericFeignClient<Client, Long> {

//	@GetMapping
//	public Collection<Client> list();
//
//	@GetMapping(value = "/{id}")
//	public Client findById(@PathVariable("id") Long id);
//
//	@PostMapping
//	public Client save(@RequestBody Client object);
////
////	@PutMapping
////	public Client update(@RequestBody Client object);
////
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable("id") Long id);

}

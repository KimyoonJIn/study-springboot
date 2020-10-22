package com.ex2.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ex2.domain.Customer;
import com.ex2.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;

//	@GetMapping
//	List<Customer> getCustomers(){
//		List<Customer> customers = customerService.findAll();
//		return customers;
//	}

	@GetMapping(path = "{id}")
	Customer getCustomer(@PathVariable Integer id){
		Customer customer = customerService.findOne(id);
		return customer;
	}

	@PostMapping
	ResponseEntity<Customer> postCustomers(@RequestBody Customer customer, UriComponentsBuilder uriBuilder) {
		Customer created = customerService.create(customer);
		URI location = uriBuilder.path("api/customers/{id}")
			.buildAndExpand(created.getId()).toUri();
		return ResponseEntity.created(location).body(created);
	}

	@PutMapping(path = "{id}")
	Customer putCustomers(@PathVariable Integer id, @RequestBody Customer customer){
		customer.setId(id);
		return customerService.update(customer);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "{id}")
	void deleteCustomer(@PathVariable Integer id){
		customerService.delete(id);
	}

	@GetMapping
	Page<Customer> getCustomer (@PageableDefault Pageable pageable){
		Page<Customer> customers = customerService.findAll(pageable);
		return customers;
	}

}



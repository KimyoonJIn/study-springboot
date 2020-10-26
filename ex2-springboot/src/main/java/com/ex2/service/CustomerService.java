package com.ex2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ex2.domain.Customer;
import com.ex2.domain.User;
import com.ex2.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer create(Customer customer, User user){
		customer.setUser(user);
		return customerRepository.save(customer);
	}

	public Customer update(Customer customer, User user){
		customer.setUser(user);
		return customerRepository.save(customer);
	}

	public void delete(Integer id){
		customerRepository.delete(id);
	}

	public List<Customer> findAll(){
		return customerRepository.findAll();
}
	public Customer findOne(Integer id){
		return customerRepository.findOne(id);
	}

	public Page<Customer> findAll(Pageable pageable){
		return customerRepository.findAllOrderByName(pageable);
	}
}

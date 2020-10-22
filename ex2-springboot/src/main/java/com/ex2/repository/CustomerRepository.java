package com.ex2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ex2.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
	List<Customer> findAllOrderByName();

	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
	Page<Customer> findAllOrderByName(Pageable pageable);
}

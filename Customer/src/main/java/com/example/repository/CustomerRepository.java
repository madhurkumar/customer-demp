package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {
	
	List<CustomerEntity> findByFirstName(String firstName);

}

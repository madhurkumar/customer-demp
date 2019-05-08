package com.example.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.CustomerEntity;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {

		this.customerRepository = customerRepository;

	}

	public Long addCustomer(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setFirstName(customer.getFirstName());
		customerEntity.setLastName(customer.getLastName());
		customerEntity.setAge(customer.getAge());
		customerEntity.setCreateDate(new Date(System.currentTimeMillis()));
		CustomerEntity result = customerRepository.save(customerEntity);
		return result.getCustId();
	}

	public List<Customer> readCustomer(String firstName) {
		List<CustomerEntity> customerEntities = customerRepository.findByFirstName(firstName);
		List<Customer> customers = new ArrayList<Customer>();
		for (CustomerEntity ce : customerEntities) {
			Customer customer = new Customer();
			customer.setFirstName(ce.getFirstName());
			customer.setLastName(ce.getLastName());
			customer.setEmail(ce.getEmail());
			customers.add(customer);
		}
		return customers;
	}

	public String deleteCustomer(Long customerID)

	{
		Optional<CustomerEntity> c = customerRepository.findById(customerID);
		if (c.isPresent()) {
			customerRepository.delete(c.get());
			return "success";
		}
		return "false";
	}
}

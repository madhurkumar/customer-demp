package com.example.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("/customerservice")
public class CustomerController {

	private CustomerService customerservice;

	public CustomerController(CustomerService customerservice) {

		this.customerservice = customerservice;

	}

	@GetMapping("/customers/{firstName}")
	public List<Customer> getCustomers(@PathParam("firstName") String firstName) {
		return customerservice.readCustomer(firstName);
	}

	@PostMapping("/customer")
	public Long addCustomer(@RequestBody Customer customer) {
		return customerservice.addCustomer(customer);
	}

	@DeleteMapping("/customer/{custId}")
	public String deleteCustomer(@PathParam("custId") Long custId) {
		return customerservice.deleteCustomer(custId);
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}

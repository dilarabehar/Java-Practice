package com.project.enoca.controllers;

import java.util.List;

import com.project.enoca.dto.CustomerDto;
import com.project.enoca.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.enoca.entities.Customer;
import com.project.enoca.repos.CustomerRepository;

@RestController
@RequestMapping("/customer")

public class CustomerController {
	
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerService customerService;

	@GetMapping("/getCustomer")
	public List<CustomerDto> GetCustomer()
	{
		return customerService.getAllCustomers();	}
	
	
	
	@PostMapping("/addCustomer")
	public ResponseEntity AddCustomer(@RequestBody CustomerDto customerDto) //use coming requests body to map an customer.
	
	{
		try {
			customerService.AddCustomer(customerDto);
			return new ResponseEntity<>("CUSTOMER ADDED", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

	/*
	*
	* {
        "name": "Sarah Oliver"
    }
	*
	* */

}

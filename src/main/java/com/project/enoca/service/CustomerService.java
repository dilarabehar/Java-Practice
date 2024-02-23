package com.project.enoca.service;

import com.project.enoca.dto.CustomerDto;
import com.project.enoca.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

     List<CustomerDto> getAllCustomers();
     void AddCustomer(CustomerDto customerDto);

}

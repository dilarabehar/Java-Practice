package com.project.enoca.service.impl;

import com.project.enoca.dto.CustomerDto;
import com.project.enoca.dto.ProductDto;
import com.project.enoca.entities.Customer;
import com.project.enoca.entities.Product;
import com.project.enoca.repos.CustomerRepository;
import com.project.enoca.service.CustomerService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    @Override
      public List<CustomerDto> getAllCustomers()
        {   //converts list of customers convert into list of customerDto
            return customerRepository.findAll()
                    .stream()
                    .map(this::convertEntityToDto) //call convertEntityToDto
                    .collect(Collectors.toList());
        }
    @Override
    public void AddCustomer(CustomerDto customerDto) {
        Customer newCustomer = convertDtoToEntity(customerDto);
        customerRepository.save(newCustomer);
    }
      private CustomerDto convertEntityToDto(Customer customer){

            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(customer.getId());
            customerDto.setName(customer.getName());
            customerDto.setCarts(customer.getCarts());
            return customerDto;
        }
        private Customer convertDtoToEntity(CustomerDto customerDto) {
            Customer customer = new Customer();
            customer.setCarts(customerDto.getCarts());
            customer.setId(customerDto.getId());
            customer.setName(customerDto.getName());

            return customer;
        }


    }

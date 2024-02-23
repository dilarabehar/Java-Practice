package com.project.enoca.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enoca.entities.Customer;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer , Long>{


    Optional<Customer> findAllById(Long id);
}

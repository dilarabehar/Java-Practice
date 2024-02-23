package com.project.enoca.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.enoca.entities.Customer;
import com.project.enoca.entities.Cart;

import java.util.Optional;


public interface CartRepository extends JpaRepository <Cart , Long>{

}

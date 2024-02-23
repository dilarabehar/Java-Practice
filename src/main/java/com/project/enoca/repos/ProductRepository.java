package com.project.enoca.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enoca.entities.Product;

public interface ProductRepository extends JpaRepository<Product , Long>{

}

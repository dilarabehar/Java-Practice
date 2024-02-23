package com.project.enoca.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enoca.entities.Order;


public interface OrderRepository extends JpaRepository<Order , Long>{

}

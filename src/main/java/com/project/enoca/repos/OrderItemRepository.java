package com.project.enoca.repos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enoca.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem , Long>{


}

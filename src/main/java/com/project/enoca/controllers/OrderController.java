package com.project.enoca.controllers;

import com.project.enoca.dto.CustomerDto;
import com.project.enoca.dto.OrderDto;
import com.project.enoca.entities.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.project.enoca.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.enoca.repos.CartRepository;
import com.project.enoca.repos.OrderItemRepository;
import com.project.enoca.repos.OrderRepository;

@RestController
@RequestMapping("/order")

public class OrderController {
	
	private OrderRepository orderRepository;
	private OrderItemRepository orderItemRepository;

	@Resource
	private OrderService orderService;

	
	   public OrderController(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
	        this.orderRepository = orderRepository;
	        this.orderItemRepository = orderItemRepository;

	    }
	

		@GetMapping("/{userId}")
		public ResponseEntity getOrderForCode(@PathVariable Long userId){
		try {
			return new ResponseEntity<>(orderService.GetOrderForCode(userId), HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	   }

		@GetMapping("/itemToOrder/{userId}")
		public Order ItemToOrder(@PathVariable Long userId) {
			Order newOrder = new Order();
			List<OrderItem> orderItemList = orderItemRepository.findAll();
			newOrder.setOrderItems(orderItemList);
			newOrder.setId(userId);
			return orderRepository.save(newOrder);
		}



}

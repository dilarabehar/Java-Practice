package com.project.enoca.controllers;


import java.util.Optional;

import com.project.enoca.service.OrderItemService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.project.enoca.entities.OrderItem;
import com.project.enoca.entities.Product;
import com.project.enoca.repos.OrderItemRepository;
import com.project.enoca.repos.ProductRepository;

@RestController
@RequestMapping("/orderitem")

public class OrderItemController {
	
	private OrderItemRepository orderItemRepository;
	private ProductRepository productRepository;

	@Resource
	private OrderItemService orderItemService;
	
	public OrderItemController(OrderItemRepository orderItemRepository,ProductRepository productRepository)
	{
		this.orderItemRepository=orderItemRepository;
		this.productRepository=productRepository;
	}
	
	@GetMapping("/{productId}")
	public OrderItem GetOrderItem(@PathVariable Long productId)
	{
		return orderItemRepository.findById(productId).orElse(null);
	}
	
	@GetMapping("/productToOrder/{productId}")
	public ResponseEntity ProductToOrder(@PathVariable Long productId) {
		try {
			return new ResponseEntity<>(orderItemService.ProductToOrder(productId), HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}


	
	

	
}

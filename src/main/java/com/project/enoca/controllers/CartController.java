package com.project.enoca.controllers;

import java.util.List;
import java.util.Optional;

import com.project.enoca.dto.CartDto;
import com.project.enoca.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.enoca.repos.CartRepository;
import com.project.enoca.repos.CustomerRepository;
import com.project.enoca.repos.OrderRepository;
import com.project.enoca.entities.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@RestController
@RequestMapping("/cart")
@SpringBootApplication
@EntityScan(basePackages = "com.project.enoca.entities")

public class CartController {
	
	
	private CartRepository cartRepository;
	private OrderRepository orderRepository;
	private CustomerRepository customerRepository;

	@Autowired
	private CartService cartService;

	@GetMapping("/getcart/{userid}")
	public Cart GetCart(@PathVariable Long userid) throws Exception {
		return cartService.getCart(userid);
	}

	public CartController(CartRepository cartRepository,OrderRepository orderRepository, CustomerRepository customerRepository )
	{
		this.cartRepository = cartRepository;
		this.orderRepository=orderRepository;
		this.customerRepository=customerRepository;
	}


	@DeleteMapping("/{product_id}")
	public void RemoveProductFromCart(@PathVariable Long product_id)
	{
		 cartRepository.deleteById(product_id);
	}
	
	 @GetMapping("/{userId}")
	    public Cart ItemToOrder(@PathVariable Long userId) {
	        Cart newOrder = new Cart();
	        List<Order> orderItemList = orderRepository.findAll();

	        newOrder.setOrders(orderItemList);
	        return cartRepository.save(newOrder);
	    }
}

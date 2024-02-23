package com.project.enoca.service.impl;

import com.project.enoca.dto.CartDto;
import com.project.enoca.entities.Cart;
import com.project.enoca.entities.Customer;
import com.project.enoca.entities.Order;
import com.project.enoca.entities.Product;
import com.project.enoca.repos.CartRepository;
import com.project.enoca.repos.CustomerRepository;
import com.project.enoca.repos.OrderRepository;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.project.enoca.service.CartService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    @Resource
    private CartRepository cartRepository;
    @Resource
    private OrderRepository orderRepository;

    @Resource
    private CustomerRepository customerRepository;

    @Override
    public Cart getCart(Long userId) throws Exception {
        Optional<Cart> optionalCart = cartRepository.findById(userId);
        Optional<Customer> optionalCustomer = customerRepository.findById(userId);
        List<Order> orderItemList = orderRepository.findAll();
        if (optionalCart.isPresent() && optionalCustomer.isPresent()) {
            Cart cart = optionalCart.get();
            Customer customer = optionalCustomer.get();
            cart.setOrders(orderItemList);
            cart.setCustomer(optionalCustomer.get());
            return cart;
        }else {
            throw new Exception("USER NOT FOUND");
        }

    }




    private CartDto convertEntityToDto(Cart cart){

        CartDto cartDto = new CartDto();
        cartDto.setCustomer(cart.getCustomer());
        cartDto.setOrders(cart.getOrders());
        return cartDto;
    }
}

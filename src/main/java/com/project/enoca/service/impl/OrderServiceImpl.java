package com.project.enoca.service.impl;


import com.project.enoca.dto.OrderDto;
import com.project.enoca.entities.Order;
import com.project.enoca.entities.OrderItem;
import com.project.enoca.repos.OrderItemRepository;
import com.project.enoca.repos.OrderRepository;
import com.project.enoca.service.OrderService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderItemRepository orderItemRepository;

    @Override
    public Order GetOrderForCode(Long userId) throws Exception {
        final Optional<Order> orderOptional = orderRepository.findById(userId);
        List<OrderItem> orderItemList = orderItemRepository.findAll();
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            return order;
        } else {
            throw new Exception("ORDER NOT FOUND");
        }
    }

    public Order itemToOrder(Long userId)
    {
        Order newOrder = new Order();
        List<OrderItem> orderItemList = orderItemRepository.findAll();
        newOrder.setOrderItems(orderItemList);
        newOrder.setId(userId);
        return orderRepository.save(newOrder);
    }

}

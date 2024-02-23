package com.project.enoca.service;

import com.project.enoca.dto.OrderDto;
import com.project.enoca.entities.Order;

import java.util.List;

public interface OrderService {
    Order GetOrderForCode(Long userId) throws Exception;
    Order itemToOrder(Long userId);
}

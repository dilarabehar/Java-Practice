package com.project.enoca.service;

import com.project.enoca.entities.OrderItem;

public interface OrderItemService {
    OrderItem ProductToOrder(Long productId) throws Exception;
}

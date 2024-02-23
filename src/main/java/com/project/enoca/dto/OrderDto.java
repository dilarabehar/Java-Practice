package com.project.enoca.dto;

import com.project.enoca.entities.Cart;
import com.project.enoca.entities.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private Cart cart;
    private List<OrderItem> orderItems;
}

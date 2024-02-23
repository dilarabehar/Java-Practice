package com.project.enoca.dto;

import com.project.enoca.entities.Customer;
import com.project.enoca.entities.Order;
import lombok.Data;

import java.util.List;

@Data  //getter setter
public class CartDto {
    private Customer customer;

    private List<Order> orders;
}

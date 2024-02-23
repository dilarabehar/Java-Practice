package com.project.enoca.dto;

import com.project.enoca.entities.Cart;
import com.project.enoca.entities.Customer;
import lombok.Data;

import java.util.List;
@Data
public class CustomerDto {
    private Long id;
    private String name;
    private List<Cart> carts;

}

package com.project.enoca.service;

import com.project.enoca.dto.CartDto;
import jakarta.annotation.Resource;
import com.project.enoca.entities.Cart;

import java.util.List;

public interface CartService {
    Cart getCart(Long userid) throws Exception;

}

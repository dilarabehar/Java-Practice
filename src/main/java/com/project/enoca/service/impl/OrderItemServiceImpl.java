package com.project.enoca.service.impl;

import com.project.enoca.entities.OrderItem;
import com.project.enoca.entities.Product;
import com.project.enoca.repos.OrderItemRepository;
import com.project.enoca.repos.ProductRepository;
import com.project.enoca.service.OrderItemService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    @Resource
    private OrderItemRepository orderItemRepository;

    @Resource
    private ProductRepository productRepository;

    public OrderItem ProductToOrder(Long productId) throws Exception {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());

            if (product.getStock() != 0) {
                orderItem.setQuantity(orderItem.getQuantity() + 1);
                product.setStock(product.getStock() - 1);
            } else {

                throw new Exception("PRODUCT NOT FOUND");
            }

            return orderItemRepository.save(orderItem);
        } else {
            return null; }
    }

}

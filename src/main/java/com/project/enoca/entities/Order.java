package com.project.enoca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order extends BaseEntity {

    @ManyToOne
    private Cart cart;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart userCart) {
        this.cart = userCart;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

   
}

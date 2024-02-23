package com.project.enoca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Entity
@Table(name = "carts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cart extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = true)
	private Customer customer;

    @OneToMany(mappedBy = "cart")
    private List<Order> orders;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer2) {
        this.customer = customer2;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> userOrder) {
        this.orders = userOrder;
    }
}

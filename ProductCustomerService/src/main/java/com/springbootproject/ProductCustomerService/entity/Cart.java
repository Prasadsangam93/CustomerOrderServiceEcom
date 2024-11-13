package com.springbootproject.ProductCustomerService.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CartTable")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId; // Unique identifier for Cart

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CartItem> items = new ArrayList<>();

    private Long customerId;

    public Cart(Long customerId) {
        this.customerId = customerId;
    }

    private Double totalPrice; // Total price of the cart

    // Method to update the total price
    public void updateTotalPrice() {
        this.totalPrice = items.stream().mapToDouble(CartItem::calculateTotalPrice).sum();
    }
}

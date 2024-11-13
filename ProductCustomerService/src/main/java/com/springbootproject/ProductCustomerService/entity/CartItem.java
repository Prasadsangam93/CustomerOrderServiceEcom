package com.springbootproject.ProductCustomerService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CartItemTable")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CartItemId; // Unique identifier for CartItem

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonIgnore
    private Cart cart;

    private Long quantity;
    private Long customerId;
    private Double price;
    private String productName;


    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product; // Link to Product

    // Calculated price based on quantity * price
    public Double calculateTotalPrice() {
        return quantity * price;
    }
}

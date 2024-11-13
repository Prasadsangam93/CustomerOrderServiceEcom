package com.springbootproject.ProductCustomerService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Orders") // Pluralized name for the table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Long customerId; // The ID of the customer placing the order
    private Double totalPrice; // Total amount for the order

    private String orderStatus; // Status of the order (e.g., PENDING, COMPLETED, CANCELED)

    private LocalDateTime orderDate; // Date and time when the order was placed

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cartId")
    private Cart cart; // Reference to the Cart associated with this order

    // You can add additional fields here, such as shipping address, payment method, etc.
}

package com.springbootproject.ProductCustomerService.controller;


import com.springbootproject.ProductCustomerService.entity.Cart;
import com.springbootproject.ProductCustomerService.entity.Order;
import com.springbootproject.ProductCustomerService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("save/{cartId}")
    public ResponseEntity<String> createOrder(@PathVariable Long cartId) {
        try {
            Order order = orderService.createOrder(cartId);
            return ResponseEntity.ok("Order created with ID: " + order.getOrderId());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to create order: " + e.getMessage());
        }
    }
}


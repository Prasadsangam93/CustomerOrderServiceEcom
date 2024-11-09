package com.springbootproject.ProductCustomerService.controller;

//
//
//import com.springbootproject.ProductCustomerService.entity.Order;
//import com.springbootproject.ProductCustomerService.service.OrderService;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/orders")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//
//    // Endpoint to create a new order
//    @PostMapping("/create")
//    public Order createOrder(@RequestBody Order order) {
//        return orderService.createOrder(order);
//    }
//
//    // Endpoint to retrieve an order by its ID
//    @GetMapping("/{orderId}")
//    public Optional<Order> getOrderById(@PathVariable Long orderId) {
//        return orderService.getOrderById(orderId);
//    }
//
//    // Endpoint to retrieve all orders for a specific customer
//    @GetMapping("/customer/{customerId}")
//    public List<Order> getOrdersByCustomerId(@PathVariable Long customerId) {
//        return orderService.getOrdersByCustomerId(customerId);
//    }
//
//    // Endpoint to update the order status (e.g., "Success", "Failed", etc.)
//    @PutMapping("/{orderId}/status")
//    public Order updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
//        return orderService.updateOrderStatus(orderId, status);
//    }
//
//    // Endpoint to create a Razorpay order for the given order
//    @PostMapping("/{orderId}/razorpay")
//    public JSONObject createRazorpayOrder(@PathVariable Long orderId) {
//        try {
//            Optional<Order> orderOptional = orderService.getOrderById(orderId);
//            if (orderOptional.isPresent()) {
//                Order order = orderOptional.get();
//                return orderService.createRazorpayOrder(order);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new JSONObject().put("error", "Failed to create Razorpay order");
//    }
//}

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


package com.springbootproject.ProductCustomerService.service;


import com.razorpay.RazorpayException;
import com.springbootproject.ProductCustomerService.entity.Cart;
import com.springbootproject.ProductCustomerService.entity.Customer;
import com.springbootproject.ProductCustomerService.entity.Order;
import com.springbootproject.ProductCustomerService.repository.CartRepository;
import com.springbootproject.ProductCustomerService.repository.CustomerRepository;
import com.springbootproject.ProductCustomerService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private CartRepository cartRepository; // Assume you have a CartRepository
    @Autowired
    private OrderRepository orderRepository; // Add an OrderRepository for managing orders
    @Autowired
    private RazorpayService razorpayService;
    @Autowired
    private CustomerRepository customerRepository;


    @Override
        public Order createOrder(Long cartId) {


        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        Customer customer= customerRepository.findById(cart.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        // Create a new Order object
        Order order = new Order(); // Create an instance of Order, not Cart
        order.setCustomerId(cart.getCustomerId());
        order.setProductName(cart.getProductName());
        order.setTotalPrice(cart.getTotalPrice()); // Use totalPrice instead of totalPrice
        order.setOrderStatus("PENDING"); // Set the order status
        order.setOrderDate(LocalDateTime.now()); // Set the order date
        order.setCart(cart); // Link the Cart to the Order

        // Save the order
        orderRepository.save(order);


            // Save the order

            // Initiate payment using Razorpay
            try {
                razorpayService.createPayment(order.getTotalPrice(), customer.getEmail());
            } catch (RazorpayException e) {
                throw new RuntimeException("Payment initiation failed: " + e.getMessage());
            }

            return order; // Return the created order
        }
    }



package com.springbootproject.ProductCustomerService.service;

import com.razorpay.RazorpayException;
import com.springbootproject.ProductCustomerService.entity.Order;

public interface OrderService {


    Order createOrder(Long cartId) throws RazorpayException;

//
//    public Order createOrder(Order order);
//
//    Optional<Order> getOrderById(Long orderId);
//
//    List<Order> getOrdersByCustomerId(Long customerId);
//
//    Order updateOrderStatus(Long orderId, String status);
//
//    JSONObject createRazorpayOrder(Order order) throws Exception;
}

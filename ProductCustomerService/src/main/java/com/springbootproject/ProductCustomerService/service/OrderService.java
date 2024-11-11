package com.springbootproject.ProductCustomerService.service;

import com.razorpay.RazorpayException;
import com.springbootproject.ProductCustomerService.entity.Order;

public interface OrderService {


    Order createOrder(Long cartId) throws RazorpayException;

}

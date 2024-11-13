package com.springbootproject.ProductCustomerService.service;

import com.springbootproject.ProductCustomerService.entity.Cart;
import com.springbootproject.ProductCustomerService.exception.ProductNotFoundException;

public interface CartService {


    public Cart addProductToUserCart(Long customerId, Long productId, Long quantity) throws ProductNotFoundException;
}
package com.springbootproject.ProductCustomerService.service;

import com.springbootproject.ProductCustomerService.entity.Cart;

public interface CartService {


   // public Cart createCart(Cart cart);

    public Cart addCartItem(Long customerId, Long productId, Integer quantity);


}
package com.springbootproject.ProductCustomerService.service;

import com.springbootproject.ProductCustomerService.entity.Cart;

public interface CartService {



    public Cart addCartItem(Long customerId, Long productId, Integer quantity);




    public String deleteCart(Long cartId);

    Cart updateCart(Long cartId, Integer quantity);
}
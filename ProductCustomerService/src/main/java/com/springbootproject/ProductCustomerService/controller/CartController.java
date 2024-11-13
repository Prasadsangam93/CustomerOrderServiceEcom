package com.springbootproject.ProductCustomerService.controller;

import com.springbootproject.ProductCustomerService.entity.Cart;
import com.springbootproject.ProductCustomerService.exception.ProductNotFoundException;
import com.springbootproject.ProductCustomerService.model.CartAddDto;
import com.springbootproject.ProductCustomerService.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cartAdd")
    public ResponseEntity<Cart> addTocart(@RequestBody CartAddDto dto) throws ProductNotFoundException {

        log.info("Adding product to cart - userId: {}, productId: {}, quantity: {}",
                dto.getCustomerId(), dto.getProductId(), dto.getQuantity());

        // Call the service to add the product to the cart
        Cart cart = cartService.addProductToUserCart(dto.getCustomerId(), dto.getProductId(), dto.getQuantity());
        return ResponseEntity.ok().body(cart);
    }
}

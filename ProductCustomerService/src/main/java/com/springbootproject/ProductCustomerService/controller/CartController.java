package com.springbootproject.ProductCustomerService.controller;
import com.springbootproject.ProductCustomerService.entity.Cart;
import com.springbootproject.ProductCustomerService.entity.Product;
import com.springbootproject.ProductCustomerService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/carts")
//public class CartController {
//
//    @Autowired
//    private CartService cartService;
//
//    // Endpoint to create a Cart
//    @PostMapping("/{customerId}/{productId}")
//    public ResponseEntity<Cart> createCart(
//            @PathVariable Long customerId,
//            @PathVariable Long productId,
//            @RequestParam Integer quantity,
//            @RequestParam Long price) {
//
//        // Create a new Cart object
//        Cart cart = new Cart();
//
//        // Set the customerId and quantity from path variable and request parameter
//        cart.setCustomerId(customerId);
//        cart.setQuantity(quantity);
//        cart.setPrice(price);
//
//        // Create a Product object and set its ID
//        Product product = new Product();
//        product.setProductId(productId);
//        cart.setProduct(product);
//
//        // Save the cart using the service
//        Cart savedCart = cartService.createCart(cart);
//
//        return ResponseEntity.ok(savedCart);
//    }
//
//    // Optionally, add more endpoints like GET, DELETE, etc.


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService; // Assume this service handles the business logic

    @PostMapping("/add")
    public ResponseEntity<Cart> addCartItem(@RequestParam Long customerId,
                                            @RequestParam Long productId,
                                            @RequestParam Integer quantity) {
        Cart cart = cartService.addCartItem(customerId, productId, quantity);
        return ResponseEntity.ok(cart);
    }
}



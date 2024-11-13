package com.springbootproject.ProductCustomerService.service;

import com.springbootproject.ProductCustomerService.entity.Cart;
import com.springbootproject.ProductCustomerService.entity.CartItem;
import com.springbootproject.ProductCustomerService.entity.Product;
import com.springbootproject.ProductCustomerService.exception.ProductNotFoundException;
import com.springbootproject.ProductCustomerService.exception.UserNotFoundExceptionCls;
import com.springbootproject.ProductCustomerService.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootproject.ProductCustomerService.repository.CustomerRepository;

import java.util.Optional;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    /* Adding product to the cart */
    @Override
    public Cart addProductToUserCart(Long customerId, Long productId, Long quantity) throws ProductNotFoundException {

        log.info("addProductToUserCart entered, userId is: {}", customerId);

        if (customerId == null) {
            throw new UserNotFoundExceptionCls("User not found: " + customerId);
        }

        // Check if the user exists
        customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new UserNotFoundExceptionCls("User not found with ID: " + customerId));

        log.info("user id is: {}", customerId);

        // Retrieve or create a Cart for the user
        Cart cart = cartRepository.findByCustomerId(customerId).orElse(new Cart(customerId));
        log.info("cart details: {}", cart);

        // Retrieve the product from the database
        Product product = productRepository.findByProductId(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        // Check if the product is already in the cart
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getProductId().equals(productId))
                .findFirst();

        // If the product is already in the cart, update the quantity
        if (existingItem.isPresent()) {
            log.info("Product already in cart: {}", existingItem.isPresent());
            CartItem cartItem = existingItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            log.info("Adding new product to cart...");

            // If the product is not in the cart, create a new CartItem
            CartItem newItem = new CartItem();
            newItem.setCart(cart);  // Associate CartItem with the Cart
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            newItem.setProductName(product.getProductName());
            newItem.setPrice((double) product.getPrice());
            newItem.setCustomerId(customerId);

            // Add the new CartItem to the Cart
            cart.getItems().add(newItem);
        }

        // Update the total price of the cart
        cart.updateTotalPrice();

        // Save the Cart and its associated CartItems (due to cascade)
        return cartRepository.save(cart);
    }
}

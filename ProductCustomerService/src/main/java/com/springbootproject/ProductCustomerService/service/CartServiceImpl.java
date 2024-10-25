package com.springbootproject.ProductCustomerService.service;

import com.springbootproject.ProductCustomerService.entity.Cart;
import com.springbootproject.ProductCustomerService.entity.Product;
import com.springbootproject.ProductCustomerService.repository.CartRepository;
import com.springbootproject.ProductCustomerService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {


    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Cart addCartItem(Long customerId, Long productId, Integer quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // Create a new Cart instance
        Cart cart = new Cart();
        cart.setCustomerId(customerId);
        cart.setProduct(product);
        cart.setQuantity(quantity);
        cart.setProductName(product.getProductName());
        cart.setPrice(product.getPrice()); // Assuming Product has a getPrice() method
        cart.calculateTotalPrice(); // Calculate total price

        // Save the cart to the database
        return cartRepository.save(cart);
    }
}






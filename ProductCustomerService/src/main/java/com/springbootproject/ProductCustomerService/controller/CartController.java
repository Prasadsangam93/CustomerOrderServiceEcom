package com.springbootproject.ProductCustomerService.controller;
import com.springbootproject.ProductCustomerService.entity.Cart;
import com.springbootproject.ProductCustomerService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService; // Assume this service handles the business logic

    @PostMapping("/save")
    public ResponseEntity<Cart> addCart(@RequestParam Long customerId,
                                            @RequestParam Long productId,
                                            @RequestParam Integer quantity) {
        Cart cart = cartService.addCartItem(customerId, productId, quantity);
        return ResponseEntity.ok(cart);
    }


    @DeleteMapping("delete/{cartId}")
    public ResponseEntity<String> deleteCart(@PathVariable Long cartId) {
        // Call the service method to delete the cart item
        String responseMessage = cartService.deleteCart(cartId);
        return ResponseEntity.ok(responseMessage); // Return the response message
    }


    @PutMapping("/{cartId}/increase")
    public ResponseEntity<Cart> increaseCartQuantity(@PathVariable Long cartId, @RequestParam Integer quantity) {
        Cart updatedCart = cartService.updateCart(cartId, quantity);
        return ResponseEntity.ok(updatedCart);

    }


}



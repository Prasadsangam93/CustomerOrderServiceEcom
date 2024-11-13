package com.springbootproject.ProductCustomerService.controller;


import com.springbootproject.ProductCustomerService.entity.Product;
import com.springbootproject.ProductCustomerService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(
            @RequestParam("productName") String productName,
            @RequestParam("price") Double price,
            @RequestParam("quantity") Long quantity,
            @RequestParam("image") MultipartFile image) {
        try {
            // Call the service to save the product
            Product savedProduct = productService.saveProduct(productName, price, quantity, image);

            return ResponseEntity.ok("Product saved successfully with ID: " + savedProduct.getProductId());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving product: " + e.getMessage());
        }
    }
}


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

    @PostMapping("/imageSave")
    public ResponseEntity<Product> createProduct(@RequestParam("file") MultipartFile file,
                                                 @ModelAttribute Product product) {
        Product savedProduct = productService.createProduct(product, file);
        return ResponseEntity.ok(savedProduct); // Return the saved product
    }
}

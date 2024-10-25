package com.springbootproject.ProductCustomerService.service;

import com.springbootproject.ProductCustomerService.entity.Product;
import com.springbootproject.ProductCustomerService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProductServiceImpl implements  ProductService{


    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product createProduct(Product product, MultipartFile file) {
        try {
            // Convert the image file to a byte array
            byte[] imageBytes = file.getBytes();
            product.setImage(imageBytes); // Set the image in the product

            // Save product to the database
            return productRepository.save(product);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload image: " + e.getMessage());
        }
    }
}

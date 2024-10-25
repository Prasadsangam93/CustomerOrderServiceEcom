package com.springbootproject.ProductCustomerService.service;

import com.springbootproject.ProductCustomerService.entity.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    public Product createProduct(Product product, MultipartFile file);

}
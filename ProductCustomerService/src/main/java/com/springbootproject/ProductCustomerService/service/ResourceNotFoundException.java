package com.springbootproject.ProductCustomerService.service;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String customerNotFound) {
    }
}

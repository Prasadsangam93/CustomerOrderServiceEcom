package com.springbootproject.ProductCustomerService.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ProductNotFoundException extends Exception {

    private String message;
}
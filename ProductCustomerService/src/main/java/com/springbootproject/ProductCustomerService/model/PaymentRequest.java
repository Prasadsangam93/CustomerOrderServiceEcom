package com.springbootproject.ProductCustomerService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private Long productId;
    private Long quantity;
    private String currency;
    private String paymentMethod;
}

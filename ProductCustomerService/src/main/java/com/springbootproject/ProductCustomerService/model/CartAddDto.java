package com.springbootproject.ProductCustomerService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartAddDto {

    private Long  customerId;
    private Long productId;
    private Long quantity;
}

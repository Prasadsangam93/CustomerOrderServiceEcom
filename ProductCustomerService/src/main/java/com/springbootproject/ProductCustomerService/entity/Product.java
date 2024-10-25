package com.springbootproject.ProductCustomerService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ProductTable")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Double price;
    private  Long quantity;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_Id")
//    private List<Cart> carts;
}






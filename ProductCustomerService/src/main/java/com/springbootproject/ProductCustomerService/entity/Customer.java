package com.springbootproject.ProductCustomerService.entity;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CustomerTable")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String customerName;
    private String gender;
    private String email;
    private Long phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_Id")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_Id")
    private List<Product> products;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_Id")
//    private List<Cart> carts;


    }




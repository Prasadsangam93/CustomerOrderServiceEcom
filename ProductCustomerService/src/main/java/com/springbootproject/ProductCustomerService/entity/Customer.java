package com.springbootproject.ProductCustomerService.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CustomerTable")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

   // @NotNull(message = "Customer name should not be null")
   // @NotEmpty(message = "Customer name should not be empty")
    private String customerName;

    private String gender;

   // @Email(message = "Email should be valid")
    //@NotNull(message = "Email should not be null")
    private String email;

    private Long phoneNumber;

    //@NotNull(message = "Password should not be null")
   // @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters long")
    private String password;

    private String abn;
    private String companyAddress;
    private String state;
    private String postalCode;




    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_Id")
    private List<Address> addresses;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_Id")
//    private List<Product> products;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_Id")
//    private List<Cart> carts;


    }




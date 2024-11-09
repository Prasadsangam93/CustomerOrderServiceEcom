package com.springbootproject.ProductCustomerService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Cart")
public class Cart {

  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)




            private Long cartId;

            private Integer quantity;
            private Long customerId;
            private Double price;
            private String productName;
            private Double totalPrice;

            @ManyToOne
            @JoinColumn(name = "product_id", referencedColumnName = "productId")
            private Product product;

            // Reference back to the Order
            @ManyToOne
            @JoinColumn(name = "order_id")
            private Order order;

            // Calculate totalPrice based on quantity and price
            public void calculateTotalPrice() {
                this.totalPrice = this.price * this.quantity;
            }

}





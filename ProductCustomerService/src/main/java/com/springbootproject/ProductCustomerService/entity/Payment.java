package com.springbootproject.ProductCustomerService.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PaymentDetails")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long paymentId;


    private Long id;
    private Double amount;
    private String status;
    private String razorPayPaymentId;
    private String paymentMethod;
    private String bank;
    private String wallet;
    private String currency;
    private String razorPayOrderId;
    private Instant orderDate;
}

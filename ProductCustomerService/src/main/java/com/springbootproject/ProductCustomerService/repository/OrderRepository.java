package com.springbootproject.ProductCustomerService.repository;



import com.springbootproject.ProductCustomerService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    }




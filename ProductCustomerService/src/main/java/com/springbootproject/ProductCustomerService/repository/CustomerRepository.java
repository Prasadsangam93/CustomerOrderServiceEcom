package com.springbootproject.ProductCustomerService.repository;

import com.springbootproject.ProductCustomerService.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer ,Long> {
}

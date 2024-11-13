package com.springbootproject.ProductCustomerService.repository;

import com.springbootproject.ProductCustomerService.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    List<CartItem> findByCustomerId(Long customerId);
}

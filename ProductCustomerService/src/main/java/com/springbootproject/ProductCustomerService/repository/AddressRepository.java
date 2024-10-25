package com.springbootproject.ProductCustomerService.repository;


import com.springbootproject.ProductCustomerService.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository< Address , Long> {

}

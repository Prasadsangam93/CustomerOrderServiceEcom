package com.springbootproject.ProductCustomerService.config;

import com.springbootproject.ProductCustomerService.entity.Customer;
import com.springbootproject.ProductCustomerService.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service

public class MyUserDetailasService implements UserDetailsService {



    @Autowired
    private CustomerRepository customerRepository; // Remove `static`

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByEmail(username);

        if (customer.isPresent()) {
            Customer res = customer.get();
            return User.builder()
                    .username(res.getEmail())
                    .password(res.getPassword())
                    .build();
        } else {
           log.info("Credentials wrong: user not found for email: {}", username);
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
    }

}

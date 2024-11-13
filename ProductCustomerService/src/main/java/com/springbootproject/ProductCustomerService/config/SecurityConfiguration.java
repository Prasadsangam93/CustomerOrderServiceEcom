package com.springbootproject.ProductCustomerService.config;

//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//@Configuration
//@EnableWebSecurity
//@Slf4j
//public class SecurityConfiguration {
//
//    @Autowired
//    private MyUserDetailasService userDetailasService;
//
//    /**
//     * Configures the HTTP security filter chain.
//     */
//    @SuppressWarnings("removal")
//    @Bean
//    public SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(req -> req.requestMatchers("/api/customers/save","/api/customers/**").permitAll()
//
//                        .anyRequest().authenticated())
//
////               .formLogin()
////
////               .and()
//                .logout(logout -> logout.permitAll())
//                .build();
//
//    }
//
//    /**
//     * Password encoder bean, using BCrypt hashing algorithm.
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    /**
//     * Provides UserDetailsService for loading user-specific data during authentication.
//     */
//    @Bean
//    public UserDetailsService userDetailasService() {
//        return userDetailasService;
//    }
//
//    /**
//     * Sets up DaoAuthenticationProvider with user details and password encoder.
//     */
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailasService);
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }
//
//    /**
//     * Custom authentication manager that uses the DaoAuthenticationProvider.
//     */
//    @Bean
//    public AuthenticationManager authenticationManager() {
//        return new ProviderManager(authenticationProvider());
//    }
//}
//
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@Slf4j
//public class SecurityConfiguration {
//
//    @Autowired
//    private  MyUserDetailasService myUserDetailasService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session management
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/customers/save", "/api/customers/**").permitAll() // Allow access to specific endpoints
//                        .anyRequest().authenticated() // Require authentication for all other endpoints
//                )
//                .build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return myUserDetailasService;
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(myUserDetailasService);
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager() {
//        return new ProviderManager(authenticationProvider());
//    }
//}
//


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfiguration {

    @Autowired
    private MyUserDetailasService userDetailasService;

    /**
     * Configures the HTTP security filter chain.
     */
    @Bean
    public SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // Disable CSRF for the endpoints that need to accept multipart requests (file uploads)
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/cart/**", "/api/products/**", "/api/customers/**","api/orders/**")
                )
                .authorizeHttpRequests(req -> req
                        // Allow these specific endpoints for unauthenticated access
                        .requestMatchers("/api/customers/**", "/api/customers/**").permitAll()
                        .requestMatchers("/api/products/**", "/api/products/**").permitAll()  // Public endpoint for file upload

                        .requestMatchers("/api/cart/**", "/api/cart/**").permitAll()

                        .requestMatchers("api/orders/**", "api/orders/**").permitAll()
                        .anyRequest().authenticated()) // Other requests need authentication
                .logout(logout -> logout.permitAll()) // Allow logout endpoint
                .build();
    }

    /**
     * Password encoder bean, using BCrypt hashing algorithm.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Provides UserDetailsService for loading user-specific data during authentication.
     */
    @Bean
    public UserDetailsService userDetailasService() {
        return userDetailasService;
    }

    /**
     * Sets up DaoAuthenticationProvider with user details and password encoder.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailasService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * Custom authentication manager that uses the DaoAuthenticationProvider.
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(authenticationProvider());
    }
}

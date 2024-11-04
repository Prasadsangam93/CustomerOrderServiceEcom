package com.springbootproject.ProductCustomerService.config;



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
    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(req -> req.requestMatchers("/api/customers/save","/api/customers/**").permitAll()

                        .anyRequest().authenticated())

                .formLogin()

                .and()
                .logout(logout -> logout.permitAll()) // Allow everyone to see the logout page
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

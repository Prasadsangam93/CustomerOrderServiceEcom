//package com.springbootproject.ProductCustomerService.config;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//
//import java.io.IOException;
//import lombok.extern.slf4j.Slf4j;
//
//
//@Configuration
//@Slf4j
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtService jwtService;
//
//    @Autowired
//    private MyUserDetailasService myUserDetailasService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        try {
//            log.info("Entered doFilter method...");
//            String header = request.getHeader("Authorization");
//
//            // Check if the Authorization header is null or doesn't start with "Bearer "
//            if (header == null || !header.startsWith("Bearer ")) {
//                log.info("Authorization header is missing or invalid.");
//                filterChain.doFilter(request, response);
//                return;
//            }
//
//            String token = header.substring(7);
//            String userName = JwtService.getSubjectFromToken(token); // Call instance method
//
//            // Check if userName is not null and user is not authenticated
//            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                UserDetails userInfo = myUserDetailasService.loadUserByUsername(userName);
//
//                if (userInfo != null && JwtService.isTokenValid(token)) {
//                    // Create UsernamePasswordAuthenticationToken
//                    UsernamePasswordAuthenticationToken authenticationToken =
//                            new UsernamePasswordAuthenticationToken(
//                                    userInfo,
//                                    null,
//                                    userInfo.getAuthorities());
//
//                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    // Set the authenticated user in the security context
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                } else {
//                    log.warn("Invalid token or user not found for user: {}", userName);
//                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Explicitly return 401
//                    return;
//                }
//            }
//
//            filterChain.doFilter(request, response);
//
//        } catch (Exception e) {
//            log.error("Error in JwtAuthenticationFilter: {}", e.toString());
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Handle error
//        }
//    }
//}

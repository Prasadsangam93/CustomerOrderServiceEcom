package com.springbootproject.ProductCustomerService.GlobalEception;


import com.springbootproject.ProductCustomerService.exception.UnAuthorizedExceptionCls;
import com.springbootproject.ProductCustomerService.exception.UserNotFoundExceptionCls;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@RestControllerAdvice
public class ValidationExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    @ExceptionHandler(UserNotFoundExceptionCls.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundExceptionCls ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(UnAuthorizedExceptionCls.class)
    public ResponseEntity<String> handleUserNotFoundException(UnAuthorizedExceptionCls ex) {
        return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.UNAUTHORIZED);


    }

    }
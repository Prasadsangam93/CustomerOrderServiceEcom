package com.springbootproject.ProductCustomerService.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadRequestCls extends  RuntimeException{

    private  String errorMessage;

}

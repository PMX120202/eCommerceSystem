package com.example.ecommercesystem.Advices;

import com.example.ecommercesystem.DTO.ResponseClient;
import com.example.ecommercesystem.DTO.ResponseMessage;
import com.example.ecommercesystem.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductNotFoundAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseClient> employeeNotFoundHandler(ProductNotFoundException ex) {
        return ResponseEntity.badRequest().body(new ResponseMessage(1, ex.getMessage()));
    }
}

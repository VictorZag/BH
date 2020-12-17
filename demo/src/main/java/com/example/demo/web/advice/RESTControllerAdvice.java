package com.example.demo.web.advice;

import com.example.demo.exception.InvalidEntityException;
import com.example.demo.exception.InvalidOperationException;
import com.example.demo.web.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class RESTControllerAdvice {

    @ExceptionHandler(InvalidEntityException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleException(InvalidEntityException ex, WebRequest req){
        return new ErrorDetails(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(InvalidOperationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleException(InvalidOperationException ex, WebRequest req){
        return new ErrorDetails(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}

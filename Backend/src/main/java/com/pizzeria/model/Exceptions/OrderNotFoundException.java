package com.pizzeria.model.Exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.UUID;


public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(UUID id){
        super("Could not find order no. "+id);
    }
}

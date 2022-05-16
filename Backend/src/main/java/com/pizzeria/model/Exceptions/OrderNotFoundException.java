package com.pizzeria.model.Exceptions;


public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String id){
        super("Could not find order no. "+id);
    }
}

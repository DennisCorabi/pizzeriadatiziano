package com.pizzeria.model.Exceptions;

public class OrderCompletedException extends RuntimeException{
    public OrderCompletedException(String id){
        super("Order completed: cannot update status.");
    }
}


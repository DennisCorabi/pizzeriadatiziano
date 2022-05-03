package com.pizzeria.model.Exceptions;

import java.util.UUID;

public class OrderCompletedException extends RuntimeException{
    public OrderCompletedException(UUID id){
        super("Order completed: cannot update status.");
    }
}


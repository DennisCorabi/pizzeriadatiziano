package com.pizzeria.model.Exceptions;

import java.util.UUID;

public class OrderNotCompletedException extends RuntimeException{

    public OrderNotCompletedException(UUID id){
        super("Order no. "+id+" is not completed.");
    }
}

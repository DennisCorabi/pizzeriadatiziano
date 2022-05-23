package com.pizzeria.model.Exceptions;

import java.util.UUID;

/*
Exception che viene tirata quando si cerca di eliminare un ordine che non è ancora terminato (entrato nello stato COMPLETED)
 */
public class OrderNotCompletedException extends RuntimeException{

    public OrderNotCompletedException(UUID id){
        super("Order no. "+id+" is not completed.");
    }
}

package com.pizzeria.model.Exceptions;

/*
Exception che viene tirata quando si cerca di aggiornare un ordine che è già terminato (stato COMPLETED)
 */
public class OrderCompletedException extends RuntimeException{
    public OrderCompletedException(String id){
        super("Order completed: cannot update status.");
    }
}


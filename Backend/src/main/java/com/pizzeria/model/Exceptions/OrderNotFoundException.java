package com.pizzeria.model.Exceptions;



/*
Exception che viene tirata quando non trova un ordine avente come ID la stringa passata durante la richiesta GET, PUT o DELETE
 */
public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String id){
        super("Could not find order no. "+id);
    }
}

package com.pizzeria.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
Ad ogni exception associo uno stato 400+ della richiesta HTTP così da informare l'utente che ha compiuto la richiesta che essa non è andata a buon fine.
 */
@ControllerAdvice
public class OrderExceptionHandler {

    @ResponseBody
    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String orderNotFound(OrderNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(OrderNotCompletedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String orderNotCompleted(OrderNotCompletedException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(OrderCompletedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String orderCompleted(OrderCompletedException ex){
        return ex.getMessage();
    }
}

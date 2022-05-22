package com.pizzeria.dataAccess;

import com.pizzeria.controller.OrderController;
import com.pizzeria.model.Order.Order;
import com.pizzeria.model.Status;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


/*
Classe con cui aggiungo degli URI legati alla richiesta http che sto compiendo
 */
@Component
public class OrderBuilder {

    public EntityModel<Order> build(Order order){
        return EntityModel.of(order, linkTo(methodOn(OrderController.class).getOrderById(order.getIdentifier())).withSelfRel());
    }
}

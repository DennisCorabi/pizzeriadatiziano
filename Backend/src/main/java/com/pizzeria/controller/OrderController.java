package com.pizzeria.controller;


import com.pizzeria.dataAccess.OrderBuilder;
import com.pizzeria.dataAccess.OrderDatabase;
import com.pizzeria.model.Order.Order;
import com.pizzeria.model.Exceptions.OrderNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/pizzeria")
public class OrderController {

    OrderDatabase database;
    OrderBuilder builder;
    public OrderController(OrderDatabase database, OrderBuilder builder){
        this.database=database;
        this.builder=builder;
    }

    @GetMapping
    public CollectionModel<EntityModel<Order>> getOrders(){
        List<EntityModel<Order>> entityModels = database.getRepository()
                .stream()
                .map(builder::build).toList();
        return CollectionModel.of(entityModels, linkTo(methodOn(OrderController.class).getOrders()).withRel("Orders"));
    }

    @GetMapping("/{id}")
    public EntityModel<Order> getOrderById(@PathVariable("id") UUID id){
        Order order = database.getOrderById(id);
        if(order==null) throw new OrderNotFoundException(id);

        return builder.build(order);
    }

    @PostMapping
    public ResponseEntity<?> newOrder(@RequestBody Order newOrder){
        Order order = database.insertOrder(newOrder);
        if (order == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else {
            EntityModel<Order> entityModel = builder.build(order);
            return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAddress(@RequestParam(value = "address") String address, @PathVariable("id") UUID id){
        Order updatedOrder = database.updateAddress(address,id);
        if (updatedOrder == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else{
            String string = "Could not find order no. "+id;
            EntityModel<Order> entityModel = builder.build(updatedOrder);
            return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(string);
        }
    }

    @PutMapping("/{id}")
    public EntityModel<Order> updateStatus(@PathVariable("id") UUID id){
        Order order = database.updateStatus(id);
        return builder.build(order);
    }

    @DeleteMapping("/{id}")
    public void deleteCompletedOrder(@PathVariable("id") UUID id){
        database.deleteCompletedOrder(id);
    }
}

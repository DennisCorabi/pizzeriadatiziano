package com.pizzeria.controller;


import com.pizzeria.dataAccess.OrderBuilder;
import com.pizzeria.dataAccess.OrderRepository;
import com.pizzeria.model.Exceptions.OrderCompletedException;
import com.pizzeria.model.Exceptions.OrderNotFoundException;
import com.pizzeria.model.Order.Order;
import com.pizzeria.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpUtils;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/pizzeria")
@CrossOrigin
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    OrderRepository repository;
    OrderBuilder builder;
    HttpServletRequest request;
    public OrderController(OrderBuilder builder, OrderRepository repository, HttpServletRequest request){
        this.builder=builder;
        this.repository=repository;
        this.request = request;
    }

    @GetMapping
    public CollectionModel<EntityModel<Order>> getOrders(){
        String ip = request.getRemoteAddr();
        List<EntityModel<Order>> entityModels = repository.findAll()
                .stream()
                .map(builder::build).toList();

        logger.warn("GET Request "+request.getRequestURI()+" from "+request.getRemoteAddr());
        return CollectionModel.of(entityModels, linkTo(methodOn(OrderController.class).getOrders()).withRel("Orders"));
    }

    @GetMapping("/{id}")
    public EntityModel<Order> getOrderById(@PathVariable("id") String id){
        Order order = repository.findById(id).orElseThrow(()->new OrderNotFoundException(id));

        logger.info("GET Request "+request.getRequestURI()+" from "+request.getRemoteAddr());
        return builder.build(order);
    }

    @PostMapping
    public String newOrder(@RequestBody Order newOrder){
        Order order = repository.save(newOrder);
        logger.info("POST request: New order (ID: "+order.getIdentifier()+")");
        return order.getIdentifier();
    }

    @PutMapping("/{id}")
    public EntityModel<Order> updateStatus(@PathVariable("id") String id){
        repository.findById(id).map(order -> {
          switch (order.getStatus()){
              case COOKING-> order.setStatus(Status.DELIVERING);
              case DELIVERING -> order.setStatus(Status.COMPLETED);
              case COMPLETED -> throw new OrderCompletedException(id);
          }
          return builder.build(order);
        });

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCompletedOrder(@PathVariable("id") String id){
        repository.findById(id).map(order -> {
            repository.delete(order);
            logger.info("DELETE Request: successfully deleted order no. "+id);
            return null;
        });
    }
}

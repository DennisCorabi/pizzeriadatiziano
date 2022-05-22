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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/*
Classe principale del backend: definisce l'API del programma, quindi gli endpoints dove i client possono compiere delle richieste HTTP e ricevere una risposta specifica
 */
@RestController
@RequestMapping("/api/v1/pizzeria")         //definisco l'URI di base
@CrossOrigin    //attivo il CORS, altrimenti il client non riesce a connettersi
public class OrderController {

    //oggetto che viene utilizzato per scrivere dei log.
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    OrderRepository repository;
    OrderBuilder builder;

    HttpServletRequest request;

    public OrderController(OrderBuilder builder, OrderRepository repository, HttpServletRequest request){
        this.builder=builder;
        this.repository=repository;
        this.request = request;
    }

    //GET: ritorna tutti gli ordini effettuati. Il client non dovrebbe essere autorizzato a compiere questa richiesta.
    @GetMapping
    public CollectionModel<EntityModel<Order>> getOrders(){
        String ip = request.getRemoteAddr();
        List<EntityModel<Order>> entityModels = repository.findAll()
                .stream()
                .map(builder::build).toList();

        logger.warn("GET Request "+request.getRequestURI()+" from "+request.getRemoteAddr());
        return CollectionModel.of(entityModels, linkTo(methodOn(OrderController.class).getOrders()).withRel("Orders"));
    }

    //GET: ritorna l'ordine associato all'id passato alla funzione tramite la barra di ricerca del browser.
    // E' l'unica richiesta di tipo GET che il client dovrebbe poter compiere.
    @GetMapping("/{id}")
    public EntityModel<Order> getOrderById(@PathVariable("id") String id){
        Order order = repository.findById(id).orElseThrow(()->new OrderNotFoundException(id));

        logger.info("GET Request "+request.getRequestURI()+" from "+request.getRemoteAddr());
        return builder.build(order);
    }

    /*
    POST: inserisce un nuovo ordine nel database. E' la richiesta principale che il client compie
     */
    @PostMapping
    public String newOrder(@RequestBody Order newOrder){
        Order order = repository.save(newOrder);
        logger.info("POST request: New order (ID: "+order.getIdentifier()+")");
        return order.getIdentifier();
    }

    /*
    PUT: aggiorna lo stato di un ordine.
     */
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

    /*
    DELETE: rimuove un ordine completato. Se viene passato l'id di un ordine non completato, dà errore.
     */
    @DeleteMapping("/{id}")
    public void deleteCompletedOrder(@PathVariable("id") String id){
        repository.findById(id).map(order -> {
            repository.delete(order);
            logger.info("DELETE Request: successfully deleted order no. "+id);
            return null;
        });
    }
}

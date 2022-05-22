package com.pizzeria.dataAccess;

import com.pizzeria.model.Order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

//interfaccia che permette di interfacciarmi con il database remoto. L'url del database remoto è contenuto nel file "application.properties"
public interface OrderRepository extends MongoRepository<Order, String> {

}

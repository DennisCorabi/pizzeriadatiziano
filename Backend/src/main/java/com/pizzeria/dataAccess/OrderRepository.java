package com.pizzeria.dataAccess;

import com.pizzeria.model.Order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

}

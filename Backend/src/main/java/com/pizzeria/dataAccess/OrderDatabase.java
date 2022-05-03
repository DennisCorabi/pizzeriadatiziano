package com.pizzeria.dataAccess;


import com.pizzeria.model.Exceptions.OrderCompletedException;
import com.pizzeria.model.Exceptions.OrderNotFoundException;
import com.pizzeria.model.Order.Order;
import com.pizzeria.model.Exceptions.OrderNotCompletedException;
import com.pizzeria.model.Status;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class OrderDatabase {
    private final List<Order> repository= new ArrayList<>();

    public List<Order> getRepository() {
        return repository;
    }

    public Order getOrderById(UUID uuid){
        for (Order order: repository){
            if (order.getIdentifier().equals(uuid))
                return order;
        }
        return null;
    }

    public Order updateAddress(String address, UUID id){
       for (Order order: repository){
           if (order.getIdentifier().equals(id)){
               order.setAddress(address);
               return order;
           }
       }
       return null;
    }

    public Order insertOrder(Order order){
        try {
            repository.add(order);
            return order;

        }catch (Exception ex){
            return null;
        }
    }
    public void deleteCompletedOrder(UUID id){
        for (Order order: repository){
            if (order.getIdentifier().equals(id)){
                if (order.getStatus()== Status.COMPLETED) repository.remove(order);
                else throw new OrderNotCompletedException(id);
            }
        }
    }

    public Order updateStatus(UUID id){
        for (Order order: repository){
            if (order.getIdentifier().equals(id)){
                switch (order.getStatus()){
                    case COOKING -> order.setStatus(Status.DELIVERING);
                    case DELIVERING -> order.setStatus(Status.COMPLETED);
                    case COMPLETED -> throw new OrderCompletedException(id);

                }
                return order;
            }
        }
        throw new OrderNotFoundException(id);

    }

}

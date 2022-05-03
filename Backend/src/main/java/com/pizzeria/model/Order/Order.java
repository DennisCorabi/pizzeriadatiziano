package com.pizzeria.model.Order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pizzeria.model.Pizze;
import com.pizzeria.model.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID identifier;
    private String address;

    private final String name;
    private final String surname;
    private String number;
    private final Long price;
    private final Pizze order;

    private Status status;

    public Order(String address, String name, String surname, String number, Long price, Pizze order) {
        this.identifier = UUID.randomUUID();
        status = Status.COOKING;
        this.address = address;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.price=price;
        this.order = order;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

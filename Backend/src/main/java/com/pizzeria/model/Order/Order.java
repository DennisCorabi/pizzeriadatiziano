package com.pizzeria.model.Order;

import com.pizzeria.model.Pizze;
import com.pizzeria.model.Status;

import java.util.UUID;

public class Order {
    private final UUID identifier;
    private String address;

    private final String name;
    private final String surname;
    private String phone;
    private final Long price;
    private final Pizze order;
    private Status status;

    public Order(String address, String name, String surname, String phone, Long price, Pizze order) {
        this.identifier = UUID.randomUUID();
        status = Status.COOKING;
        this.address = address;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
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


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "identifier=" + identifier +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", price=" + price +
                ", order=" + order +
                ", status=" + status +
                '}';
    }
}

package com.pizzeria.model.Order;

import com.pizzeria.model.Pizze;
import com.pizzeria.model.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("ordini")
public class Order {

    @Id
    private String identifier;
    private String address;

    private final String name;
    private final String surname;
    private String phone;
    private final Long price;
    private final List<Pizze> order;
    private Status status;
    public Order(String address, String name, String surname, String phone, Long price, List<Pizze> order) {
        status = Status.COOKING;
        this.address = address;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.price=price;
        this.order = order;
    }

    public String getIdentifier() {
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

    public Long getPrice() {
        return price;
    }

    public List<Pizze> getOrder() {
        return order;
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

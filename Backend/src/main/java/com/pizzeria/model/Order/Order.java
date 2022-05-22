package com.pizzeria.model.Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pizzeria.model.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/*
Classe dell'ordine che verrà poi usata come modello per lo scambio di dati dal client al server e dal server al database
 */

@Document("ordini")         //indica il documento dove andranno poi archiviati gli ordini
public class Order {

    @Id             //ID univoco. Non necessita di nessuna dichiarazione dal momento che il suo valore verrà generato automaticamente.
    private String identifier;

    @JsonProperty("location")
    private Location location;
    private final String name;
    private final String surname;
    private Phone phone;
    private final Long price;
    private final List<Pizza> order;
    private Status status;
    public Order(Location location, String name, String surname, Phone phone, Long price, List<Pizza> order) {
        status = Status.COOKING;
        this.location = location;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.price=price;
        this.order = order;
    }

    public String getIdentifier() {
        return identifier;
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

    public Phone getPhone() {
        return phone;
    }

    public Location getLocation() {
        return location;
    }

    public List<Pizza> getOrder() {
        return order;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPhone(Phone phone) {
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
                ", address='" + location + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", price=" + price +
                ", order=" + order +
                ", status=" + status +
                '}';
    }
}

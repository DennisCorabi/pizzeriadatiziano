package com.pizzeria.model.Order;

import com.fasterxml.jackson.annotation.JsonProperty;


/*
Classe che rappresenta il l'attributo "pizza" nella classe ordine. Contiene tutte le informazioni riguardo alla singola pizza. Nella classe ordine verrà dichiarato un array di questa classe.
 */
public class Pizza {

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private double price;
}

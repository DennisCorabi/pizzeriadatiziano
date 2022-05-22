package com.pizzeria.model.Order;

import com.fasterxml.jackson.annotation.JsonProperty;


/*
Classe che rappresenta l'attributo "location" nella classe ordine. Contiene tutte le informazioni riguardo al luogo di consegna dell'ordine
 */
public class Location {

    @JsonProperty("city")
    String city;

    @JsonProperty("address")
    String address;

    @JsonProperty("nOfAddress")
    Integer noOfAddress;
}

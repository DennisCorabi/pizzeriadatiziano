package com.pizzeria.model.Order;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pizza {

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private double price;
}

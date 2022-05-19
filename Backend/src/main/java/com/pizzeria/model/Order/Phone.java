package com.pizzeria.model.Order;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Phone {
    @JsonProperty("dial_code")
    public String dial_code;

    @JsonProperty("number")
    public String number;
}

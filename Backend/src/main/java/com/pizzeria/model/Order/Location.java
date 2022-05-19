package com.pizzeria.model.Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.boot.jackson.JsonComponent;

public class Location {

    @JsonProperty("city")
    String city;

    @JsonProperty("address")
    String address;

    @JsonProperty("nOfAddress")
    Integer noOfAddress;
}

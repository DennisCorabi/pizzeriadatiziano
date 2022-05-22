package com.pizzeria.model.Order;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
Classe che rappresenta il parametro "phone" nella classe ordine. Contiene tutte le informazioni riguardo al contatto telefonico di chi ha ordinato le pizze
 */
public class Phone {
    @JsonProperty("dial_code")
    public String dial_code;

    @JsonProperty("number")
    public String number;
}

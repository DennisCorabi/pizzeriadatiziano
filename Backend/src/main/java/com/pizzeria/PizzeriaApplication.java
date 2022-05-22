package com.pizzeria;

import com.pizzeria.dataAccess.OrderRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/*
Entry point del programma
 */
@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = OrderRepository.class)        //attivo i servizi legati alla connettività con MongoDB

public class PizzeriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzeriaApplication.class, args);
    }

}

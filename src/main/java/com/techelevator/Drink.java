package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item{
    private String name;
    private String location;
    private BigDecimal price;
    private int inventory = 5;
    private String message;

    public Drink() {
    }

    public Drink(String location, String name, BigDecimal price, String message) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.message = message;
    }

    public String getName() {
        return name;
    }

}

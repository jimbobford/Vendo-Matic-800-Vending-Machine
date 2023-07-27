package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item{

    private String name;
    private String location;
    private BigDecimal price;
    private int inventory = 5;
    private String message;


    public Candy(){

    }

    public Candy(String location, String name, BigDecimal price, String message) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.message = message;
    }

}

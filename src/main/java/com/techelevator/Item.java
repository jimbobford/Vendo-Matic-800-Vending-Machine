package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {
    private String name;
    private String location;
    private BigDecimal price;
    private int inventory = 5;
    private String message;

    public Item(){

    }

    public Item(String location, String name, BigDecimal price, String message) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public String getMessage() {
        return message;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}

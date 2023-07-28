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

    public String getName() {
        return name;
    }

    public int getInventory() {
        return inventory;
    }

    public String getMessage() {
        return message;
    }

    public void purchaseMade() {
        if(this.inventory > 0) {
            this.inventory--;
        } else {
            System.out.println("SOLD OUT");
        }
    }

    @Override
    public String toString() {
        if(this.getInventory() == 0) {
            return "Location: " + this.location + " \nItem name: " + this.name + " \nPrice: $" + this.price + " \nOUT OF STOCK" + "\n\n";
        } else {
            return "Location: " + this.location + " \nItem name: " + this.name + " \nPrice: $" + this.price + " \nIn Stock: " + this.inventory + "\n\n";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

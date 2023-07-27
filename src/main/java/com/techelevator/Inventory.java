package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    List<Item> currentInventory = new ArrayList<>();

    public Inventory(List<Item> currentInventory) {
        this.currentInventory = currentInventory;
    }


}

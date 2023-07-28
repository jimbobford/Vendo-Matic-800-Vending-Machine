package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    List<Item> currentInventory;
    Map<String, Integer> invMap = new HashMap<>();

    public Inventory(List<Item> currentInventory) {
        this.currentInventory = currentInventory;
    }

    public void initializeInventory(){
        Item currentItem;
        for(int i = 0; i < currentInventory.size(); i++) {
            currentItem = currentInventory.get(i);
            invMap.put(currentItem.getLocation(), currentItem.getInventory());
        }
    }

    public List<Item> getCurrentInventory() {
        return currentInventory;
    }

    public Map<String, Integer> getInvMap() {
        return invMap;
    }

    public String getNameFromList(String input){
        String result = "";
        for (int i = 0; i < currentInventory.size(); i++) {
            if(currentInventory.get(i).getLocation().equals(input)) {
                result = currentInventory.get(i).getName();
            }
        } return result;
    }

    public BigDecimal getPriceFromList(String input){
        BigDecimal result = null;
        for (int i = 0; i < currentInventory.size(); i++) {
            if(currentInventory.get(i).getLocation().equals(input)) {
                result = currentInventory.get(i).getPrice();
            }
        } return result;
    }

    public void subtractInventory(String input){
        String selection = input;
        if(invMap.containsKey(selection)) {
            invMap.put(selection, (invMap.get(selection) - 1));
            for (int i = 0; i < currentInventory.size(); i++) {
                if(currentInventory.get(i).getLocation().equals(input)) {
                    currentInventory.get(i).purchaseMade();
                }
            }
        } else {
            System.out.println("Invalid selection.");
        }
    }

}

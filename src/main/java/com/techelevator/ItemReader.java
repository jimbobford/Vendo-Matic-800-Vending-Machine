package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemReader {
    private final String GUM_MESSAGE = "Chew Chew, Yum!";
    private final String CANDY_MESSAGE = "Yummy Yummy, So Sweet!";
    private final String MUNCHY_MESSAGE = "Crunch Crunch, Yum!";
    private final String DRINK_MESSAGE = "Glug Glug, Yum!";
    private List<Item> newInventory = new ArrayList<>();
    private int createCounter = 0;

    private File itemList = new File("main.csv");
    public ItemReader() {

    }

    public int getCreateCounter() {
        return createCounter;
    }

    public void invDisplay(List<Item> input){
        for(int i = 0; i < input.size(); i++) {
            System.out.println(input.get(i).toString());
        }
        createCounter++;
    }

    public List<Item> createInventory() {

        Scanner fileScanner;
        try {
            fileScanner = new Scanner(itemList);
            try {
                itemList.createNewFile();
            } catch (IOException e) {
                System.out.println("File error.");
                System.exit(1);
            }
            while (fileScanner.hasNextLine()) {
                String[] currentItem = fileScanner.nextLine().split(",");
                String currentLocation = currentItem[0];
                String currentName = currentItem[1];
                BigDecimal currentPrice = BigDecimal.valueOf(Double.valueOf(currentItem[2]));
                String currentType = currentItem[3];

                // Constructors WOULD NOT work, kept returning null values, went with setters because it works.

                if (currentType.equals("Candy")) {
                    Candy newCandy = new Candy();
                    newCandy.setLocation(currentLocation);
                    newCandy.setName(currentName);
                    newCandy.setPrice(currentPrice);
                    newCandy.setMessage(CANDY_MESSAGE);
                    newInventory.add(newCandy);
                } else if (currentType.equals("Drink")) {
                    Drink newDrink = new Drink(currentLocation, currentName, currentPrice, DRINK_MESSAGE);
                    newDrink.setLocation(currentLocation);
                    newDrink.setName(currentName);
                    newDrink.setPrice(currentPrice);
                    newDrink.setMessage(DRINK_MESSAGE);
                    newInventory.add(newDrink);
                } else if (currentType.equals("Munchy")) {
                    Munchy newMunchy = new Munchy(currentLocation, currentName, currentPrice, MUNCHY_MESSAGE);
                    newMunchy.setLocation(currentLocation);
                    newMunchy.setName(currentName);
                    newMunchy.setPrice(currentPrice);
                    newMunchy.setMessage(MUNCHY_MESSAGE);
                    newInventory.add(newMunchy);
                } else if (currentType.equals("Gum")) {
                    Gum newGum = new Gum(currentLocation, currentName, currentPrice, GUM_MESSAGE);
                    newGum.setLocation(currentLocation);
                    newGum.setName(currentName);
                    newGum.setPrice(currentPrice);
                    newGum.setMessage(GUM_MESSAGE);
                    newInventory.add(newGum);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }
        return newInventory;
    }


}

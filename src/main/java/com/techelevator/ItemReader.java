package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class ItemReader {

    private File itemList = new File("main.csv");
    public ItemReader() {
    }


    public void displayInventory() {
        Scanner fileScanner;
        try{
            fileScanner = new Scanner(itemList);
            try {
                itemList.createNewFile();
            }catch (IOException e) {
                System.out.println("File error.");
                System.exit(1);
            }
            while(fileScanner.hasNextLine()) {
                String[] currentItem = fileScanner.nextLine().split(",");
                String currentLocation = currentItem[0];
                String currentName = currentItem[1];
                BigDecimal currentPrice = BigDecimal.valueOf(Double.valueOf(currentItem[2]));
                String currentType = currentItem[3];
                System.out.println(currentLocation + ". " + currentName + ", $" + currentPrice);
            }
        } catch (FileNotFoundException e) {
            System.out.println( "File not found");
            System.exit(1);
        }

    }

}

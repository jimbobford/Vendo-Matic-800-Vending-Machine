package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemReaderTest {
    ItemReader itemReader;
    @Before
    public void setup(){
        itemReader = new ItemReader();
    }
    @Test
    public void can_create_inventory(){
        List<Item> inventory = itemReader.createInventory();
        assertNotNull(inventory);
    }

//    @Test
//    public void can_display_inventory(){
//        List<Item> inventory = itemReader.createInventory();
//        itemReader.invDisplay(inventory);
//        if(inventory != null){
//
//        }
//    }
}

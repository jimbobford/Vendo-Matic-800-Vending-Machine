package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CandyTest {

    @Test
    public void can_construct_candy_test () {
    }

    @Test
    public void purchase_made_should_reduce_inventory(){
        Candy candy = new Candy();
        int adjustedInv = 4;
        candy.purchaseMade();
        assertEquals(adjustedInv, candy.getInventory());
    }
}

package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MachineFundsTest {

    MachineFunds funds;

    @Before
    public void setup(){
        funds = new MachineFunds();
    }

    @Test
    public void can_dispense_change(){
        funds.setBalance(new BigDecimal("2.35"));
        funds.dispenseChange();
        assertEquals(new BigDecimal("0.00"),funds.getBalance());

    }

}

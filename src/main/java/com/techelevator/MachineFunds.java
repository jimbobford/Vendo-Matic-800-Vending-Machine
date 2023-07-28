package com.techelevator;

import java.math.BigDecimal;

public class MachineFunds {

    private BigDecimal balance = new BigDecimal("0");

    public BigDecimal getBalance() {
        return balance;
    }

    public void increaseBalance(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public void decreaseBalance(BigDecimal amount){
        this.balance = this.balance.subtract(amount);
    }

    public String dispenseChange(){


        return null;
    }

}



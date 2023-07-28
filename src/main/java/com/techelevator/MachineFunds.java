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


    public void dispenseChange(){
        final BigDecimal QUARTER = new BigDecimal("0.25");
        final BigDecimal DIME = new BigDecimal("0.10");
        final BigDecimal NICKEL = new BigDecimal("0.05");
        final BigDecimal PENNY = new BigDecimal("0.01");

        BigDecimal change = this.balance;

        int quarterAmount = change.divideToIntegralValue(QUARTER).intValue();
        change = change.subtract(QUARTER.multiply(new BigDecimal(quarterAmount)));

        int dimeAmount = change.divideToIntegralValue(DIME).intValue();
        change = change.subtract(DIME.multiply(new BigDecimal(dimeAmount)));

        int nickelAmount = change.divideToIntegralValue(NICKEL).intValue();
        change = change.subtract(NICKEL.multiply(new BigDecimal(nickelAmount)));

        int pennyAmount = change.divideToIntegralValue(PENNY).intValue();

        System.out.println("The total change is $" + this.balance);
        System.out.println("This amounts to " + quarterAmount + " quarters, " + dimeAmount + " dimes, " + nickelAmount + " nickels, and " + pennyAmount + " pennies.");
        this.balance = this.balance.subtract(this.balance);
    }


}



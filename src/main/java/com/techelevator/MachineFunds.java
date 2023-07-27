package com.techelevator;

import java.math.BigDecimal;

public class MachineFunds {
    private BigDecimal comparisonZero = BigDecimal.valueOf(0.00);
    private BigDecimal currentBalance = BigDecimal.valueOf(0.00);
    private BigDecimal moneyAdded = BigDecimal.valueOf(0.00);
    private BigDecimal changeAmount;

    public MachineFunds() {
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public BigDecimal getMoneyAdded() {
        return moneyAdded;
    }

    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    public void setMoneyAdded(BigDecimal moneyAdded) {
        this.moneyAdded = moneyAdded;
    }

    public void addMoney(String input) {
        BigDecimal moneyToAdd = BigDecimal.valueOf(Double.valueOf(input));
        this.currentBalance = currentBalance.add(moneyToAdd);
    }

    public void makePurchase(String input)  {
        BigDecimal moneyToSubtract = BigDecimal.valueOf(Double.valueOf(input));
        this.currentBalance = currentBalance.subtract(moneyToSubtract);

    }

}

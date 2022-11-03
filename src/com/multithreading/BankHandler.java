package com.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

abstract class BankHandler {
    private String title;
    private int moneyAmount;
    private AtomicInteger balance;

    BankHandler(String title, int moneyAmount){
        this.title = title;
        this.moneyAmount = moneyAmount;
        balance = new AtomicInteger(moneyAmount);
    }

    public synchronized boolean subtractMoney(int value){
        if(balance.get() >= value){
            balance.getAndAdd(-value);
            return true;
        }
            return false;
    }

    public String getTitle(){
        return title;
    }

    protected AtomicInteger getBalance(){
        return balance;
    }


}

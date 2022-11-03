package com.multithreading;

public class Client extends Thread{
    private String name;
    private int clientBalance;
    private BankHandler bank;

    Client(String name, BankHandler bank){
        this.name = name;
        clientBalance = 0;
        this.bank = bank;
    }

    private void addMoney(int value){
        clientBalance += value;
    }

    public String getClientName(){
        return name;
    }

    @Override
    public void run(){
        try {
            int withdrawValue = 500;
            System.out.println(String.format("[%s] клиент %s начал снимать средства...", bank.getTitle(), name));
            Thread.sleep(2500);
                if(bank.subtractMoney(withdrawValue)){
                    addMoney(withdrawValue);
                    System.out.println(String.format("[%s] клиент %s[$%d] снял $%d ✅", bank.getTitle(), name, clientBalance, withdrawValue));
                }else{
                    System.err.println(String.format("[%s] клиенту %s не удалось снять деньги ❌", bank.getTitle(), name));
                }

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }


}

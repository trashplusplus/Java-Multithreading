package com.multithreading;

import java.util.LinkedList;
import java.util.List;

public class Bank extends BankHandler {
    private List<Client> clientList = new LinkedList<>();
    Bank(String title, int moneyAmount) {
        super(title, moneyAmount);
    }

    public void newClient(String client){
        clientList.add(new Client(client, this));
    }


    public void processAll(){
        for(Client client: clientList){
            client.start();
        }
    }

    public void remainingBalance(){
        System.out.println(String.format("[%s] в банке осталось $%s", this.getTitle(), getBalance().toString()));
    }
}

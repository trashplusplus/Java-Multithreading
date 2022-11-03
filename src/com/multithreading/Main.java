package com.multithreading;


import java.util.Scanner;

public class Main{
    public static void main(String args[]) {
        Bank bank;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название банка: ");
        String bankName = scanner.nextLine();
        System.out.println("Введите количество денег: ");
        int bankMoney = scanner.nextInt();

        bank = new Bank(bankName, bankMoney);

         bank.newClient("Жора");
         bank.newClient("Виктор");
         bank.newClient("Алекс");

         bank.processAll();


    }
}


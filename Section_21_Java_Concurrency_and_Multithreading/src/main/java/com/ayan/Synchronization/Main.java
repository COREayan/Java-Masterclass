package com.ayan.Synchronization;

public class Main {
    public static void main(String[] args) {
        BankAccount companyAccount = new BankAccount("Tom", 10000);

        Thread thread1 = new Thread(() -> companyAccount.withdraw(2500));
        Thread thread2 = new Thread(() -> companyAccount.deposit(5000));
        Thread thread3 = new Thread(() -> companyAccount.setName("Tim"));
        Thread thread4 = new Thread(() -> companyAccount.withdraw(5000));

        try {
            thread1.start();
            thread2.start();
            Thread.sleep(500);
            thread3.start();
            thread4.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + companyAccount.getBalance());
    }
}

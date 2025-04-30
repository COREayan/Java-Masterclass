package com.ayan.ThreadChallenge;

// Step 1 : You should make one thread subclass the java.lang.Thread class.
class EvenThread extends Thread {
    @Override
    public void run() {
        // Step 3: The first thread's code should print 5 even numbers
        for (int i=1; i<=5; i++){
            System.out.println("Even1, prints : " + i*2 + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Even1 finished execution");
    }
}

// Step 2 : The other should be created using a Runnable, which you can pass to the Thread constructor. This can be any class that implements Runnable, or a lambda expression.
class OddThread implements Runnable {
    @Override
    public void run() {
        // Step 3: the second thread should print 5 odd numbers.
        for (int i=1; i<=10; i+=2) {
            System.out.println("Odd1, prints : " + i + " ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Odd1 Finished Execution");
    }
}

public class Main {
    public static void main(String[] args) {
        // Step 4: You should execute them asynchronously, calling the start method on each, in two consecutive statements, in your main code.
        Thread even = new EvenThread();
        even.setName("First Even");

        Thread odd = new Thread(new OddThread());
        odd.setName("First Odd");

        Thread odd2 = new Thread(() -> {
            for (int i=1; i<=10; i+=2) {
                System.out.println("Odd2, prints : " + i + " ");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println("Odd2 finished execution");
        });
        odd2.setName("Second Odd");

        even.start();
        odd.start();
        odd2.start();

        try {
            Thread.sleep(5000);
            odd2.interrupt();
            System.out.println("Odd2 stopped execution");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

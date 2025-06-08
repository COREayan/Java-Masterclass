package com.ayan.Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class ColorThreadFactor implements ThreadFactory {

    private String threadName;

    public ColorThreadFactor(ThreadColor color) {
        this.threadName = color.name();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(threadName);
        return thread;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var blueExecutor = Executors.newSingleThreadExecutor(
                new ColorThreadFactor(ThreadColor.ANSI_BLUE)
        );
        blueExecutor.execute(Main::countDown);
        blueExecutor.shutdown();

        boolean isDone = false;
        isDone = blueExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);

        if (isDone) {
            System.out.println("Blue finished, starting Yellow");
            var yellowExecutor = Executors.newSingleThreadExecutor(
                    new ColorThreadFactor(ThreadColor.ANSI_YELLOW)
            );
            yellowExecutor.execute(Main::countDown);
            yellowExecutor.shutdown();

            isDone = yellowExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);

            if (isDone) {
                System.out.println("Yellow finished, starting Red");
                var redExecutor = Executors.newSingleThreadExecutor(
                        new ColorThreadFactor(ThreadColor.ANSI_RED)
                );
                redExecutor.execute(Main::countDown);
                redExecutor.shutdown();

                isDone = redExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
                if (isDone) {
                    System.out.println("All processes completed");
                }
            }
        }

    }

    public static void notmain(String[] args) throws InterruptedException {
        Thread blue = new Thread(Main::countDown, ThreadColor.ANSI_BLUE.name());

        Thread yellow = new Thread(Main::countDown, ThreadColor.ANSI_YELLOW.name());

        Thread red = new Thread(Main::countDown, ThreadColor.ANSI_RED.name());

        /*
        blue.start();
        yellow.start();
        red.start();

        blue.join();
        yellow.join();
        red.join();
         */

        blue.start();
        blue.join();

        yellow.start();
        yellow.join();

        red.start();
        red.join();
    }

    private static void countDown() {
        String threadName = Thread.currentThread().getName();
        var threadColor = ThreadColor.ANSI_RESET;
        try {
            threadColor = ThreadColor.valueOf(threadName.toUpperCase());
        } catch (IllegalArgumentException ignore) {
            // User may pass a bad color name, Will just ignore this error.
        }

        String color = threadColor.color();
        for (int i=20; i>=0; i--) {
            System.out.println(color + " " + threadName.replace("ANSI_", "") + " " + i);
        }
    }

}

package com.ayan.Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class ColorThreadFactory implements ThreadFactory {

    private String threadName;

    private int colorValue = 1;

    public ColorThreadFactory(ThreadColor color) {
        this.threadName = color.name();
    }

    public ColorThreadFactory() {

    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        String name = threadName;
        if (name == null) {
            name = ThreadColor.values()[colorValue].name();
        }
        if (++colorValue > (ThreadColor.values().length - 1)) {
            colorValue = 1;
        }

        thread.setName(name);
        return thread;
    }
}

public class Main {
    public static void main(String[] args) {
        int count = 6;
        var multiExecutor = Executors.newFixedThreadPool(
                count, new ColorThreadFactory()
        );

        for (int i=0; i<count; i++) {
            multiExecutor.execute(Main::countDown);
        }

        multiExecutor.shutdown();
    }

    public static void singlemain(String[] args) throws InterruptedException {
        var blueExecutor = Executors.newSingleThreadExecutor(
                new ColorThreadFactory(ThreadColor.ANSI_BLUE)
        );
        blueExecutor.execute(Main::countDown);
        blueExecutor.shutdown();

        boolean isDone = false;
        isDone = blueExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);

        if (isDone) {
            System.out.println("Blue finished, starting Yellow");
            var yellowExecutor = Executors.newSingleThreadExecutor(
                    new ColorThreadFactory(ThreadColor.ANSI_YELLOW)
            );
            yellowExecutor.execute(Main::countDown);
            yellowExecutor.shutdown();

            isDone = yellowExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);

            if (isDone) {
                System.out.println("Yellow finished, starting Red");
                var redExecutor = Executors.newSingleThreadExecutor(
                        new ColorThreadFactory(ThreadColor.ANSI_RED)
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

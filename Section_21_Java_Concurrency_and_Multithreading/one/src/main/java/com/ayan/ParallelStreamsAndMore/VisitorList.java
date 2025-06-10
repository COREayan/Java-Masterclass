package com.ayan.ParallelStreamsAndMore;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VisitorList {
    private static final ArrayBlockingQueue<Person> newVisitors = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        Runnable producer = () -> {
            Person visitor = new Person();
            System.out.println("Adding " + visitor);
            boolean queued = false;
            try {
                queued = newVisitors.add(visitor);
            } catch (IllegalStateException e) {
                System.out.println("Illegal State Exception!");
            }
            if (queued) {
                System.out.println(newVisitors);
            } else {
                System.out.println("Queue is Full, cannot add " + visitor);
           }
        };

        ScheduledExecutorService producerExecutor = Executors.newSingleThreadScheduledExecutor();
        producerExecutor.scheduleWithFixedDelay(producer, 0, 1, TimeUnit.SECONDS);

        while (true) {
            try {
                if (!producerExecutor.awaitTermination(10, TimeUnit.SECONDS))
                    break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        producerExecutor.shutdown();
    }
}

package com.WaitAndNotify;

public class WaitNotifyDemo {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i <= 5; i++) {
                    sharedData.produce(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i <= 5; i++) {
                    sharedData.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });


        producerThread.start();
        consumerThread.start();

    }
}

package org.Aditya.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(350);
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            Integer a = i;
            es.submit(() -> {
                System.out.println("i = "+ a + " Task is Running in : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        es.shutdown();
        try {
            es.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("Done!!");
        System.out.println("Time taken : "+(end-start) + " ms Threads : " + Thread.currentThread().getName());


//        int cores = Runtime.getRuntime().availableProcessors();
//        System.out.println("Cores: "+cores);
//
//        int optimalThreads = Runtime.getRuntime().availableProcessors() + 1;
//        System.out.println("Optimal Threads : " + optimalThreads);
    }
}

package com.Aditya;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 2000;

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(90)
        );

        long start = System.currentTimeMillis();
        for(int i = 0; i<100; i++){
            threadPoolExecutor.submit(() -> {
                System.out.println("Task is Running in : " + Thread.currentThread().getName());
                try{
                    Thread.sleep(100);
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            });
        }

        try {
            Thread.sleep(4000);
            for(int i = 0; i<6; i++){
                threadPoolExecutor.submit(() -> {
                    System.out.println("New Task is Running in : " + Thread.currentThread().getName());
                    try{
                        Thread.sleep(10);
                    } catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        threadPoolExecutor.shutdown();

        try {
            threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("Total Time : " + (end - start) + " ms Threads : " + Thread.currentThread().getName());
    }
}

//30:18
// ``

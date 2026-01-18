package com.MiniProject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VisitorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);


        VisitorCounterTask visitorCounterTask = new VisitorCounterTask();
        for(int i = 0; i<1000; i++){
            executorService.submit(visitorCounterTask);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(4, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total Visitors: " + visitorCounterTask.getCount());

        System.out.println("Done!!");
    }
}
//54:31
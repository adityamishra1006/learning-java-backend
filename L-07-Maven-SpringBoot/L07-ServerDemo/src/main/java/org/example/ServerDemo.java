package org.example;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerDemo {
    public static void main(String[] args) {
        System.out.println("Starting server...");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter request data: ");
            String data = sc.nextLine();
            Runnable runnable = () ->process(data);
            executorService.submit(runnable);
//            process(data);
        }
    }

    private static void process(String data) {
        // Simulate processing the request
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Processing in : " + Thread.currentThread().getName() + " data: " + data);
    }
}

package com.Aditya;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task = new Task();
        Future<Signal> futureService =  executorService.submit(() -> {
            System.out.println("Executing in : " + Thread.currentThread().getName());
            return new Signal();
        });
        Future<String> stringFuture = executorService.submit(task);

        try {
            String data = stringFuture.get(10, TimeUnit.SECONDS);
            System.out.println(data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done with Callable task execution.");

        List<Task> list = new ArrayList<>();
        list.add(task);
        list.add(new Task());
        list.add(new Task());
        list.add(new Task());


        try {
            List<Future<String>>futureList =  executorService.invokeAll(list);
            for(Future<String> future : futureList){
                try {
                    System.out.println(future.get());
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


}


class Task implements Callable<String> {

    @Override
    public String call() throws Exception {

        /*
        This method is called when the task is executed.
         */
        return "Result : " + Math.random() * 1000;
    }
}
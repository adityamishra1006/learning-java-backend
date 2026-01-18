package org.Aditya.threads;

public class MyTask implements Runnable{
    public void run(){
        System.out.println("Task Running in : " + Thread.currentThread().getName());
    }
}

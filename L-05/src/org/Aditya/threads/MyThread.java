package org.Aditya.threads;

public class MyThread extends Thread{
    public void run(){
        System.out.println("Thread Running in : " + Thread.currentThread().getName());   
    }
}

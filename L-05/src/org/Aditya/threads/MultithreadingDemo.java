package org.Aditya.threads;

public class MultithreadingDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1.Hello ");
        System.out.println("2.Hello ");

        Thread thread = new Thread(()->{
            System.out.println("4.1 Hello "+Thread.currentThread().getName());
        });
        thread.setName("My-Thread-`1`");
        thread.start();  //Runnable State

        // Runnable State -> Running State: Not in our hand.

        System.out.println("3.Hello ");
        thread.join();
        System.out.println("4.2.Hello ");
        System.out.println("5.Hello "+Thread.currentThread().getName());
    }
}


//1:37
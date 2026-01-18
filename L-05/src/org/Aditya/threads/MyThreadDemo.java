package org.Aditya.threads;

public class MyThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.setName("My-Thread");
//        thread.run();
        thread.start();

        thread.join();

        System.out.println("Done");
    }
}

package com.WaitAndNotify;

public class SharedData {

    private int data;
    private boolean isDataAvailable = false;

    public synchronized void produce(int val) throws InterruptedException{
        while(isDataAvailable){
            wait();
        }

        this.data = val;
        System.out.println("Produced: " + val);
        isDataAvailable = true;
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while(!isDataAvailable){
            wait();
        }

        System.out.println("Consumed: " + data);
        isDataAvailable = false;
        notify();
        return data;
    }

}

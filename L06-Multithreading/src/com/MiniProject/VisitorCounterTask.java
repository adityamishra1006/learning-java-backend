package com.MiniProject;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VisitorCounterTask implements Runnable {
//    private int count;

//    private AtomicInteger count = new AtomicInteger();

    private Lock lock = new ReentrantLock();

    private int count = 0;

//    public synchronized void increment() {
//        count++;
//    }

//    public void increment() {
//
//        /*
//        10 lines
//         */
//        count.incrementAndGet();
//        /*
//        10 lines
//         */
//    }

    public void increment() {
        lock.lock();
        count++;
        lock.unlock();
    }


//    public void increment() {
//        synchronized (this){
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            count++;
//            this.notify();
//        }
//    }


//    public int getCount() {
//        return count.get();
//    }
    public int getCount() {
        return count;
    }

    @Override
    public void run(){
        increment();
    }
}

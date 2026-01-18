package org.Aditya.threads;

public class RunnableDemo {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        task.run();

        Thread thread = new Thread(task);
        thread.setName("worker-thread");
        thread.start();



        Thread thread2 = new Thread(task);
        thread2.setName("worker-thread-02");
        thread2.start();


        System.out.println("Done");
    }
}

package com.gfg.multithreading.sleepjoin;

public class ThreadsJoinExample implements Runnable {

    private String message;

    public ThreadsJoinExample(String message) {
        this.message = message;
    }
    /*
    * join() method is used to hold the execution of currently running thread until the specified thread is dead(finished execution).
    * */

    @Override
    public void run() {
        for(int i=0;i<5;i++)
            System.out.println(Thread.currentThread().getName() + " : " +message);
    }

    public static void main(String[] args) {
        Thread firstThread = new Thread(new ThreadsJoinExample("Hello from firstThread"));

        Thread secondThread = new Thread(new ThreadsJoinExample("Hello from secondThread"));

        firstThread.start();

        try {
            firstThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        secondThread.start();

        try {
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

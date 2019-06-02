package com.gfg.multithreading.sleepjoin;

public class ThreadSleepExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Current Thread : "+Thread.currentThread().getName());
        System.out.println("Thread Starts");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Ends");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadSleepExample());
        thread.start();
    }
}

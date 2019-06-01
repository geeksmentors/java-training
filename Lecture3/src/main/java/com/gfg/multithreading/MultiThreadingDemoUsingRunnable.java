package com.gfg.multithreading;

public class MultiThreadingDemoUsingRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside run of MultiThreadingDemoUsingThread");
        System.out.println("Thread name : "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        System.out.println("In Main");
        Thread thread = new Thread(new MultiThreadingDemoUsingRunnable());
        thread.start();


    }

}

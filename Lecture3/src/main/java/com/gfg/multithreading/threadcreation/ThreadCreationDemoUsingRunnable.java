package com.gfg.multithreading.threadcreation;

public class ThreadCreationDemoUsingRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside run of ThreadCreationDemoUsingThread");
        System.out.println("Thread name : "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        System.out.println("In Main");
        Thread thread = new Thread(new ThreadCreationDemoUsingRunnable());
        thread.start();


    }

}

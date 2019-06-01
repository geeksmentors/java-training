package com.gfg.multithreading;

public class MultiThreadingDemoUsingThread extends Thread {

    @Override
    public void run(){
        System.out.println("Inside run of MultiThreadingDemoUsingThread");
        System.out.println("Thread name : "+Thread.currentThread().getName());
    }


    public static void main(String[] args) {

        System.out.println("In Main");
        MultiThreadingDemoUsingThread multiThreadingDemoUsingThread = new MultiThreadingDemoUsingThread();
        multiThreadingDemoUsingThread.start();


    }



}

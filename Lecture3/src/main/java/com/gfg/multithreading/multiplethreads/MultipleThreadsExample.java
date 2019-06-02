package com.gfg.multithreading.multiplethreads;

public class MultipleThreadsExample implements Runnable {

    private String message;

    public MultipleThreadsExample(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++)
        System.out.println(Thread.currentThread().getName() + " : " +message);
    }


    public static void main(String[] args) {
        Thread firstThread = new Thread(new MultipleThreadsExample("Hello from firstThread"));
        Thread secondThread = new Thread(new MultipleThreadsExample("Hello from secondThread"));


        firstThread.start();
        secondThread.start();

    }
}

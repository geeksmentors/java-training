package com.gfg.multithreading;

public class ThreadRunVsStartExample  implements Runnable{
    @Override
    public void run() {
        System.out.println("Inside run of MultiThreadingDemoUsingThread");
        System.out.println("Thread name : "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadRunVsStartExample());
        //calling start()
        // thread.start();

        //calling run
        //thread.run();
    }
}

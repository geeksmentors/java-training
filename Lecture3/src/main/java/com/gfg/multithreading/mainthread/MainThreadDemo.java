package com.gfg.multithreading.mainthread;

public class MainThreadDemo {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();

        System.out.println("Name of Current Thread : " + thread.getName());

        thread.setName("Modified Main");

        System.out.println(thread.getName());
    }
}

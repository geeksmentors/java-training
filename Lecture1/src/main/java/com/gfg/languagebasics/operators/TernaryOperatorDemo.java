package com.gfg.languagebasics.operators;

public class TernaryOperatorDemo {

    public static void main(String[] args)
    {
        int a = 20, b = 10, result;

        // result holds max of three
        // numbers
        result = a>b ? a: b;
        System.out.println("Max of two numbers = "
                + result);
    }
}

package com.gfg.languagebasics.decisionmaking;

import java.util.Scanner;

public class SwitchCaseWithStringDemo {


    public static void main(String[] args)
    {
        String str ;

        Scanner scanner = new Scanner(System.in);
        str = scanner.next();
        switch(str)
        {
            case "one":
                System.out.println("one");
                break;
            case "two":
                System.out.println("two");
                break;
            case "three":
                System.out.println("three");
                break;
            default:
                System.out.println("no match");
        }
    }
}

package com.gfg.languagebasics.operators;

import java.util.Scanner;

public class LogicalOperatorsDemo {
    public static void main(String[] args)
    {
        String savedUsername = "Sher";
        String savedPassword = "Locked";

        Scanner s = new Scanner(System.in);
        System.out.print("Enter username:");
        String uuid = s.next();
        System.out.print("Enter password:");
        String upwd = s.next();

        // Check if user-name and password match or not.
        if ((uuid.equals(savedUsername) && upwd.equals(savedPassword))
                || (uuid.equals(savedPassword) && upwd.equals(savedUsername))) {
            System.out.println("Welcome user.");
        }
        else {
            System.out.println("Wrong uid or password");
        }
    }

}

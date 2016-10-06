package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please, enter your name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
//        if ("Eugen".contentEquals(name)) {
//            System.out.println("Hello, Eugen");
//        } else {
//            System.out.println("Goodbye!");
//        }

        switch (name) {
            case "Eugen":
                System.out.println("Hello, Eugen!");
                break;
            default:
                System.out.println("Hello, <noname>!");
                break;
        }
    }
}

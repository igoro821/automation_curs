package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter number:");
        int size = scanner.nextInt();
        while (size > 0) {
            System.out.println(size);
            size--;//size = size - 1;
        }

        do {
            System.out.println(size);
        } while (1 > 3);

        for (int i = size; i > 0; i--) {
            System.out.println(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.print("I - ");
            System.out.println(i);
            for (int j = 0; j < 5; j++) {
                System.out.print("J - ");
                System.out.println(j);
            }
        }
    }
}

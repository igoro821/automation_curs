package com.company;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {165, 22, 13};
//        for (int index = 0; index < numbers.length; index++) {
//            System.out.println(numbers[index]);
//        }

//        for (int number : numbers) {
//            System.out.println(number);
//        }
//
//        String[] strs = {"Eugen", "Olya"};
//        for (String name : strs) {
//            System.out.println(name);
//        }

        String[][] strs2 = {
                {"A", "B"},
                {"C", "D"},
                {"E", "F"}
        };

        for (String[] s : strs2) {
            for (String s2 : s) {
                System.out.print(s2 + " ");
            }
            System.out.print("\n");
        }
    }
}

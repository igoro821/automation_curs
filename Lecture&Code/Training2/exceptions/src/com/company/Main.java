package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            int x = 3 / 0;
        } catch (ArithmeticException ex) {
            throw new DivideByZeroException("Please, do not divide by zero");
        }
    }
}

package com.company;

public class Main {

    static int m = 13;

    public static void main(String[] args) {
        int y = 111;
        m = 200;
        print();
        byte b = 127;
        int x = 120;
        double d = 39.85;
        char c = 'c';
        char c2 = 'b';
        boolean bool = true;

        System.out.println("Hello world!");
        System.out.println(x);
        System.out.println((byte) (b + 27));
        System.out.println((int) d);
        System.out.println(Math.round(d));
        System.out.println(c);
        System.out.println(bool);
    }

    public static void print() {
        System.out.println(m);
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
        String s = "a";
        String s2 = "a";
        String s3 = new String("a");
        StringBuilder s4 = new StringBuilder("a");
        System.out.println(s == s2);
        System.out.println(s == s3);
        System.out.println(s.equals(s2));
        System.out.println(s.equals(s3));
        System.out.println(s.equals(s4));
        System.out.println(s.contentEquals(s4));
    }
}

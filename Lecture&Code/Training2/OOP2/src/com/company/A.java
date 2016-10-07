package com.company;

/**
 * Created by student on 06.10.2016.
 */
public class A {

    public static String planet = "Earth";
    public static final int age;
    protected String name;
    private double weight;

    static {
        age = 77;
    }

//    public A() {
//        age = 1110;
//    }

    public final void print() {
        System.out.println("Hello from super class!");
    }
}

package com.company;

import tests.B;

public class Main {

    public static void main(String[] args) {
        A a = new A();

        A a1 = new A();
        a1.planet = "Mars";

        System.out.println(a.planet);

        C c = new C() {
            @Override
            public void print(double x) {
                System.out.println("HEEEEEE");
            }
        };
        c.print(33.2);
    }
}

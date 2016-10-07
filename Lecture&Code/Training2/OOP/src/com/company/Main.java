package com.company;

public class Main {

    public static void main(String[] args) {
        int x = 10;
        ClassB y = new ClassB(10);

        changeValue(x);
        changeValueForObject(y);

        System.out.println(x);
        System.out.println(y.x);

        Human h1 = new Human();
        Human h2 = new Human();
        Human h3 = new Human("John", 55);

        System.out.println(h3.getAge());

        h1.setAge(1000);
        h2.setAge(29);
        h1.eat("Apple");

        System.out.println(h1.getAge());
        System.out.println(h2.getAge());
    }

    public static void changeValue(int x) {
        x += 5;
    }

    public static void changeValueForObject(ClassB y) {
        y.x += 5;
    }
}

package com.company;

/**
 * Created by student on 06.10.2016.
 */
public class Human {

    private int age;
    private String name;

    public Human() {

    }

    public Human(String name) {

    }

    public Human(int age) {

    }

    public Human(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int a) {
        if (a < 0) {
            System.out.println("Your age is incorrect!");
        } else {
            age = a;
        }
    }

    public int getAge() {
        return age;
    }

    void eat(String food) {
        age--;
        System.out.println(String.format("I'm eating %s", food));
    }
}

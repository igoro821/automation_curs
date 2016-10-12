package com.company;

public class Main {

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
//        homePage.goTo("Help");
        System.out.println(HomePage.Tabs.EVENTS);
        homePage.goTo(HomePage.Tabs.HELP);
    }
}

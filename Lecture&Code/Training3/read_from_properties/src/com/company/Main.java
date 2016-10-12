package com.company;

import java.util.Properties;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(DbConfig.getValue("db.username"));
    }
}

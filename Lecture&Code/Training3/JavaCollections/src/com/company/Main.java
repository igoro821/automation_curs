package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        File file = new File();

//        ArrayList<String> names = new ArrayList<>();
//        names.add("Eugen");
//        names.add("John");
//        names.add("Michail");
//        names.add(1, "Vika");
////        names.get(2)
//        int index = names.indexOf("John5");
//        System.out.println(index);
//        for (String name : names) {
//            System.out.println(name);
//        }

//        List<String> cities = new LinkedList<>();
//
//        Set<Integer> ages = new HashSet<>();
//        ages.add(55);
//        ages.add(14);
//        ages.add(17);
//        ages.add(17);
//        for (Integer age : ages) {
//            System.out.println(age);
//        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Eugen", 100);
        map.put("Vika", 77);
        map.put("John", 33);
//        System.out.println(map.get("Eugen"));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" -> ");
            System.out.print(entry.getValue() + "\n");
        }
    }
}

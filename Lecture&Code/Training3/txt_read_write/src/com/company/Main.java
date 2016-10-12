package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (FileWriter fileWriter = new FileWriter("d:\\sample1.txt")) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("He444llo world!\r\n");
//            bufferedWriter.newLine();
            bufferedWriter.write("Goodbye555!");
            bufferedWriter.close();
        }

        try (FileReader fileReader = new FileReader("d:\\sample1.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                System.out.println(str);
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
    }
}

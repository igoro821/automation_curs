package helper;


import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by student on 06.09.2016.
 */
public class CommonDataProvider {

    private static List<String> getLinesFromFile(String pathToFile) throws IOException {
        List<String> lines = new LinkedList<>();
        java.io.File file = new File(pathToFile);
        java.io.FileReader fileReader = new java.io.FileReader(file.getAbsolutePath());
        java.io.BufferedReader reader = new BufferedReader(fileReader);
        String str = "";
        while ((str = reader.readLine()) != null) {
            lines.add(str);
        }
        return lines;
    }

    private static Object[][] getDataSets(String pathToFile, String devider) throws IOException {
        List<String> lines = getLinesFromFile(pathToFile);
        int y = lines.size();
        int x = lines.get(0).split(devider).length;
        Object[][] datasets = new Object[y][x];

        int i = 0;
        for (String line : lines) {
            datasets[i] = line.split(devider);
            i++;
        }

        return datasets;
    }

    @DataProvider
    public static Object[][] myProvider() throws IOException {
        return getDataSets("src/main/resources/myProvider.txt", ",");
    }
}

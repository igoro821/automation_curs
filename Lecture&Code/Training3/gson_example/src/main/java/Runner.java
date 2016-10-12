import com.google.gson.Gson;
import java.io.*;

/**
 * Created by student on 11.10.2016.
 */
public class Runner {

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Human h1 = new Human("Eugen", 40);
        Human h2 = new Human("John", 12);
        Human[] h3;

        h1.setWeight(55.6);
        h1.setHeight(1.77);
        h1.setKmt();
        Human[] h = new Human[] { h1, h2};
        String json = gson.toJson(h);
        try (FileWriter fileWriter = new FileWriter("d:\\human.json")) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(json);
            bufferedWriter.close();
        }

        try (FileReader fileReader = new FileReader("d:\\human.json")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            h3 = gson.fromJson(bufferedReader.readLine(), Human[].class);
        }
        System.out.println();
    }
}

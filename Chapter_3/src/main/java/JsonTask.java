import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;
/**
 * Created by tarasenko on 17.10.16.
 */
public class JsonTask {

    Car [] all;
    Car [] allOutPut;

    JsonTask(){
        Car mersedes = new Car ("mini", "mersedes", 150);
        Car vaz= new Car ("sedan", "vaz", 300);
        Car vw = new Car ("long", "vw", 400);
        Car audi = new Car ("sedan", "audi", 500);
        Car gm = new Car ("sedan", "gm", 600);
        all = new Car [] {mersedes, vaz, vw, audi, gm};
    }

    public void run () throws IOException{
        Gson gson = new Gson();
        String json = gson.toJson(all);
        try (FileWriter fileWriter = new FileWriter("src\\resources\\car.json")) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(json);
            bufferedWriter.close();
        }
        try (FileReader fileReader = new FileReader("src\\resources\\car.json")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            allOutPut = gson.fromJson(bufferedReader.readLine(), Car[].class);
            bufferedReader.close();
        }
        for (Car i : allOutPut){
            System.out.print("Mark - " + i.getMark() + "; ");
            System.out.print("Type - " + i.getType() + "; ");
            System.out.println("Cost - " + i.getCost() + ".");
        }
    }
}
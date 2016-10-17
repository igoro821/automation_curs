import java.io.IOException;

/**
 * Created by tarasenko on 17.10.16.
 */
public class Main {

    public static void main (String [] args) throws IOException {
        StringToString stringToString = new StringToString("src\\resources\\resources.txt", "src\\resources\\output.txt");
        stringToString.transformFile();
        StringToXML stringToXML = new StringToXML("src\\resources\\contact.txt", "src\\resources\\contact.xml");
        stringToXML.transformFile();
        JsonTask jsonTask = new JsonTask();
        jsonTask.run();
    }
}
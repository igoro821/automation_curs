import java.io.*;

/**
 * Created by tarasenko on 17.10.16.
 */
public class StringToString {
    private String inPutPath;
    private String outPutPath;

    StringToString (String inPutPath, String outPutPath){
        this.inPutPath = inPutPath;
        this.outPutPath = outPutPath;
    }

    public void transformFile() throws IOException {
        try (FileReader fileReader = new FileReader(inPutPath)) {
            try (FileWriter fileWriter = new FileWriter(outPutPath)) {
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String str = bufferedReader.readLine();
                while (str != null) {
                    String[] strBufer = str.split("\\.");
                    for (int i = 0; i < strBufer.length; i++) {
                        if (i != 0 && i % 5 == 0) {
                            bufferedWriter.write(strBufer[i] + ". " + "\n");
                        }
                        bufferedWriter.write(strBufer[i] + ". ");
                    }
                    str = bufferedReader.readLine();
                }
                bufferedReader.close();
                bufferedWriter.close();
            }
        }
    }
}

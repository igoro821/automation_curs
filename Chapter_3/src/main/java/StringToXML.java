import org.xembly.Directives;
import org.xembly.ImpossibleModificationException;
import org.xembly.Xembler;

import java.io.*;

/**
 * Created by tarasenko on 17.10.16.
 */
public class StringToXML {
    private String inPutPath;
    private String outPutPath;

    StringToXML (String inPutPath, String outPutPath){
        this.inPutPath = inPutPath;
        this.outPutPath = outPutPath;
    }

    public void transformFile() throws IOException {
        try (FileReader fileReader = new FileReader(inPutPath)) {
            try (FileWriter fileWriter = new FileWriter(outPutPath)) {
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String str = bufferedReader.readLine();
                Directives xml = new Directives().add("contact_list");
                while (str != null) {
                    String[] strBufer = str.split(";");
                    for (String i : strBufer) {
                        String[] item = i.split(", ");
                        xml.add("contact").append(new Directives().add("FIO").set(item[0]).up().add("phone").set(item[1]).up().add("company").set(item[2]).up().add("position").set(item[3]).up()).up();
                    }
                    str = bufferedReader.readLine();
                }
                String xmlOutput = new Xembler(xml).xml();
                bufferedWriter.write(xmlOutput);
                bufferedReader.close();
                bufferedWriter.close();
            } catch (ImpossibleModificationException e) {
                e.printStackTrace();
            }
        }
    }
}

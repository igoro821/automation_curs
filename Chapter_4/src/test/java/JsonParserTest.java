import org.testng.Assert;
import org.testng.annotations.Test;
import parser.JsonParser;
import shop.Cart;
import parser.FileNotFoundException;

import java.io.File;

/**
 * Created by tarasenko on 19.10.16.
 */
public class JsonParserTest {

    private void writeToFileHelper (Cart cart){
        JsonParser jsonParser = new JsonParser();
        jsonParser.writeToFile(cart);
    }


    private Cart readFromFileHelper (Cart cart){
        JsonParser jsonParser = new JsonParser();
        return jsonParser.readFromFile(new File("src/main/resources/" + cart.getCartName() + ".json"));
    }

    @Test( dataProviderClass = Main.class, dataProvider = "CartDataProvider")
    public void testFileExisting(Cart cart){
        writeToFileHelper(cart);
        File file = new File("src/main/resources/" + cart.getCartName() + ".json");
        Assert.assertTrue(file.exists());
    }

    @Test(dataProviderClass = Main.class, dataProvider = "CartDataProvider")
    public void testFileReadCorrectName(Cart cart){
        writeToFileHelper(cart);
        Assert.assertEquals(cart.getCartName(), readFromFileHelper(cart).getCartName());
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public void testException(){
        Cart olaCart = new Cart("ola-cart");
        readFromFileHelper(olaCart);
    }
}

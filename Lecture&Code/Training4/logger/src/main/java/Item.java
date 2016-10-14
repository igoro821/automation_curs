import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by student on 13.10.2016.
 */
public class Item {

    private static final Logger LOGGER = LoggerFactory.getLogger(Item.class);
    private String name;
    private double price;

    public Item() {
        LOGGER.error("Please, do not create objects!");
    }

    public void setName(String name) {
        this.name = name;
        LOGGER.info(String.format("%s New name - %s", this, name));
//        System.out.println(String.format("%s New name - %s", this, name));
    }

    public void setPrice(double price) {
        this.price = price;
        LOGGER.info(String.format("%s New price - %s", this, price));
//        System.out.println(String.format("%s New price - %s", this, price));
    }
}

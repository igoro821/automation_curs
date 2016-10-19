package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by student on 06.09.2016.
 */
public class HomePage extends PageBase {

    private static final String URL = "https://www.onliner.by";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
    }

    public void load() {
        driver.get(URL);
    }
}

package page.app;

import base.PageBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by student on 27.10.2016.
 */
public class SentMailPage extends PageBase {

    private static final String URL = "https://mail.google.com/mail/#sent";

    public SentMailPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        driver.get(URL);
    }
}

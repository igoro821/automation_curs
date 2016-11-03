package page.app;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.Locators.get;

/**
 * Created by student on 27.10.2016.
 */
public class InboxPage extends PageBase {

    private static final String URL = "https://mail.google.com/mail/#inbox";

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        driver.get(URL);
    }
}

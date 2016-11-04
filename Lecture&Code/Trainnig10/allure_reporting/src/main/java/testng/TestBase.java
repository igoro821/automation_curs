package testng;

import org.openqa.selenium.WebDriver;

/**
 * Created by student on 03.11.2016.
 */
public class TestBase {

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }
}

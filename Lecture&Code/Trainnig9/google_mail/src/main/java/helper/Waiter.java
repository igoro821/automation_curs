package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by student on 01.11.2016.
 */
public class Waiter {

    public static WebDriverWait getWaiter(WebDriver driver) {
        return getWaiter(driver, 30);
    }

    public static WebDriverWait getWaiter(WebDriver driver, int seconds) {
        return new WebDriverWait(driver, seconds);
    }
}

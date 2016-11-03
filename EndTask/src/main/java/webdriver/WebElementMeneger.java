package webdriver;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * Created by tarasenko on 3.11.16.
 */
public class WebElementMeneger {

    public static boolean isDisplayed(WebElement webElement) {
        boolean isDisplayed;
        try {
            isDisplayed = webElement.isDisplayed();
        } catch (NoSuchElementException ex) {
            isDisplayed = false;
        }
        return isDisplayed;
    }
}

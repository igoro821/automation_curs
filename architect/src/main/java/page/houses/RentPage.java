package page.houses;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.Footer;
import page.Header;

import java.util.Arrays;

/**
 * Created by student on 06.09.2016.
 */
public class RentPage extends PageBase {

    private static final String URL = "https://";

    private static final By SUBMIT_BUTTON = By.id("s-button");
    private static final By SEARCH_INPUT = By.id("search");

    private final WebDriver driver;

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void load() {
        driver.get(URL);
        waitExpectedElements(Arrays.asList(SUBMIT_BUTTON, SEARCH_INPUT));
    }
}

package page.part;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.Locators.get;

/**
 * Created by student on 27.10.2016.
 */
public class Header {

    private static final By HEADER_CONTAINER = get("Header.Container");
    private static final By PROFILE_LINK = get("Header.ProfileLink");
    private WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProfileLinkDisplayed() {
        return driver.findElement(PROFILE_LINK).isDisplayed();
    }
}

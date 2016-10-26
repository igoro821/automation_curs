import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by student on 25.10.2016.
 */
public class InboxPage {

    private static final By LOGOUT_BUTTON = By.id("PH_logoutLink");

    public static boolean isLogoutButtonDisplayed(WebDriver driver) {
        return driver.findElement(LOGOUT_BUTTON).isDisplayed();
    }

    public static void logout(WebDriver driver) {
        driver.findElement(LOGOUT_BUTTON).click();
    }
}

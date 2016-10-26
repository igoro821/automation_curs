import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by student on 25.10.2016.
 */
public class InboxPage {

    private static final By LOGOUT_BUTTON = By.id("PH_logoutLink");
    private WebDriver driver;
    private MainHeader header;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        header = new MainHeader(driver);
    }

    public MainHeader getHeader() {
        return header;
    }

    public void goToGames() {
        header.goToGames();
    }

    public boolean isLogoutButtonDisplayed() {
        return driver.findElement(LOGOUT_BUTTON).isDisplayed();
    }

    public LoginPage logout() {
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }
}

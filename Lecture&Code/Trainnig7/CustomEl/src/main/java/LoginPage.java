import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by student on 25.10.2016.
 */
public class LoginPage {

    private static final By USERNAME_INPUT = By.id("mailbox__login");
    private static final By PASSWORD_INPUT = By.id("mailbox__password");
    private static final By LOGIN_BUTTON = By.id("mailbox__auth__button");
    private WebDriver driver;
    private MainHeader header;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        header = new MainHeader(driver);
    }

    public InboxPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

        return new InboxPage(driver);
    }

    public MainHeader getHeader() {
        return header;
    }

    public boolean isUsernameInputDisplayed() {
        return driver.findElement(USERNAME_INPUT).isDisplayed();
    }
}

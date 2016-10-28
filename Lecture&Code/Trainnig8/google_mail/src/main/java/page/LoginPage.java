package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.app.InboxPage;

import static helper.Locators.get;

/**
 * Created by student on 27.10.2016.
 */
public class LoginPage {

    private static final By EMAIL_INPUT = get("LoginPage.UsernameInput");
    private static final By NEXT_BUTTON = get("LoginPage.NextButton");
    private static final By PASSWORD_INPUT = get("LoginPage.PasswordInput");
    private static final By LOGIN_BUTTON = get("LoginPage.LoginButton");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public InboxPage login(String username, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(username);
        driver.findElement(NEXT_BUTTON).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

        return new InboxPage(driver);
    }
}

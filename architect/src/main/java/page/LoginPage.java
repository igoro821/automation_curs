package page;

import helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helper.Locators.get;

/**
 * Created by student on 06.09.2016.
 */
public class LoginPage {

    private static final By USERNAME_INPUT = get("LoginPage.UsernameInput");
    private static final By PASSWORD_INPUT = get("LoginPage.PasswordInput");
    private static final By LOGIN_BUTTON = get("LoginPage.LoginButton");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        Waiter.getWaiter(driver).until(ExpectedConditions.titleIs("Please login!"));
        driver.findElement(LOGIN_BUTTON).click();
    }
}

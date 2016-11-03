import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.app.InboxPage;
import page.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 27.10.2016.
 */
public class LoginTest extends TestBase {

    private static final String USERNAME = "seleniumtests10";
    private static final String PASSWORD = "060788avavav";
    private static String username;
    private InboxPage inboxPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        username = "TestUser" + getRandomNumber();

        super.setup();

        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        inboxPage = loginPage.login(USERNAME, PASSWORD);

        Assert.assertTrue(inboxPage.getHeader().isProfileLinkDisplayed(), "Profile link (image) didn't appear!");
    }
}

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
public class LoginTest {

    private static final String USERNAME = "seleniumtests10";
    private static final String PASSWORD = "060788avavav";
    private LoginPage loginPage;
    private InboxPage inboxPage;
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://gmail.com");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void loginTest() {
        inboxPage = loginPage.login(USERNAME, PASSWORD);

        Assert.assertTrue(inboxPage.getHeader().isProfileLinkDisplayed(), "Profile link (image) didn't appear!");
    }
}

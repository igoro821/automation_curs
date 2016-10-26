import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by student on 25.10.2016.
 */
//mvn clean compile test -Dgroups=smoke
public class LoginTest {

    private static final String URL = "https://mail.ru";
    private static final String USERNAME = "seleniumtests10";
    private static final String PASSWORD = "060788avavav";
    private WebDriver driver;
    private LoginPage loginPage;
    private InboxPage inboxPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);

        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test(groups = "smoke")
    public void loginTest() {
        inboxPage = loginPage.login(USERNAME, PASSWORD);

        Assert.assertTrue(inboxPage.isLogoutButtonDisplayed(), "Logout button is not displayed!");
    }

    @Test(groups = "smoke")
    public void logoutTest() {
        inboxPage = loginPage.login(USERNAME, PASSWORD);
        loginPage = inboxPage.logout();

        Assert.assertTrue(loginPage.isUsernameInputDisplayed(), "Username input is not displayed!");
    }
}

import org.openqa.selenium.WebDriver;
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

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test(groups = "smoke")
    public void loginTest() {
        LoginPage.login(driver, USERNAME, PASSWORD);

        Assert.assertTrue(InboxPage.isLogoutButtonDisplayed(driver), "Logout button is not displayed!");
    }

    @Test(groups = "smoke")
    public void logoutTest() {
        LoginPage.login(driver, USERNAME, PASSWORD);
        InboxPage.logout(driver);

        Assert.assertTrue(LoginPage.isUsernameInputDisplayed(driver), "Username input is not displayed!");
    }
}

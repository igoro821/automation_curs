import helpers.CommonDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 20.10.2016.
 */
public class MailRuLoginTest {

    private static final String URL = "https://mail.ru";
    private WebDriver driver;

    @BeforeClass
    public void createBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void killBrowser() {
        driver.close();
    }

    @BeforeMethod
    public void setUp() {
        driver.manage().deleteAllCookies();
        driver.get(URL);
    }

    @Test(dataProviderClass = CommonDataProvider.class, dataProvider = "loginDataProvider")
    public void loginDDTTest(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("mailbox__login"));
        WebElement passwordInput = driver.findElement(By.id("mailbox__password"));
        WebElement loginButton = driver.findElement(By.id("mailbox__auth__button"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();



//        LoginPage loginPage = new LoginPage();
//        loginPage.login("dsdssd", "dssdsd")

        WebElement logoutButton = driver.findElement(By.id("PH_logoutLink"));
        Assert.assertTrue(logoutButton.isDisplayed(), "User can't login!");
    }
}

package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.AuthenticationPage;
import page.MainPage;
import page.NewAccountPage;
import webdriver.Driver;

/**
 * Created by tarasenko on 2.11.16.
 */
public class BaseTest {
    protected MainPage mainPage;
    protected AuthenticationPage authenticationPage;
    protected NewAccountPage newAccountPage;
    protected WebDriver driver;
    protected Driver customDriver = new Driver();
    private static final String URL_MAIN_PAGE = "http://automationpractice.com/index.php";

    @BeforeMethod
    public void setup() {
        driver = customDriver.getFfDriver(URL_MAIN_PAGE);
    }

    @AfterMethod
    public void teardown() {
        customDriver.closeDriver(driver);
    }

    protected void registryNewUserForAuthorizationTest() {
        mainPage = new MainPage(driver);
        authenticationPage = mainPage.clickSignInLink();
        authenticationPage.setAccountEmail();
        newAccountPage = authenticationPage.clickSubmitButton();
        newAccountPage.setDate();
        newAccountPage.clickSubmitButton();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import testng.MyListener;
import testng.TestBase;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 03.11.2016.
 */
@Listeners(MyListener.class)
public class LoginTest extends TestBase {

    @Test
    @TestCaseId("A-27")
    @Features("Login")
    @Stories("Story 1")
    @Description("Test verifies login functionality with invalid credentials")
    public void loginInvalidTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru");

        driver.findElement(By.id("mailbox__logi32n")).sendKeys("seleniumtests10");
        driver.findElement(By.id("mailbox__password")).sendKeys("060788avavav");
        driver.findElement(By.id("mailbox__auth__button")).click();

        Assert.assertTrue(driver.findElement(By.id("PH_logoutLink")).isDisplayed());
        driver.close();
    }

    @Test
    @TestCaseId("A-26")
    @Features("Login")
    @Stories("Story 1")
    @Description("Test verifies login functionality with valid credentials")
    public void loginTest() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru");

        driver.findElement(By.id("mailbox__login")).sendKeys("seleniumtests10");
        driver.findElement(By.id("mailbox__password")).sendKeys("060788avavav");
        driver.findElement(By.id("mailbox__auth__button")).click();

        Assert.assertTrue(driver.findElement(By.id("PH_logoutLink")).isDisplayed());
        driver.close();
    }
}

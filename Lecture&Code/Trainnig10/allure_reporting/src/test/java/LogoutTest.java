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
public class LogoutTest extends TestBase {

    @Test
    @TestCaseId("A-83")
    @Features("Logout")
    @Stories("Story 2")
    @Description("Verify the ability to logout from application")
    public void loginTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru");

        driver.findElement(By.id("mailbox__login")).sendKeys("seleniumtests10");
        driver.findElement(By.id("mailbox__password")).sendKeys("060788avavav");
        driver.findElement(By.id("mailbox__auth__button")).click();

        driver.findElement(By.id("PH_logoutLink")).click();

        Assert.assertFalse(driver.findElement(By.id("mailbox__login")).isDisplayed());
        driver.close();
    }
}

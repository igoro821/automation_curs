import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 03.11.2016.
 */
public class LogoutTest {

    @Test
    public void loginTest() {
        WebDriver driver = new FirefoxDriver();
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

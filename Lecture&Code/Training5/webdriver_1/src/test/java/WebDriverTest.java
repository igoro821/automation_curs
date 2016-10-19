import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 18.10.2016.
 */
public class WebDriverTest {

    @Test
    public void loginTest() throws InterruptedException {
        FirefoxProfile profile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Dimension newSize = new Dimension(200, 800);
//        driver.manage().window().setSize(newSize);
        driver.get("https://mail.ru");
//        new WebDriverWait(driver, 15).until(ExpectedConditions.textToBe(By.id("dsds"), "Hello world!"));
        new WebDriverWait(driver, 60, 3000).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return null;
            }
        });
        WebElement usernameInput = driver.findElement(By.id("mailbox__login"));
        usernameInput.sendKeys("seleniumtests10");
        WebElement passwordInput = driver.findElement(By.name("Password"));
        passwordInput.sendKeys("060788avavav");
        WebElement loginButton = driver.findElement(By.className("mailbox__auth__button"));
        loginButton.click();
        WebElement logoutButton = driver.findElement(By.id("PH_logoutLink"));

        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed!");
        driver.close();
    }
}

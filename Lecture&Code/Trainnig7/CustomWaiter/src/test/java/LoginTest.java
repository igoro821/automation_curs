import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 25.10.2016.
 */
public class LoginTest {

    @Test
    public void loginTest() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru");
        new WebDriverWait(driver, 15).until(ExpectedConditions.attributeContains(By.id("mailbox__login"), "value", "seleniumtests10"));
        new WebDriverWait(driver, 15, 2500).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement usernameInput = driver.findElement(By.id("mailbox__login"));
                return usernameInput.getAttribute("value").contentEquals("seleniumtests10");
            }
        });
    }
}

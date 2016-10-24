import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 20.10.2016.
 */
public class JavaScriptTest {

    @Test
    public void t1() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("$('a[title=\"Women\"]+ul').css('display', 'none');");

        driver.close();
    }
}

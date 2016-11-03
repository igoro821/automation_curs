package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;
import page.app.InboxPage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 27.10.2016.
 */
public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser").toLowerCase() : "firefox";
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "ie":
                //setup ie
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://gmail.com");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    protected int getRandomNumber() {
        return new Random(10000).nextInt() + 1000;
    }
}

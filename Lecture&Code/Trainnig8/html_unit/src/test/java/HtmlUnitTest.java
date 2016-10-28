import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 27.10.2016.
 */
public class HtmlUnitTest {

    private static final String EXPECTED_TITLE = "Google";
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new HtmlUnitDriver(true);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.by");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void verifyTitleTest() {
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        java.io.File file = takesScreenshot.getScreenshotAs(OutputType.FILE);

        Assert.assertEquals(searchPage.getTitle(), EXPECTED_TITLE);
    }
}

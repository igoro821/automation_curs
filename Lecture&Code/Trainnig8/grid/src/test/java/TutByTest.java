import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 27.10.2016.
 */
public class TutByTest {

    private static final String EXPECTED_TITLE = "Белорусский портал TUT.BY";
    private WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new URL("http://172.18.5.115:4444/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.tut.by/");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void verifyTitleTest() {
        TutByHomePage tutByPage = new TutByHomePage(driver);

        Assert.assertEquals(tutByPage.getTitle(), EXPECTED_TITLE);
    }
}

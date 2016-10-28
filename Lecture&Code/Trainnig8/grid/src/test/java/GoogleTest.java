import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class GoogleTest {

    private static final String EXPECTED_TITLE = "Google";
    private WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://172.18.5.115:4444/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.by");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void verify1TitleTest() {
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);

        Assert.assertEquals(searchPage.getTitle(), EXPECTED_TITLE);
    }

    @Test
    public void verifyTitle2Test() {
        OnlinerHomePage onlinerPage = new OnlinerHomePage(driver);

        Assert.assertEquals(onlinerPage.getTitle(), EXPECTED_TITLE);
    }

    @Test
    public void verify3TitleTest() {
        TutByHomePage tutByPage = new TutByHomePage(driver);

        Assert.assertEquals(tutByPage.getTitle(), EXPECTED_TITLE);
    }
}

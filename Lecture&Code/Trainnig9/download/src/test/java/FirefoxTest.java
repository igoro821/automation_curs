import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 01.11.2016.
 */
public class FirefoxTest {

    @Test
    public void download1Test() {
        FirefoxProfile f = new FirefoxProfile();
        f.setPreference("browser.download.folderList", 2);
        f.setPreference("browser.download.dir", "d:\\");
        f.setPreference("browser.helperApps.alwaysAsk.force", false);
        f.setPreference("browser.download.manager.showWhenStarting", false);
        f.setPreference("browser.helperApps.neverAsk.saveToDisk", "image/png");

        WebDriver driver = new FirefoxDriver(f);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/download");

        List<WebElement> elements = driver.findElements(By.cssSelector("a[href^='download']"));
        elements.get(0).click();

        driver.close();
    }

    @Test
    public void download2Test() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "e:\\");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/download");

        List<WebElement> elements = driver.findElements(By.cssSelector("a[href^='download']"));
        elements.get(0).click();

        driver.close();
    }

    @Test
    public void download3Test() throws InterruptedException, AWTException {
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/download");

        List<WebElement> elements = driver.findElements(By.cssSelector("a[href^='download']"));
        WebElement elementToDownlaod = elements.get(0);
        Actions actions = new Actions(driver);
        actions.sendKeys(elementToDownlaod).build().perform();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_S);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_S);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        driver.close();
    }
}

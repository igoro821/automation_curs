import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 20.10.2016.
 */
public class JsAlertTest {

    private static final String URL = "http://the-internet.herokuapp.com/javascript_alerts";
    private static final String EXPECTED_ALERT_TEXT = "I am a JS Alert";
    private static final String EXPECTED_ACCEPT_TEXT = "You clickedv: Ok";
    private static final String EXPECTED_DISMISS_TEXT = "You clicked: Cancel";
    private static final String NEW_MESSAGE = "Hello world!";
    private static final String EXPECTED_MESSAGE_TEXT = "You entered: %s";
    private WebDriver driver;

    @BeforeTest
    public void oneTimeSetUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterTest
    public void oneTimeTearDown() {
        driver.close();
    }

    @Test
    public void verifyAlertTextTest() {
        WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        alert.accept();
        Assert.assertEquals(actualAlertText, EXPECTED_ALERT_TEXT);
    }

    @Test
    public void verifyEventOkTextTest() {
        WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement eventTextContainer = driver.findElement(By.id("result"));
        Assert.assertEquals(eventTextContainer.getText(), EXPECTED_ACCEPT_TEXT);
    }

    @Test
    public void verifyEventCancelTextTest() {
        WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement eventTextContainer = driver.findElement(By.id("result"));
        Assert.assertEquals(eventTextContainer.getText(), EXPECTED_DISMISS_TEXT);
    }

    @Test
    public void verifyAlertMessageTextTest() {
        WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello world!");
        alert.accept();

        WebElement eventTextContainer = driver.findElement(By.id("result"));
        Assert.assertEquals(eventTextContainer.getText(), "You entered: Hello world!");
    }
}

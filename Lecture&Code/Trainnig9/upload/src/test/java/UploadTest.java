import com.thoughtworks.selenium.webdriven.commands.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 01.11.2016.
 */
public class UploadTest {

    @Test
    public void uploadTest() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/upload");

        driver.findElement(By.id("file-upload")).sendKeys(new java.io.File("src\\main\\resources\\sample.txt").getAbsolutePath());

        driver.close();
    }

    @Test
    public void upload2Test() throws AWTException, InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/upload");

        driver.findElement(By.id("file-upload")).click();
        Robot robot = new Robot();
        robot.keyPress(java.awt.event.KeyEvent.VK_A);
        robot.keyRelease(java.awt.event.KeyEvent.VK_A);
        robot.keyPress(java.awt.event.KeyEvent.VK_B);
        robot.keyRelease(java.awt.event.KeyEvent.VK_B);
        robot.keyPress(java.awt.event.KeyEvent.VK_C);
        robot.keyRelease(java.awt.event.KeyEvent.VK_C);
        driver.close();
    }
}

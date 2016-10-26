import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by tarasenko on 25.10.16.
 */
public class Test_3 {

    @Test
    public void frameTest() throws InterruptedException {
        File pathToBinary = new File("c:\\Program Files (x86)\\Mozila FF 31esr\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        FirefoxDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);
        driver.get("http://the-internet.herokuapp.com/iframe");
        // Question#1: Why text not bold if button pressed before switching to frame?:
        WebElement boldButton = driver.findElement(By.cssSelector("#mceu_23-body>#mceu_3>button"));
        boldButton.click();
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.cssSelector("#tinymce"));
        textBox.clear();
//        driver.switchTo().defaultContent();
//        WebElement boldButton = driver.findElement(By.cssSelector("#mceu_23-body>#mceu_3>button"));
//        boldButton.click();
//        driver.switchTo().frame("mce_0_ifr");
        textBox.sendKeys("Hello ");
        driver.switchTo().defaultContent();
        boldButton.click();
        driver.switchTo().frame("mce_0_ifr");
        textBox.sendKeys("World!");
        //Why Assert not work?
        Assert.assertEquals(textBox.getText(), "Hello World!");
    }
}

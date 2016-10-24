import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
 * Created by tarasenko on 24.10.16.
 */
public class Test_1 {

    @Test
    public void contextClickText() throws InterruptedException {
        String EXPECTED_TEXT = "Test all!!";
        File pathToBinary = new File("c:\\Program Files (x86)\\Mozila FF 31esr\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        FirefoxDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);

        driver.get("http://the-internet.herokuapp.com/iframe");

        WebElement boldButton = driver.findElement(By.id("mceu_3"));
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        actions.contextClick(iFrame)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER).build().perform();
        actions.sendKeys(Keys.DELETE).build().perform();
        actions.click(boldButton).build().perform();
        actions.click(iFrame).build().perform();
        iFrame.sendKeys("Test");
        actions.click(boldButton).build().perform();
        iFrame.sendKeys(" all!!");
        driver.switchTo().frame(iFrame);
        WebElement actualResult = driver.findElement(By.cssSelector("#tinymce>p"));
        System.out.print(actualResult.toString());
        Assert.assertEquals(actualResult.getText(), EXPECTED_TEXT);
        driver.close();
    }

}

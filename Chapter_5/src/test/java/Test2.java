import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by tarasenko on 24.10.16.
 */
public class Test2 {

    @AfterMethod
    public void precon() {
        File pathToBinary = new File("c:\\Program Files (x86)\\Mozila FF 31esr\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        FirefoxDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @DataProvider(name = "logProvader")
    public Object[][] data4Login() {
        return new Object[][]{
                new Object[]{"tomsmith1", "SuperSecretPassword!", "Your username is invalid!"},
                new Object[]{"tomsmith", "SuperSecretPassword!2", "Your password is invalid!"},
                new Object[]{"tomsmith", "", "Your password is invalid!"},
                new Object[]{"", "SuperSecretPassword!", "Your username is invalid!"},
                new Object[]{"tomsmith", "SuperSecretPassword!", "You logged into a secure area!"},

        };
    }


    @Test(dataProvider = "logProvader")
    public void login(String name, String pass, String message) throws InterruptedException {
        String actualResult;
        File pathToBinary = new File("c:\\Program Files (x86)\\Mozila FF 31esr\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        FirefoxDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.cssSelector(".radius"));
        username.sendKeys(name);
        password.sendKeys(pass);
        login.click();
        WebElement flashMessages = driver.findElement(By.id("flash"));
        actualResult = flashMessages.getText();
        driver.close();
        Assert.assertEquals(actualResult, message);
    }
}

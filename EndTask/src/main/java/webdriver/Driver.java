package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by tarasenko on 31.10.16.
 */
public class Driver {

    private WebDriver driver;


    //return FF Driver
    public WebDriver getFfDriver(String url) {
        File pathToBinary = new File("c:\\Program Files (x86)\\Mozila FF 31esr\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        driver = new FirefoxDriver(ffBinary, firefoxProfile);
        defaultSettings(driver);
        driver.get(url);
        return driver;
    }

    //return Chrome Driver
    public WebDriver getChromeDriver() {
//        File pathToBinary = new File("c:\\Program Files (x86)\\Mozila FF 31esr\\firefox.exe");
//        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
//        FirefoxProfile firefoxProfile = new FirefoxProfile();
//        driver = new FirefoxDriver(ffBinary, firefoxProfile);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private void defaultSettings(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeDriver(WebDriver driver) {
        driver.close();
    }
}

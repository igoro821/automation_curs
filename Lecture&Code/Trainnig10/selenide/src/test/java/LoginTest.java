import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by student on 03.11.2016.
 */
public class LoginTest {

    @Test
    public void loginTest() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru");

        WebDriver driver2 = new FirefoxDriver();
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver2.get("https://tut.by");

        driver.findElement(By.id("mailbox__login")).sendKeys("seleniumtests10");
        driver.findElement(By.id("mailbox__password")).sendKeys("060788avavav");
        driver.findElement(By.id("mailbox__auth__button")).click();

        Assert.assertTrue(driver.findElement(By.id("PH_logoutLink")).isDisplayed());
        driver.close();
        driver2.close();
    }

    @Test
    public void selenideLoginTest() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://mail.ru";
        Configuration.timeout = 10000;

        open("/");
        $(LoginPage.LOGIN_FORM).$(LoginPage.USERNAME_INPUT).click();
        $(LoginPage.USERNAME_INPUT).val("seleniumtests10");
        $(LoginPage.PASSWORD_INPUT).sendKeys("060788avavav");
        $(LoginPage.LOGIN_BUTTON).click();
//        WebDriverRunner.getWebDriver().findElement(LoginPage.LOGIN_BUTTON).click();
        $(Header.LOGOUT_BUTTON).waitUntil(Condition.visible, 30000);
//        Assert.assertTrue(Header.isLogoutButtonDisplayed(), "//message");
//        $(Header.LOGOUT_BUTTON).shouldBe(Conditio);
        $(Header.LOGOUT_BUTTON).shouldNotBe(Condition.visible);
        $(Header.LOGOUT_BUTTON).shouldBe(Condition.visible);
        $(Header.LOGOUT_BUTTON).shouldHave(Condition.text("выхоыд"));

//        $$(By.className("h"))

//        JavascriptExecutor executor = (JavascriptExecutor) WebDriverRunner.getWebDriver();
    }

    @Test
    public void downloadTest() throws FileNotFoundException {
        open("http://the-internet.herokuapp.com/download");
        ElementsCollection filesToDownload = $$(By.cssSelector(".example>a"));
        java.io.File document = filesToDownload.get(0).download();
//        $$(By.cssSelector(".example>a")).get(2);
//        $(By.cssSelector(".example>a"), 2)
        System.out.println();
    }

}

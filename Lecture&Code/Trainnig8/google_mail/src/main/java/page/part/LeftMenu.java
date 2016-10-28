package page.part;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.app.SentMailPage;

import static helper.Locators.get;

/**
 * Created by student on 27.10.2016.
 */
public class LeftMenu {

    private static final By SENT_MAIL_LINK = get("LeftMenu.SentMailLink");
    private WebDriver driver;

    public LeftMenu(WebDriver driver) {
        this.driver = driver;
    }

    public SentMailPage goToSenMail() {
        driver.findElement(SENT_MAIL_LINK).click();

        return new SentMailPage(driver);
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 25.10.2016.
 */
public class InboxPage {

    @FindBy(id = "PH_logoutLink")
    private WebElement logoutButton;

    private WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    public LoginPage logout() {
        logoutButton.click();

        return new LoginPage(driver);
    }
}

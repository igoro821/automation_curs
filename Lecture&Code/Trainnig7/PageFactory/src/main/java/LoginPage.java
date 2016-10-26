import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 25.10.2016.
 */
public class LoginPage {

    @FindBy(id = "mailbox__login")
    private WebElement usernameInput;

    @FindBy(id = "mailbox__password")
    private WebElement passwordInput;

    @FindBy(id = "mailbox__auth__button")
    private WebElement loginButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public InboxPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        return new InboxPage(driver);
    }

    public boolean isUsernameInputDisplayed() {
        return loginButton.isDisplayed();
    }
}

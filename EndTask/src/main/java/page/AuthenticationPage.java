package page;

import helper.RandomData;
import helper.Randomizer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import part.Header;

/**
 * Created by tarasenko on 2.11.16.
 *
 * Page for logging and input-mail address to create a new account
 */
public class AuthenticationPage {

    private WebDriver driver;
    private Header header;
    private NewAccountPage newAccountPage;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    private WebElement emailAdressInput;

    @FindBy(id = "SubmitCreate")
    private WebElement submitButton;

    public void setAccountEmail() {
        emailAdressInput.sendKeys(RandomData.getEmail());
    }

    public NewAccountPage clickSubmitButton() {
        submitButton.click();
        newAccountPage = new NewAccountPage(driver);
        return newAccountPage;
    }


}

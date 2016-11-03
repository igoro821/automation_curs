package page;

import helper.Randomizer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import part.Header;

/**
 * Created by tarasenko on 2.11.16.
 */
public class AuthenticationPage {

    private WebDriver driver;
    private Header header;
    private NewAccountPage newAccountPage;
    private static final String FIRST_PART_EMAIL = "test";
    private static final String LASTPART_EMAIL = "@testers.com";
    private static final String EMAIL_ADRESS = FIRST_PART_EMAIL + Randomizer.getRandomAppendix() + LASTPART_EMAIL;


    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    WebElement emailAdressInput;

    @FindBy(id = "SubmitCreate")
    WebElement submitButton;

    public void setAccountEmail() {
        emailAdressInput.sendKeys(EMAIL_ADRESS);
    }

    public NewAccountPage clickSubmitButton() {
        submitButton.click();
        newAccountPage = new NewAccountPage(driver);
        return newAccountPage;
    }


}

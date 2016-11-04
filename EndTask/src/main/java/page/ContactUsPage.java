package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import part.Header;
import webdriver.WebElementMeneger;

/**
 * Created by tarasenko on 31.10.16.
 */
public class ContactUsPage {

    private WebDriver driver;
    private Header header;
    private static final String EMAIL = "rapid@test.com";
    private static final String ORDER_REFERENCE = "789456";
    private static final String MESSAGE = "Testing!";
    private static final String DROPDAWN_LABEL = "Customer service";
    private static final String PATH_TO_FILE = "src\\main\\resources\\sample.txt";
    private static final String FAIL_MESSAGE = "The message cannot be blank.";


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_contact")
    private WebElement headingDropDawn;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "id_order")
    private WebElement orderReferenceInput;

    @FindBy(id = "fileUpload")
    private WebElement fileUploadInput;

    @FindBy(id = "message")
    private WebElement messageTextArea;

    @FindBy(id = "submitMessage")
    private WebElement submitMessageBatton;

    @FindBy(className = "alert-success")
    private WebElement sucsessMassage;

    @FindBy(className = "alert-danger")
    private WebElement failMassage;

    public void enterDataInAllField() {
        enterDateInFieldExceptMessage();
        messageTextArea.sendKeys(MESSAGE);
    }

    public void enterDateInFieldExceptMessage() {
        selectField(DROPDAWN_LABEL);
        emailInput.sendKeys(EMAIL);
        orderReferenceInput.sendKeys(ORDER_REFERENCE);
        fileUploadInput.sendKeys(getPathForUpload(PATH_TO_FILE));
    }

    public void clickSubmit() {
        submitMessageBatton.click();
    }

    public boolean isDislayedSuccessMessage() {
        return WebElementMeneger.isDisplayed(sucsessMassage);
    }

    public boolean isDislayedFailMessageAndMessageCorrect() {
        if (!WebElementMeneger.isDisplayed(failMassage)) {
            return WebElementMeneger.isDisplayed(failMassage);
        }
        WebElement failMessageTextNode = failMassage.findElement(By.cssSelector("ol>li"));
        String failMessageText = failMessageTextNode.getText();
        return FAIL_MESSAGE.equals(failMessageText);
    }

    private void selectField(String value) {
        Select select = new Select(headingDropDawn);
        select.selectByVisibleText(value);
    }

    private String getPathForUpload(String pathToFile) {
        return new java.io.File(pathToFile).getAbsolutePath();

    }
}

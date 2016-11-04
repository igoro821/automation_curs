package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import part.Header;
import webdriver.WebElementMeneger;

/**
 * Created by tarasenko on 4.11.16.
 */
public class AccountPage {

    private WebDriver driver;
    private Header header;

    private static final String INFO_ACCOUNT_TEXT = "Welcome to your account. Here you can manage all of your personal information and orders.";

    public AccountPage(WebDriver driver, Header header) {
        this.driver = driver;
        this.header = header;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "info-account")
    private WebElement infoAccount;

    @FindBy(css = "a[title=\"Orders\"]")
    private WebElement ordersLink;

    @FindBy(className = "info-title")
    private WebElement infoTitle;


    public boolean isNewAccountPage() {
        return WebElementMeneger.isDisplayed(infoAccount) && INFO_ACCOUNT_TEXT.equals(infoAccount.getText());
    }

    public void clicOnOrderLink() {
        ordersLink.click();
    }

    public boolean isExistBuy() {
        return WebElementMeneger.isDisplayed(infoTitle);
    }
}

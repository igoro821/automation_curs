package part;

import helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ContactUsPage;
import page.AuthenticationPage;
import webdriver.WebElementMeneger;

/**
 * Created by tarasenko on 31.10.16.
 */
public class Header {

    private WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "contact-link")
    WebElement contactUsLink;

    @FindBy (className = "login")
    WebElement sigInLink;

    @FindBy (id = "search_query_top")
    WebElement searchInput;

    @FindBy (name = "submit_search")
    WebElement runSearchButton;

    @FindBy(css ="a[title=\"View my shopping cart\"]")
    WebElement shoppingCartLink;

    @FindBy(className = "cart_block")
    WebElement cartBlock;

    @FindBy(className = "remove_link")
    WebElement removeLink;


    public ContactUsPage clickContactUsLink() {
        contactUsLink.click();
        return new ContactUsPage(driver);
    }

    public AuthenticationPage clickSignInLink() {
        sigInLink.click();
        return new AuthenticationPage(driver);
    }

    public void setSearchingText(String text) {
        searchInput.sendKeys(text);
    }

    public void clickRunSearchButton() {
        runSearchButton.click();
    }


    public boolean isNotEmptyCard() {
        mouseOverOnCard();
        return !WebElementMeneger.isDisplayed(cartBlock);
    }

    public void deleteProductFromCard() {
        mouseOverOnCard();
        removeLink.click();
        WebDriverWait wait = Waiter.getWaiter(driver);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cart_block")));
    }

    public boolean isEmptyCard() {
        mouseOverOnCard();
        return !WebElementMeneger.isDisplayed(cartBlock);
    }

    private void mouseOverOnCard() {
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCartLink).build().perform();
    }
}

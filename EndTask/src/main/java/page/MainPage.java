package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import part.Header;
import webdriver.WebElementMeneger;

/**
 * Created by tarasenko on 31.10.16.
 */
public class MainPage {

    private WebDriver driver;

    private Header header;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "pagination")
    WebElement paginationOfProduct;

    @FindBy(className = "product-container")
    WebElement product;

    @FindBy(className = "ajax_add_to_cart_button")
    WebElement addToCardButton;

    @FindBy(className = "cross")
    WebElement cross;


    public Header getHeader() {
        return header;
    }

    public ContactUsPage clickContactUsLink() {
        return header.clickContactUsLink();
    }

    public AuthenticationPage clickSignInLink() {
        return header.clickSignInLink();
    }

    public boolean isProductExist() {
        return WebElementMeneger.isDisplayed(paginationOfProduct);
    }

    public void searchProduct(String searchCriteria) {
        header.setSearchingText(searchCriteria);
        header.clickRunSearchButton();
    }

    public void addProductToCard() {
        product.click();
        addToCardButton.click();
        cross.click();
    }
}

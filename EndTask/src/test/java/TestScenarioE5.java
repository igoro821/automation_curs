import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.MainPage;
import testng.BaseTest;

/**
 * Created by tarasenko on 2.11.16.
 */
public class TestScenarioE5 extends BaseTest {

    private static final String ERROR_MESSAGE_NOT_ADD_TO_CARD = "Product is not exist in card";
    private static final String ERROR_MESSAGE_NOT_DELETE_FROM_CARD = "Product is not delete from card";
    private static final String SEARCHED_PRODUCT = "Blouse";

    @Test
    public void cardTest() throws Exception {
        mainPage = new MainPage(driver);
        mainPage.searchProduct(SEARCHED_PRODUCT);
        mainPage.addProductToCard();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.getHeader().isNotEmptyCard(), ERROR_MESSAGE_NOT_ADD_TO_CARD);
        mainPage.getHeader().deleteProductFromCard();
        softAssert.assertTrue(mainPage.getHeader().isEmptyCard(), ERROR_MESSAGE_NOT_DELETE_FROM_CARD);
        softAssert.assertAll();
    }
}

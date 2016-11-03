import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;
import part.Header;
import testng.BaseTest;

/**
 * Created by tarasenko on 2.11.16.
 */
public class TestScenarioE4 extends BaseTest {

    private static final String ERROR_MESSAGE = "Product is not exist";
    private static final String SEARCHED_PRODUCT = "Blousesd";

    @Test
    public void searchingTest() {
        mainPage = new MainPage(driver);
        mainPage.searchProduct(SEARCHED_PRODUCT);
        Assert.assertTrue(mainPage.isProductExist(), ERROR_MESSAGE);
    }
}

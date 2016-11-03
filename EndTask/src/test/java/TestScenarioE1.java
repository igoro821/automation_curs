import org.testng.Assert;
import org.testng.annotations.Test;
import page.ContactUsPage;
import page.MainPage;
import testng.BaseTest;

/**
 * Created by tarasenko on 31.10.16.
 */
public class TestScenarioE1 extends BaseTest {

    private MainPage mainPage;
    private ContactUsPage contactUsPage;
    private static final String  ERROR_MESSAGE= "Success Message is not displayed!";

    @Test
    public void positiveSend() {
        mainPage = new MainPage(driver);
        contactUsPage = mainPage.clickContactUsLink();
        contactUsPage.enterDataInAllField();
        contactUsPage.clickSubmit();
        Assert.assertTrue(contactUsPage.isDislayedSuccessMessage(), ERROR_MESSAGE);
    }
}

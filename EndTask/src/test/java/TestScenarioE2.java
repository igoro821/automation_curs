import org.testng.Assert;
import org.testng.annotations.Test;
import page.ContactUsPage;
import page.MainPage;
import testng.BaseTest;

/**
 * Created by tarasenko on 2.11.16.
 */
public class TestScenarioE2 extends BaseTest {

    private MainPage mainPage;
    private ContactUsPage contactUsPage;
    private static final String ERROR_MESSAGE = "Fail Message is not displayed!";

    @Test
    public void negativeSend() {
        mainPage = new MainPage(driver);
        contactUsPage = mainPage.clickContactUsLink();
        contactUsPage.enterDateInFieldExceptMessage();
        contactUsPage.clickSubmit();
        Assert.assertTrue(contactUsPage.isDislayedFailMessageAndMessageCorrect(), ERROR_MESSAGE);
    }
}

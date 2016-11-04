import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.ContactUsPage;
import page.MainPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import testng.MyListener;
import webdriver.BaseTest;

/**
 * Created by tarasenko on 2.11.16.
 */
@Listeners(MyListener.class)
public class TestScenarioE2 extends BaseTest {

    private MainPage mainPage;
    private ContactUsPage contactUsPage;
    private static final String ERROR_MESSAGE = "Fail Message is not displayed!";

    @Test
    @TestCaseId("E2")
    @Features("Sent Data Negative")
    @Stories("Story 2")
    @Description("Verify that we can't sent incorrect data")
    public void negativeSend() {
        mainPage = new MainPage(driver);
        contactUsPage = mainPage.clickContactUsLink();
        contactUsPage.enterDateInFieldExceptMessage();
        contactUsPage.clickSubmit();
        Assert.assertTrue(contactUsPage.isDislayedFailMessageAndMessageCorrect(), ERROR_MESSAGE);
    }
}

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;
import page.app.InboxPage;

/**
 * Created by student on 01.11.2016.
 */
public class InboxTest extends TestBase {

    private LoginPage loginPage;
    private InboxPage inboxPage;

    @BeforeMethod
    public void setup() {
        super.setup();

        loginPage = new LoginPage(driver);
        inboxPage = loginPage.login("seleniumtests10", "060788avavav");
    }
}

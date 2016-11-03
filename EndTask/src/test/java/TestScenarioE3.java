import org.testng.Assert;
import org.testng.annotations.Test;
import testng.BaseTest;

/**
 * Created by tarasenko on 2.11.16.
 */
public class TestScenarioE3 extends BaseTest {

    private static final String ERROR_MESSAGE = "Can't Create account";

    @Test
    public void registrationTest() {
        registryNewUserForAuthorizationTest();
        Assert.assertTrue(newAccountPage.isNewAccountPage(), ERROR_MESSAGE);
    }
}

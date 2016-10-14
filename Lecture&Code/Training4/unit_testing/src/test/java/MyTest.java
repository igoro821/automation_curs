import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by student on 13.10.2016.
 */
public class MyTest {

    private static final String EXPECTED_MESSAGE = "Hello2";

    @Test(timeOut = 100, groups = {"smoke", "bvt"})
    public void divide() {
        double x = 17.9;
        Assert.assertEquals((int) x, 18);
    }

    @Test(groups = "bvt")
    @Parameters(value = "number")
    public void t2(Integer number) {
        Assert.assertEquals(number/5, 3);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divideByZeroTest() {
        int x = 14/2;
    }

    @Test
    public void t3() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Hello", EXPECTED_MESSAGE,
                String.format("Expected message: %s\nActual message: Hello", EXPECTED_MESSAGE));
        softAssert.assertNotEquals(4, 3);
        softAssert.assertAll();
    }

    @Test
    public void t4() {
        Assert.assertTrue(false, "Save button in Create Events popup didn't appear!");
    }
}

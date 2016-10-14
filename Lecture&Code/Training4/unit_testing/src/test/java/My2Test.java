import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 13.10.2016.
 */
public class My2Test {

    @Test
    public void test1() {
        String str = "7.9.8.12";
        String[] numbers = str.split("\\.");
        Assert.assertEquals(14/7, 3);
    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        Assert.assertEquals(8/4, 2);
    }
}

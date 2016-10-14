import helper.CommonDataProvider;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by student on 13.10.2016.
 */
public class My3Test {

    @Test(dataProviderClass = CommonDataProvider.class, dataProvider = "ABC")
    public void plusTest(int x, int y, int sum) {
        Assert.assertEquals(x + y, sum);
    }
}

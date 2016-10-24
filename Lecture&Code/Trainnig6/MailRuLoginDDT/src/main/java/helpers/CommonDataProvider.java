package helpers;

import org.testng.annotations.DataProvider;

/**
 * Created by student on 20.10.2016.
 */
public class CommonDataProvider {

    @DataProvider
    public static Object[][] loginDataProvider() {
        return new Object[][]{
                new Object[]{"seleniumtests10", "060788avavav"},
                new Object[]{"seleniumtests20", "060788avavav"},
                new Object[]{"seleniumtests30", "060788avavav"}
        };
    }
}

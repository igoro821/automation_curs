package helper;

import org.testng.annotations.DataProvider;

/**
 * Created by student on 13.10.2016.
 */
public class CommonDataProvider {

    @DataProvider(name = "ABC")
    private static Object[][] numbersProvider() {
        return new Object[][] {
                new Object[] {7, 9, 16},
                new Object[] {-4, 5, 1},
                new Object[] {12, 14, 136},
                new Object[] {7, -2, -13},
                new Object[] {7, -9, -2}
        };
    }
}

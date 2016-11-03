package helper;

import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 * Created by student on 01.11.2016.
 */
public class CommonDataProvider {

    private static String getRandomNumber() {
        return String.valueOf(new Random(10000).nextInt() + 1000);
    }

    @DataProvider
    public static Object[][] usernameDataProvider() {
        return new Object[][]{
                new Object[]{getRandomNumber()},
                new Object[]{getRandomNumber()},
                new Object[]{getRandomNumber()}
        };
    }
}

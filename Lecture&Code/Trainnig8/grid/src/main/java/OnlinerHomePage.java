import org.openqa.selenium.WebDriver;

/**
 * Created by student on 27.10.2016.
 */
public class OnlinerHomePage {

    private WebDriver driver;

    public OnlinerHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by student on 25.10.2016.
 */
public class MainHeader {

    private static final By EMAIL_LINK = By.id("ph_mail");
    private static final By GAMES_LINK = By.xpath("//i[@id='g_games_events']/..");
    private static final By NEWS_LINK = By.xpath("//a[text()='Новости']");

    private WebDriver driver;

    public MainHeader(WebDriver driver) {
        this.driver = driver;
    }

    public void goToGames() {
        driver.findElement(GAMES_LINK).click();
    }
}

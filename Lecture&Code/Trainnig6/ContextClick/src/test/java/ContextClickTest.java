import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 20.10.2016.
 */
public class ContextClickTest {

    @Test
    public void contextClickText() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);

        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement contextMenuContainer = driver.findElement(By.xpath("//div[@id='hot-spot']"));
//        actions.moveToElement(contextMenuContainer)
//                .contextClick().build().perform();
        actions.contextClick(contextMenuContainer)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER).build().perform();
//        actions.dragAndDrop()
//        actions.clickAndHold().moveToElement().release().build().perform();
        driver.close();
    }
}

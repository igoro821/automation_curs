import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by student on 03.11.2016.
 */
public class Header {

    public static final By LOGOUT_BUTTON = By.id("PH_logoutLink");

    public static boolean isLogoutButtonDisplayed() {
        return $(LOGOUT_BUTTON).is(Condition.visible);
    }
}

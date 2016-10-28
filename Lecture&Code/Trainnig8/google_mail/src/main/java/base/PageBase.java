package base;

import org.openqa.selenium.WebDriver;
import page.part.Header;
import page.part.LeftMenu;

/**
 * Created by student on 27.10.2016.
 */
public abstract class PageBase {

    private final Header HEADER;
    private final LeftMenu LEFT_MENU;
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        HEADER = new Header(driver);
        LEFT_MENU = new LeftMenu(driver);
    }

    public Header getHeader() {
        return HEADER;
    }

    public LeftMenu getLeftMenu() {
        return LEFT_MENU;
    }

    public boolean isProfileLinkDisplayed() {
        return HEADER.isProfileLinkDisplayed();
    }

    public abstract void load();
}

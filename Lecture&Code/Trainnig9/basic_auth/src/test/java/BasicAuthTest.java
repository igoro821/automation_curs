import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.auth.AuthType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 01.11.2016.
 */
public class BasicAuthTest {

    @Test
    public void basicTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

        driver.close();
    }

    @Test
    public void bmpBasicTest() {
        // запуск прокси сервера
        BrowserMobProxy server = new BrowserMobProxyServer();
        server.autoAuthorization("the-internet.herokuapp.com", "admin2", "admin", AuthType.BASIC);
        server.start(4448);

        // получение Selenium proxy
        Proxy proxy = ClientUtil.createSeleniumProxy(server);

        // конфигурация FirefoxDriver для использования прокси
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        WebDriver driver = new FirefoxDriver(capabilities);

        // открытие страницы
        driver.get("http://the-internet.herokuapp.com/basic_auth");

        // здесь основная часть теста

        driver.quit();
        server.stop();
    }
}

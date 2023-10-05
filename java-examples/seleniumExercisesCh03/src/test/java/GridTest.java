import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GridTest {
    private String baseUrl;

    @Test
    public void testGrid() throws Exception {
        baseUrl = "http://cn.bing.com/";
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.3.32:4444"), options);
            //your_node_ip : port
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(10);
        WebElement searchElement = (new WebDriverWait(driver, duration)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver wd) {
                return wd.findElement(By.id("sb_form_q"));
            }
        });

        searchElement.clear();
        searchElement.sendKeys("WebDriver");
        searchElement.sendKeys(Keys.ENTER);

        driver.quit();
    }
}

package world.raketa.config;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.net.MalformedURLException;
import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = null;
        try {
            driver = createDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        //driver.get(config.getBaseUrl());
        return driver;
    }

    public WebDriver createDriver() throws MalformedURLException {
        switch (config.getBrowser()) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case IE: {
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            }
            case YA: {
                if (config.isRemote()) {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                }

                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Program Files (x86)\\Yandex\\YandexBrowser\\Application\\browser.exe");

                return new ChromeDriver(options);
            }

            default: {
                throw new RuntimeException("No such driver");
            }
        }
    }

}

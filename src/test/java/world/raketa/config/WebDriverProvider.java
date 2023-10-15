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
                //options.setBinary("C:\\QA\\yandexdriver.exe");
                options.setBinary("C:\\Users\\Я\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                // WebDriverRunner.setWebDriver(new ChromeDriver(options));
                WebDriver driver = new ChromeDriver(options);
               // WebDriverRunner.setWebDriver(driver);
                driver.get(config.getBaseUrl());
                return driver;
            }

            default: {
                throw new RuntimeException("No such driver");
            }
        }
    }

}

package world.raketa.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class WebConfigForProject {
    private final WebConfig webConfig;

    public WebConfigForProject(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void webConfig() {


       // provider.get();

        if (!webConfig.isRemote()) {
            WebDriverProvider provider=new WebDriverProvider();
            setWebDriver(provider.get());
        }
        Configuration.baseUrl = webConfig.getBaseUrl();
        //Configuration.browser = webConfig.getBrowser().toString();

        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.pageLoadStrategy = "eager";



        if (webConfig.isRemote()) {
            Configuration.browser = webConfig.getBrowser().toString();
            Configuration.browserVersion = webConfig.getBrowserVersion();
            Configuration.remote = webConfig.getRemoteUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }





}



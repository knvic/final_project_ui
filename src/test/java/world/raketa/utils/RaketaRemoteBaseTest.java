package world.raketa.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import world.raketa.helpers.Attach;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class RaketaRemoteBaseTest {


    @BeforeAll
    static void beforeAll() {

        System.setProperty("selenide.browser", "Chrome");
        Configuration.baseUrl = "https://www.raketa.world";
        Configuration.browserSize = "1920x1800";
        Configuration.pageLoadStrategy = "eager";


        //Configuration.remote = "https://user1:1234@"+System.getProperty("selenoidUI", "selenoid.autotests.cloud")+"/wd/hub";
        Configuration.remote = "http://localhost:4444/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }



}

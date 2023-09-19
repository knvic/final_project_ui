package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {


    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        System.setProperty("selenide.browser", "Chrome");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1800";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
       // Configuration.holdBrowserOpen=true;
    }

}

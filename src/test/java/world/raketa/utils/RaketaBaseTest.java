package world.raketa.utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class RaketaBaseTest {


    @BeforeAll
    static void beforeAll() {
       // SelenideLogger.addListener("Allure", new AllureSelenide());
        System.setProperty("selenide.browser", "Chrome");
        Configuration.baseUrl = "https://www.raketa.world";
        Configuration.browserSize = "1920x1800";
        Configuration.pageLoadStrategy = "eager";
       // Configuration.browser = "chrome";
        Configuration.holdBrowserOpen=true;
    }

}

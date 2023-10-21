package world.raketa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.Set;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CareerPage {
    SelenideElement
            topMenu = $(".t199__holder"),
            selectLocale = $(".box_lang"),
            vacancy = $("[href='https://job.raketa.world/page28587673.html']"),
            button = $("[href='#popup:form_ru']"),
            m_navigation = $("[aria-label='Основная навигация']"),
            tabInput = $(".t702__wrapper"),
            fieldName = tabInput.$("[name=Name]"),
            fieldEmail = tabInput.$("[name=Email]"),
            fildPhone = tabInput.$("[name=Phone]"),
            fildInput = tabInput.$("[name=Input]"),
            fieldCheckBox = tabInput.$(".t-checkbox__indicator"),
            buttonSubmit = tabInput.$("[type=submit]"),
            linkToThePageCareer = $("[href='/career']"),
            linkToThePageVacancy = $("[href=\"https://job.raketa.world/page28587673.html\"]"),
            areaOfVacancy = $("#allrecords");

    ElementsCollection
                      loadingAreaPageCareer = $$("[class='t-card__col t-card__col_withoutbtn']"),
            areaQAVacancy = $$(".t396");
    ;

    public CareerPage waitingForThePageCareerLoad() {
        loadingAreaPageCareer.findBy(text("Еще мы совместно участвуем в экологических проектах, занимаемся йогой и совершенствуем английский язык.")).shouldBe(visible, Duration.ofSeconds(10)).scrollTo();
        return this;
    }

    public CareerPage linkVacancyEnabled() {
        linkToThePageVacancy.shouldBe(enabled).scrollTo().click();
        return this;
    }

    public CareerPage selectTargetWindows() {
        Set<String> windowHandles = getWebDriver().getWindowHandles();
        int c = 1;
        String win1 = null;
        String win2 = null;
        for (String windowHandle : windowHandles) {
            //System.out.println("Window handle: " + windowHandle);
            if (c == 1) {
                win1 = windowHandle;
            } else {
                win2 = windowHandle;
            }
            c++;
        }
        switchTo().window(win1).close();
        Selenide.switchTo().window(win2);
        return this;
    }

}
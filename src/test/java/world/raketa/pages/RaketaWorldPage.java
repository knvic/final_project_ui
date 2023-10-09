package world.raketa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RaketaWorldPage {


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
            linkToThePageVacancy = $("[href=\"https://job.raketa.world/page28587673.html\"]");


    ElementsCollection
            navigation = $$("[aria-label='Основная навигация']"),
            pullDownElement = $$(".t199__holder li"),
            loadingAreaMainPage = $$("[data-hook-content=covercontent]"),
            fieldText = $$("div [field=text]"),
            listPullDownMenu = $$(".t-menusub"),
            loadingAreaPageCareer = $$("[class='t-card__col t-card__col_withoutbtn']");


    public RaketaWorldPage openPage() {
        open(baseUrl);
        return this;
    }

    public RaketaWorldPage setLocale(Locale locale) {
        selectLocale.hover().find(byText(locale.getLanguage())).click();
        return this;
    }


    public RaketaWorldPage shouldHaveTargetMenu(List<String> list) {
        for (String item : list
        ) {
            m_navigation.should(text(item));
        }
        return this;
    }


    public RaketaWorldPage checkElementsPullDownMenu(List<String> list, int count, String first) {

        for (String item : list) {

            if (count == 0) {

                pullDownElement.first().hover().shouldHave(text(item)).shouldBe(visible, Duration.ofSeconds(10));
            } else {

                pullDownElement.first().sibling(count - 1).shouldHave(text(first)).hover().shouldHave(text(item)).shouldBe(visible);

            }

        }

        return this;
    }


    public RaketaWorldPage career() {


        pullDownElement.first().hover();
        listPullDownMenu.first().hover().shouldHave(text("Карьера")).shouldBe(visible, Duration.ofSeconds(10));

        linkToThePageCareer.click();
        return this;
    }


    public RaketaWorldPage waitingForThePageCareerLoad() {

        loadingAreaPageCareer.findBy(text("Еще мы совместно участвуем в экологических проектах, занимаемся йогой и совершенствуем английский язык.")).shouldBe(visible, Duration.ofSeconds(10)).scrollTo();

        return this;
    }


    public RaketaWorldPage vacancyQA() {


        linkToThePageVacancy.shouldBe(enabled).click();
        return this;
    }



    public RaketaWorldPage vacancyQA1() {


        Set<String> windowHandles = getWebDriver().getWindowHandles();


        int c = 1;
        String win1 = null;
        String win2 = null;
        for (String windowHandle : windowHandles) {
            System.out.println("Window handle: " + windowHandle);
            if (c == 1) {
                win1 = windowHandle;
            } else {
                win2 = windowHandle;
            }
            c++;

        }

        System.out.println("Window 1 handle: " + win1);
        System.out.println("Window 2 handle: " + win2);
        switchTo().window(win1).close();
        Selenide.switchTo().window(win2);


        String win0 = WebDriverRunner.getWebDriver().getWindowHandle();
        System.out.println("Current win = : " + win0);
        if (!WebDriverRunner.getWebDriver().getWindowHandle().equals(win2)) {
            Selenide.switchTo().window(win2);
            $("#rec523406310").shouldHave(text("QA automation engineerff"));
            $("#rec523406310").click();
        } else {
            $("#rec523406310").shouldHave(text("QA automation engineerff"));
            $("#rec523406310").click();
        }
       /* $$("[data-elem-id=1656051720688]");

        href="https://job.raketa.world/qaautomation"

        t396
 $$("[class='t841__container t-card__container t-container']");
class="t841__container t-card__container t-container"
        $$(".t396");

        t396__filter
        $(".t396__carrier");
        $(".t396__filter");
         $(".t-card__col t-card__col_withoutbtn");
        t-card__col t-card__col_withoutbtn

        href="https://job.raketa.world/qaautomation
        href="http://project5743155.tilda.ws/page28588644.html


        $$("[data-elem-id="1669468041002"]");

        class="t396__elem tn-elem tn-elem__5234063101656055706376"

        $$("[class='t396__elem tn-elem tn-elem__5234063101656055706376']");*/


        return this;
    }

    public RaketaWorldPage yoga() {

        $$(".t396").findBy(text(" йога в обед")).scrollTo();


        return this;
    }


    public RaketaWorldPage waitingForTheSiteToLoad() {
        loadingAreaMainPage.first().shouldHave(text("Экономьте на командировках, улучшайте контроль по поездкам, " +
                "ускоряйте отчетность. Пришло время рассмотреть цифровую " +
                "платформу Ракета"), Duration.ofSeconds(10));

        return this;
    }

    public RaketaWorldPage goToTheMenuItemCompany() {
        topMenu.find(byText("Компания")).click();

        return this;
    }

    public RaketaWorldPage waitingForTheSiteCompanyToLoad() {

        fieldText.first().shouldHave(text("Компания Ракета – российский разработчик"));

        return this;
    }

    public RaketaWorldPage callingInpitTab() {

        button.scrollTo().click();

        return this;
    }


    public RaketaWorldPage checkVisibleInpitTab() {

        tabInput.shouldBe(visible, Duration.ofSeconds(10));

        return this;
    }

    public RaketaWorldPage fillingTheForm(String name, String email, String phone, String input) {

        fieldName.setValue(name);
        fieldEmail.setValue(email);
        fildPhone.setValue(phone);
        fildInput.setValue(input);
        fieldCheckBox.scrollTo().click();
        buttonSubmit.click();

        return this;
    }


}

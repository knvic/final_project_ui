package world.raketa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

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
            buttonSubmit = tabInput.$("[type=submit]");




    ElementsCollection
            navigation = $$("[aria-label='Основная навигация']"),
            pullDown = $$(".t199__holder li"),
            pageElements = $$("[data-hook-content=covercontent]"),
            fieldText = $$("div [field=text]");


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
            m_navigation .should(text(item));
        }
        return this;
    }


    public RaketaWorldPage checkElementsPullDownMenu(List<String> list, int count, String first) {

        for (String item : list) {

            if (count == 0) {

                pullDown.first().hover().shouldHave(text(item)).shouldBe(visible, Duration.ofSeconds(10));
            } else {

                pullDown.first().sibling(count - 1).shouldHave(text(first)).hover().shouldHave(text(item)).shouldBe(visible);

            }

        }

        return this;
    }


    public RaketaWorldPage career() {

        $$("[data-hook-content=covercontent]").first().shouldHave(text("Экономьте на командировках, улучшайте контроль по поездкам, ускоряйте отчетность. Пришло время рассмотреть цифровую платформу Ракета"), Duration.ofSeconds(10));
        pullDown.first().hover();
        $$(".t-menusub").first().hover().shouldHave(text("Карьера")).shouldBe(visible, Duration.ofSeconds(10));

        $("[href='/career']").click();
        return this;
    }

    public RaketaWorldPage vacancyQA() {

        $$(".t017").findBy(text("здесь")).scrollTo();
        $("[href=\"https://job.raketa.world/page28587673.html\"]").shouldBe(enabled).click();

        //$(".t396__filter").shouldBe(text("QA automation engineer")).scrollTo();
      //  $("[href='https://project5743155.tilda.ws/page28588644.html']").shouldBe(enabled, Duration.ofSeconds(10)).click();
        $$("[class='t396__elem tn-elem tn-elem__5234063101656055706376']").first().click();


        return this;
    }

    public RaketaWorldPage yoga() {

        $$(".t396").findBy(text(" йога в обед")).scrollTo();


        return this;
    }


    public RaketaWorldPage waitingForTheSiteToLoad() {
        pageElements.first().shouldHave(text("Экономьте на командировках, улучшайте контроль по поездкам, " +
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

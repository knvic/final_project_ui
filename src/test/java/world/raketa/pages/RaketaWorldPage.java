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
            company = $(".t199__holder"),
            selectLocale = $(".box_lang"),
            vacancy = $("[href='https://job.raketa.world/page28587673.html']");

    //navigation = $("[aria-label='Основная навигация']");
    ;
    ElementsCollection
            navigation = $$("[aria-label='Основная навигация']"),
            pullDown = $$(".t199__holder li");



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
            $("[aria-label='Основная навигация']").should(text(item));
        }
        return this;
    }


    public RaketaWorldPage checkElementsPullDownMenu(List<String> list, int count, String first) {


        for (String item : list) {
           // System.out.println("itemmenu= " + item + "  count= " + count);
            // $$(".t199__holder li").first().hover().shouldHave(text(item)).shouldBe(visible);

            if (count == 0) {

                $$(".t199__holder li").first().hover().shouldHave(text(item)).shouldBe(visible,Duration.ofSeconds(10));

            } else {

                $$(".t199__holder li").first().sibling(count - 1).shouldHave(text(first)).hover().shouldHave(text(item)).shouldBe(visible);

            }

        }

        return this;
    }


    public RaketaWorldPage career() {
       // pullDown.first().hover().findBy(text("123")).click();
        $$("[data-hook-content=covercontent]").first().shouldHave(text("Экономьте на командировках, улучшайте контроль по поездкам, ускоряйте отчетность. Пришло время рассмотреть цифровую платформу Ракета"), Duration.ofSeconds(10));
        $$(".t199__holder li").first().hover();
        $$(".t-menusub").first().hover().shouldHave(text("Карьера")).shouldBe(visible, Duration.ofSeconds(10));

       $("[href='/career']").click();
        return this;
    }

    public RaketaWorldPage vacancyQA() {

        $$(".t017").findBy(text("здесь")).scrollTo();
        $("[href=\"https://job.raketa.world/page28587673.html\"]").shouldBe(enabled);

        return this;
    }

    public RaketaWorldPage yoga() {

        $$(".t396").findBy(text(" йога в обед")).scrollTo();


        return this;
    }

}

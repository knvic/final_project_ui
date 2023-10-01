package world.raketa.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import world.raketa.pages.Locale;
import world.raketa.pages.RaketaWorldPage;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RaketaWorldTests extends RaketaBaseTest {
    RaketaWorldPage raketaWorldPage = new RaketaWorldPage();
    private static int count = 0;

    @Disabled
    @Tag("raketa")
    @Test
    void aboutCompany() {

        step("Открытие сайта", () -> {
            raketaWorldPage
                    .openPage();
        });
        $$(".t199__holder li").first().hover();
        $$(".t199__holder li").first().sibling(0).hover();
        // $$(".t199__holder li").first().shouldHave(text("КОМПАНИЯ"));
        //  $$(".t199__holder li").first().sibling(0).shouldHave(text("ПРОДУКТЫ"));

        //$$(".t199__holder li").first().hover().shouldHave(text("О компании")).shouldBe(visible);


        //$("[role=list]").$$("li").first().hover();
        //$$(".t-menusub__content li").first().click();
        // $("[aria-label='Основная навигация']").shouldHave(text("КОМПАНИЯ"));
        // $("[aria-label='Основная навигация']").shouldHave(text("ПРОДУКТЫ"));
        // $$("div").findBy(text(" Мы создаем короткие, но интересные новости.")).shouldBe(visible, Duration.ofSeconds(5));


    }

    static Stream<Arguments> parameterize1() {
        return Stream.of(
                Arguments.of(Locale.RU, List.of("КОМПАНИЯ", "ПРОДУКТЫ", "КЛИЕНТАМ", "СТАТЬ КЛИЕНТОМ", "КОНТАКТЫ", "ВОЙТИ")),
                Arguments.of(Locale.EN, List.of("COMPANY", "PRODUCTS", "FOR CLIENTS", "GET STARTED", "CONTACTS", "LOGIN"))
        );
    }

    @DisplayName("Параметризованный тест с использованием Stream<Arguments> и ENUM")
    @MethodSource("parameterize1")
    @Tag("raketa")
    @ParameterizedTest(name = "Проверка меню сайта при перелючении локали на {0} отображается меню {1}")
    void parameterize1(Locale locale, List<String> list) {
        step("Открытие сайта", () -> {
            raketaWorldPage
                    .openPage();
        });


        raketaWorldPage
                .setLocale(locale)
                .shouldHaveTargetMenu(list);
        Selenide.closeWindow();

    }

    static Stream<Arguments> parameterize2() {
        return Stream.of(
                Arguments.of("КОМПАНИЯ", List.of("О компании", "Команда", "Медиацентр", "Карьера", "Контакты")),
                Arguments.of("ПРОДУКТЫ", List.of("Цифровая платформа для командировок", "Мобильное приложение для бизнес-путешественников", "Управление персональными и корпоративными данными", "Управление расходами", "Автопарк")),
                Arguments.of("КЛИЕНТАМ", List.of("Бизнесу", "Государственным компаниям", "Интеграции", "Безопасность", "Получить межгалактический паспорт"))

        );
    }

    @DisplayName("Параметризованный тест с использованием Stream<Arguments> и ENUM")
    @MethodSource("parameterize2")
    @Tag("raketa")
    @ParameterizedTest(name = "Проверка меню сайта при перелючении локали на {0} отображается меню {1}")
    void parameterize2(String item, List<String> list) {
        step("Открытие сайта", () -> {
            raketaWorldPage
                    .openPage();
        });

        raketaWorldPage
                .checkElementsPullDownMenu(list, count, item);

        count++;

        Selenide.closeWindow();
        // Selenide.refresh();
    }

    @Tag("raketa")
    @Test
    void yoga() {
        step("Открытие сайта", () -> {
            raketaWorldPage
                    .openPage();
        });

        step("Переход на страницу Карьера", () -> {
            raketaWorldPage
                    .career();
        });
        step("Переход в вакансии", () -> {
            raketaWorldPage
                    .vacancyQA();
        });

        Selenide.closeWindow();
        // Selenide.refresh();
    }

    @Tag("raketa")
    @Test
    void yoga1() {
        step("Открытие сайта", () -> {
            open("https://job.raketa.world/qaautomation");
        });

        step("Переход на страницу Карьера", () -> {
            raketaWorldPage
                    .yoga();
        });
        Selenide.refresh();
    }

}

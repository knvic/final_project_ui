package guru.qa.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends BaseTest{


    @Feature("Запуск в Jenkins")
    @Story("Заполнение тестовой формы")
    @Owner("krivorotovnv")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @DisplayName("Запуск проекта заполнения формы с использованием Jenkins")
    @Test
    @Tag("local")
    void txtForm() {
        open("/automation-practice-form");

        $("#firstName").setValue("firstName");
        $("#lastName").setValue("lastName");
        $("#userEmail").setValue("aaa@bbb.cc");
        $("#userNumber").setValue("1234567890");
        $("#gender-radio-1").parent().click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOptionByValue("2022");
        $(".react-datepicker__day--027:not(react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/picture.png");
        $("#currentAddress").setValue("Russia");
        executeJavaScript("$('footer').remove()");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();
        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("firstName"), text("lastName"), text("aaa@bbb.cc"), text("1234567890"),
                text("Male"), text("27 June,2022"), text("Chemistry"), text("Reading"), text("picture.png"), text("Russia"), text("Uttar Pradesh Agra"));
    }
}

package world.raketa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    SelenideElement
            checkInputData = $(".table-responsive");

    public ResultTableComponent checkResult(String value) {
        checkInputData.shouldHave(text(value));
        return this;
    }
}

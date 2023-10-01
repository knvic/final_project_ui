package world.raketa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {


    SelenideElement
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            address = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submit = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");




    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userName.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setAddress(String value) {
        address.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage submit() {
        submit.click();
        return this;
    }

    public TextBoxPage outputName(String value) {
        outputName.shouldHave(text(value));
        return this;
    }

    public TextBoxPage outputEmail(String value) {
        outputEmail.shouldHave(text(value));
        return this;
    }

    public TextBoxPage outputCurrentAddress(String value) {
        outputCurrentAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxPage outputPermanentAddress(String value) {
        outputPermanentAddress.shouldHave(text(value));
        return this;
    }


}


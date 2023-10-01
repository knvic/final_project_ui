package world.raketa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import world.raketa.pages.components.CalendarComponent;
import world.raketa.pages.components.ResultTableComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    CalendarComponent calendar = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            gender = $("#genterWrapper"),
            birthDate = $("#dateOfBirthInput"),
            subjects = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            uploadPic = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            clickState = $("#state"),
            stateCity = $("#stateCity-wrapper"),
            clickCity = $("#city"),
            submit = $("#submit"),
            modalDialog = $(".modal-dialog"),
            checkTitle = $("#example-modal-sizes-title-lg");


    public PracticeFormPage openPage(String pageName) {
        open("/"+pageName);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public PracticeFormPage setBirth(String year, String month, String day) {
        birthDate.click();
        calendar.setDate(year, month, day);
        return this;
    }

    public PracticeFormPage setSubjects(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String filename) {
        uploadPic.uploadFromClasspath(filename);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public PracticeFormPage deleteBannerAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        clickState.click();
        stateCity.$(byText(state)).click();
        clickCity.click();
        stateCity.$(byText(city)).click();
        return this;
    }

    public PracticeFormPage submit() {
        submit.click();
        return this;
    }

    public PracticeFormPage checkModalDialogeTitle(String value) {
        modalDialog.should(Condition.appear);
        checkTitle.shouldHave(text(value));
        return this;
    }


    public PracticeFormPage checkResult(List<String> list) {
        for (String item : list) {
            resultTableComponent.checkResult(item);
        }

        return this;
    }

}

package world.raketa.tests;

import world.raketa.pages.PracticeFormPage;
import world.raketa.utils.DataGenerationUtils;

import static io.qameta.allure.Allure.step;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PracticeFormWithPageObjectDataGenerationTests extends RemoteBaseTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    DataGenerationUtils dataGenerationUtils = new DataGenerationUtils();

    @Test
    @Feature("Запуск в Jenkins")
    @Story("Заполнение тестовой формы вариант с Faker")
    @Owner("krivorotovnv")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @DisplayName("Запуск проекта заполнения формы с использованием Jenkins")
    @Tag("remote")
    void fullTestPracticeForm() {

        String
                picturePathForUpload = "img/picture.png",
                pictureNameForCheck = "picture.png",
                firstName = dataGenerationUtils.getFirstName(),
                lastName = dataGenerationUtils.getLastName(),
                userEmail = dataGenerationUtils.getUserEmail(),
                userNumber = dataGenerationUtils.getUserNumber(),
                gender = dataGenerationUtils.getUserGender(),
                birthDay = dataGenerationUtils.getUserBirthDay(),
                birthYear = dataGenerationUtils.getUserBirthYear(),
                birthDayMonth = dataGenerationUtils.getUserBirthMonth(),
                subject = dataGenerationUtils.getUserSubject(),
                hobby = dataGenerationUtils.getUserHobby(),
                currentAddress = dataGenerationUtils.getUserAddress(),
                state = dataGenerationUtils.getUserState(),
                city = dataGenerationUtils.getUserCity(state);

        step("Открытие формы, удаление банера и футера", () -> {
            practiceFormPage
                    .openPage(System.getProperty("pagename"))
                    .deleteBannerAndFooter();
        });

        step("Заполнение формы", () -> {
            practiceFormPage
                    .setFirstName(firstName)
                    //.setFirstName("firstName")
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setUserNumber(userNumber)
                    .setGender(gender)
                    .setBirth(birthYear, birthDayMonth, birthDay)
                    .setSubjects(subject)
                    .setHobbies(hobby)
                    .uploadPicture(picturePathForUpload)
                    .setCurrentAddress(currentAddress)
                    .setStateAndCity(state, city);
        });
        step("Отправка формы", () -> {
            practiceFormPage
                    .submit();
        });
        step("Проверка", () -> {
            practiceFormPage
                    .checkModalDialogeTitle("Thanks for submitting the form")
                    .checkResult(List.of(firstName, lastName,
                            userEmail, userNumber, gender,
                            birthDay + " " + birthDayMonth + "," + birthYear, subject, hobby,
                            pictureNameForCheck, currentAddress,
                            state + " " + city));
            ;
        });

    }

}

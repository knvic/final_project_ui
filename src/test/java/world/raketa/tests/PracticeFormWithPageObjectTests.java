package world.raketa.tests;

import world.raketa.pages.PracticeFormPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import java.util.List;



public class PracticeFormWithPageObjectTests extends RemoteBaseTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Feature("Запуск в Jenkins")
    @Story("Заполнение тестовой формы без генерации данных")
    @Owner("krivorotovnv")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @DisplayName("Запуск проекта заполнения формы с использованием Jenkins")
    @Tag("smoke")
    @Test
    void fullTestPracticeForm() {
        step("Open", () -> {
            practiceFormPage
                    .openPage(System.getProperty("pagename"))
                    .deleteBannerAndFooter();
        });

        step("Input Data", () -> {
            practiceFormPage
                    .setFirstName("firstName")
                    .setLastName("lastName")
                    .setUserEmail("aaa@bbb.cc")
                    .setUserNumber("1234567890")
                    .setGender("Female")
                    .setBirth("2022", "July", "27")
                    .setSubjects("Chemistry")
                    .setHobbies("Reading")
                    .uploadPicture("img/picture.png")
                    .setCurrentAddress("Russia")
                    .setStateAndCity("Uttar Pradesh", "Agra")
                    .submit()
                    .checkModalDialogeTitle("Thanks for submitting the form");
        });

        step("Check input", () -> {
            practiceFormPage
                    .checkResult(List.of("firstName", "lastName",
                            "aaa@bbb.cc", "1234567890", "Female",
                            "27 July,2022", "Chemistry", "Reading",
                            "picture.png", "Russia",
                            "Uttar Pradesh Agra"));
        });

    }
}

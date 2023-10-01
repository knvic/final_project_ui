package world.raketa.tests;


import world.raketa.pages.TextBoxPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TextBoxWithPageObjectTests extends BaseTest{


    TextBoxPage textBoxTestsPage =new TextBoxPage();

    @Disabled
    @Test
    void extBoxTestsWithPageObject() {

      /* Ввода данных*/
        textBoxTestsPage
                .openPage()
                .setUserName("Alex Egorov")
                .setUserEmail("alex@egorov.com")
                .setAddress("Some address 1")
                .setPermanentAddress("Another address 1")
                .submit();

        /* Проверка результата*/
        textBoxTestsPage
                .outputName("Alex Egorov")
                .outputEmail("alex@egorov.com")
                .outputCurrentAddress("Some address 1")
                .outputPermanentAddress("Another address 1");
    }


}

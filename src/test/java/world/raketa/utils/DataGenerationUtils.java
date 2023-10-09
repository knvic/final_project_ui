package world.raketa.utils;





//import net.datafaker.Faker;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DataGenerationUtils {
    Faker faker = new Faker(Locale.ENGLISH);

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }


    public String getUserNumber() {
        return faker.numerify("##########");
    }



}
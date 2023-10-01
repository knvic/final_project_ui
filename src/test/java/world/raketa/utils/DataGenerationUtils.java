package world.raketa.utils;



import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;


public class DataGenerationUtils {
    Faker faker = new Faker(Locale.ENGLISH);
    Date userBirthday = faker.date().birthday(18, 65);

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public String getUserGender() {
        String[] gender = {"Male", "Female", "Other"};
        return new Faker().options().option(gender);
    }

    public String getUserNumber() {
        return faker.numerify("##########");
    }

    public String getUserBirthDay() {
        return (new SimpleDateFormat("dd", Locale.ENGLISH)).format(userBirthday);
    }

    public String getUserBirthMonth() {
        return (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(userBirthday);
    }

    public String getUserBirthYear() {
        return (new SimpleDateFormat("y", Locale.ENGLISH)).format(userBirthday);
    }

    public String getUserSubject() {
        String[] subject = {"English", "Chemistry", "Computer Science", "Commerce", "Economics", "Social Studies",
                "Arts", "History", "Maths", "Accounting", "Physics", "Biology", "Hindi", "Civics"};
        return new Faker().options().option(subject);
    }

    public String getUserHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return new Faker().options().option(hobby);
    }

    public String getUserAddress() {
        return faker.address().fullAddress();
    }

    public String getUserState() {
        String[] userState = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return new Faker().options().option(userState);
    }

    public String getUserCity(String state) {
        if (state.equals("NCR")) {
            String[] ncrCity = {"Delhi", "Gurgaon", "Noida"};
            return new Faker().options().option(ncrCity);
        }
        if (state.equals("Uttar Pradesh")) {
            String[] uttarPradeshCity = {"Agra", "Lucknow", "Merrut"};
            return new Faker().options().option(uttarPradeshCity);
        }
        if (state.equals("Haryana")) {
            String[] haryanaCity = {"Karnal", "Panipat"};
            return new Faker().options().option(haryanaCity);
        }
        if (state.equals("Rajasthan")) {
            String[] rajasthanCity = {"Jaipur", "Jaiselmer"};
            return new Faker().options().option(rajasthanCity);
        }

        return null;
    }


}
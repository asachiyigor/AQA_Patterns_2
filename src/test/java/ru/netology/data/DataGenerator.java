package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Locale;

public class DataGenerator {

    private DataGenerator() {
    }

    @Value
    @AllArgsConstructor
    public static class UserInfo {
        private String login;
        private String password;
        private String status;
    }

    private static final Faker faker = new Faker(new Locale("en"));

    public static UserInfo getUserInfo(String status) {
        return new UserInfo(faker.name().username(),
                faker.internet().password(),
                status);
    }

    public static String getInvalidLogin() {
        return faker.name().username();
    }

    public static String getValidLogin() {
        return "vasya";
    }

    public static String getInvalidPassword() {
        return faker.internet().password();
    }

    public static String getValidPassword() {
        return "password";
    }
}

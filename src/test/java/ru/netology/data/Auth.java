package ru.netology.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Auth {
    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static void request(DataGenerator.UserInfo data) {
        // сам запрос
        given() // "дано"
                .spec(requestSpec) // указываем, какую спецификацию используем
                .body(new DataGenerator.UserInfo("vasya", "password", "active"))
                .when() // "когда"
                .post("/api/system/users") // на какой путь, относительно BaseUri отправляем запрос
                .then() // "тогда ожидаем"
                .statusCode(200); // код 200 OK
    }
}
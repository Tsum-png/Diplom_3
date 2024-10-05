package Api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;


public class ApiStep {

    @Step("Создание пользователя")
    public ValidatableResponse createUser(CreateUser user) {
        ValidatableResponse response = given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/api/auth/register")
                .then()
                .statusCode(200);
        return response;
    }

    @Step("Логин пользователя")
    public ValidatableResponse loginUser(LogIn login) {
        ValidatableResponse response = given()
                .contentType("application/json")
                .body(login)
                .when()
                .post("/api/auth/login")
                .then()
                .statusCode(200);
        return response;
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        ValidatableResponse response = given()
                .contentType("application/json")
                .header("Authorization", accessToken)
                .header("Accept", "*/*")
                .when()
                .delete("/api/auth/user")
                .then()
                .statusCode(202);
        return response;
    }
}

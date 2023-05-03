package user;

import io.qameta.allure.Step;
import org.apache.http.HttpStatus;
import static io.restassured.RestAssured.given;

public class UserClient {
    String baseURL ="https://stellarburgers.nomoreparties.site";
    String token;
    @Step("Send POST request to /api/auth/register and check statusCode")
    public void createUserAndCheckStatusCode(User user) {

        given()
                .baseUri(baseURL)
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post("api/auth/register")
                .then()
                .statusCode(HttpStatus.SC_OK);}
    public void userLoginAndCheckStatusCode (User user) {

                 token=given()
                .baseUri(baseURL)
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post("api/auth/login")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and().extract().body().path("accessToken");}
    public void deleteUser(User user){
        // авторизация пользователя
        userLoginAndCheckStatusCode (Credentials.userWithoutName);
        // удаление пользователя
        given()
                .baseUri(baseURL)
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .body(user)
                .when()
                .delete("api/auth/user")
                .then()
                .statusCode(HttpStatus.SC_ACCEPTED);
    }
}
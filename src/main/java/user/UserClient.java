package user;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserClient {
    String baseURL ="https://stellarburgers.nomoreparties.site";

    @Step("Send POST request to /api/auth/register and check statusCode")
    public Response createUserAPI(User user) {
          return given()
                .baseUri(baseURL)
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post("api/auth/register");}
    public Response loginUserAPI(User user){
            return given()
                .baseUri(baseURL)
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post("api/auth/login");
            }

    public void deleteUserAPI(String token){
          given()
                .baseUri(baseURL)
                .contentType("application/json")
                .header("Authorization", token)
                .body(Credentials.user)
                .delete("api/auth/user");}

}
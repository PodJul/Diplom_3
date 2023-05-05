import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;
import pages.HomePageStellarBurgers;
import pages.LogInPageStellarBurgers;
import pages.RegistrationPageStellarBurgers;
import user.Credentials;
import user.UserClient;
import static org.junit.Assert.*;
public class RegistrationTest extends BaseTest {
    UserClient userClient=new UserClient();
    HomePageStellarBurgers objHomePage;
    LogInPageStellarBurgers objLogInPage;
    RegistrationPageStellarBurgers objRegistrationPage;
    String token;
    @Test
    @DisplayName("Create new user")
    public void createNewUser() {
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        objRegistrationPage = new RegistrationPageStellarBurgers(driver);
        objHomePage.clickPersonalCabinetButton();
        objLogInPage.clickRegistrationLink();
        objRegistrationPage.waitForLoadRegPage();
        objRegistrationPage.setRegistrationData(Credentials.fakeName, Credentials.fakeEmail, Credentials.fakePassword);

        objLogInPage.setLogInData(Credentials.fakeEmail, Credentials.fakePassword);
        boolean response=objHomePage.isSetOrderButtonVisible();
        assertTrue(response);}
    @After
    public void deleteUser(){
        Response response=userClient.loginUserAPI(Credentials.userWithoutName);
        token = response.then().extract().path("accessToken");
        userClient.deleteUserAPI(token);}
    }

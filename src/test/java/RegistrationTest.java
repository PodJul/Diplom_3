import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
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
        clickPersonalCabinetButtonOnHomePage();
        clickRegistrationLink();
        setRegData();
        checkUserHasBeenCreated();
        deleteUser();
    }
    @Step("Click LogIn button on home page")
    public void clickPersonalCabinetButtonOnHomePage() {
        objHomePage.clickPersonalCabinetButton();
    }
    @Step("Click registration link")
    public void clickRegistrationLink() {
        objLogInPage.waitForLoadLogInPage();
        objLogInPage.clickRegisterLink();}
    @Step("Set registration data")
    public void setRegData() {
        objRegistrationPage.waitForLoadRegPage();
        objRegistrationPage.setRegistrationData(Credentials.fakeName, Credentials.fakeEmail, Credentials.fakePassword);}
    @Step("Check user has been created")
    public void checkUserHasBeenCreated() {
        objLogInPage.waitForLoadLogInPage();
        objLogInPage.setLogInData(Credentials.fakeEmail, Credentials.fakePassword);
        objHomePage.waitForLoadHomePage();
        assertTrue(objHomePage.isSetOrderButtonVisible());}
    @Step("Delete user")
    public void deleteUser(){
        Response response=userClient.loginUserAPI(Credentials.userWithoutName);
        token = response.then().extract().path("accessToken");
        userClient.deleteUserAPI(token);}
    }

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePageStellarBurgers;
import pages.LogInPageStellarBurgers;
import pages.RecoverPasswordPageStellarBurgers;
import pages.RegistrationPageStellarBurgers;
import user.Credentials;
import user.UserClient;
import static org.junit.Assert.assertTrue;

public class UserAuthorizationTest extends BaseTest {

    UserClient userClient=new UserClient();
    HomePageStellarBurgers objHomePage;
    LogInPageStellarBurgers objLogInPage;
    RegistrationPageStellarBurgers objRegistrationPage;
    RecoverPasswordPageStellarBurgers objRecoverPasswordPage;
    String token;
    @Before
    public void createUser() {
        Response response = userClient.createUserAPI(Credentials.user);
        token = response.then().extract().path("accessToken");
        objHomePage=new HomePageStellarBurgers(driver);
        objLogInPage=new LogInPageStellarBurgers(driver);
        objRegistrationPage=new RegistrationPageStellarBurgers(driver);
        objRecoverPasswordPage=new RecoverPasswordPageStellarBurgers(driver);}

    @Test
    @DisplayName("User authorization by logInButton")
    public void userAuthByLogInButton() {
        clickLogInButtonOnHomePage();
        setUserData();
        checkUserHasBeenAuthorized();
        deleteUser();
        }

    @Step("Click LogIn button on home page")
    public void clickLogInButtonOnHomePage() {
        objHomePage.clickLogInButton();
    }
    @Step("Set user data")
    public void setUserData() {
        objLogInPage.waitForLoadLogInPage();
        objLogInPage.setLogInData(Credentials.fakeEmail, Credentials.fakePassword);
        ;}
    @Step("Check user has been authorized")
    public void checkUserHasBeenAuthorized() {
        objHomePage.waitForLoadHomePage();
        assertTrue(objHomePage.isSetOrderButtonVisible());}
        @Step("Delete user")
        public void deleteUser(){
            userClient.loginUserAPI(Credentials.userWithoutName);
            userClient.deleteUserAPI(token);}

    @Test
    @DisplayName("User authorization by personalCabinetButton")
    public void userAuthByPersonalCabinetButton() {
        clickPersonalCabinetButtonOnHomePage();
        setUserData();
        checkUserHasBeenAuthorized();
        deleteUser();}
    @Step("Click personalCabinetButton on home page")
    public void clickPersonalCabinetButtonOnHomePage() {
        objHomePage.clickPersonalCabinetButton();
    }
    @Test
    @DisplayName("User authorization from registration page")
    public void userAuthFromRegPage() {

        clickLogInButtonOnHomePage();
        clickRegistrationLink();
        clickLogInLink();
        setUserData();
        checkUserHasBeenAuthorized();
       }
    @Step("Click registration link")
    public void clickRegistrationLink() {
        objLogInPage.waitForLoadLogInPage();
        objLogInPage.clickRegisterLink();}
    @Step("Click logIn link")
    public void clickLogInLink() {
        objRegistrationPage.waitForLoadRegPage();
        objRegistrationPage.clickLogInLink();}
    @Test
    @DisplayName("User authorization from recoverPassword page")
    public void userAuthFromRecoverPasswordPage() {

        clickLogInButtonOnHomePage();
        clickRecoverLink();
        clickGoLink();
        setUserData();
        checkUserHasBeenAuthorized();
        deleteUser();}
    @Step("Click recover link")
    public void clickRecoverLink() {
        objLogInPage.waitForLoadLogInPage();
        objLogInPage.clickRecoverLink();}
    @Step("Click go link")
    public void clickGoLink() {
        objRecoverPasswordPage.waitForLoadRecoverPasswordPage();
        objRecoverPasswordPage.clickGoLink();}
    }
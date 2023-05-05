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
    @After
    public void deleteUser(){
    userClient.loginUserAPI(Credentials.userWithoutName);
    userClient.deleteUserAPI(token);}
    @Test
    @DisplayName("User authorization by logInButton")
    public void checkUserAuthByLogInButton() {
        objHomePage.clickLogInButton();
        objLogInPage.setUserData();
        objHomePage.waitForLoadHomePage();
        boolean response=objHomePage.isSetOrderButtonVisible();
        assertTrue(response);}
    @Test
    @DisplayName("User authorization by personalCabinetButton")
    public void userAuthByPersonalCabinetButton() {
        objHomePage.clickPersonalCabinetButton();
        objLogInPage.setUserData();
        objHomePage.waitForLoadHomePage();
        boolean response=objHomePage.isSetOrderButtonVisible();
        assertTrue(response);}
    @Test
    @DisplayName("User authorization from registration page")
    public void userAuthFromRegPage() {
        objHomePage.clickLogInButton();
        objLogInPage.clickRegistrationLink();
        objRegistrationPage.clickLogInLink();
        objLogInPage.setUserData();
        objHomePage.waitForLoadHomePage();
        boolean response=objHomePage.isSetOrderButtonVisible();
        assertTrue(response);}
    @Test
    @DisplayName("User authorization from recoverPassword page")
    public void userAuthFromRecoverPasswordPage() {
        objHomePage.clickLogInButton();
        objLogInPage.clickRecoverLink();
        objRecoverPasswordPage.clickGoLink();
        objLogInPage.setUserData();
        objHomePage.waitForLoadHomePage();
        boolean response=objHomePage.isSetOrderButtonVisible();
        assertTrue(response);}
}
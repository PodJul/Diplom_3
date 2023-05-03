import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
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
    UserClient userClient = new UserClient();
    HomePageStellarBurgers objHomePage;
    LogInPageStellarBurgers objLogInPage;
    RegistrationPageStellarBurgers objRegistrationPage;
    RecoverPasswordPageStellarBurgers objRecoverPasswordPage;
    @Before
    public void createUser() {
        userClient.createUserAndCheckStatusCode(Credentials.user);
    }
    @After
    public void deleteUser(){userClient.deleteUser(Credentials.user);}
    @Test
    @DisplayName("User authorization by logInButton")
    public void userAuthByLogInButton() {
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        objRegistrationPage = new RegistrationPageStellarBurgers(driver);
        clickLogInButtonOnHomePage();
        setUserData();
        checkUserHasBeenAuthorized();}
    @Step("Click LogIn button on home page")
    public void clickLogInButtonOnHomePage() {
        objHomePage.clickLogInButton();
    }
    @Step("Set user data")
    public void setUserData() {
        objLogInPage.waitForLoadLogInPage();
        objLogInPage.setLogInData(Credentials.fakeEmail, Credentials.fakePassword);}
    @Step("Check user has been authorized")
    public void checkUserHasBeenAuthorized() {
        objHomePage.waitForLoadHomePage();
        assertTrue(objHomePage.isSetOrderButtonVisible());}
    @Test
    @DisplayName("User authorization by personalCabinetButton")
    public void userAuthByPersonalCabinetButton() {
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        objRegistrationPage = new RegistrationPageStellarBurgers(driver);
        clickPersonalCabinetButtonOnHomePage();
        setUserData();
        checkUserHasBeenAuthorized();}
    @Step("Click personalCabinetButton on home page")
    public void clickPersonalCabinetButtonOnHomePage() {
        objHomePage.clickPersonalCabinetButton();
    }
    @Test
    @DisplayName("User authorization from registration page")
    public void userAuthFromRegPage() {
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        objRegistrationPage = new RegistrationPageStellarBurgers(driver);
        clickLogInButtonOnHomePage();
        clickRegistrationLink();
        clickLogInLink();
        setUserData();
        checkUserHasBeenAuthorized();}
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
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        objRegistrationPage = new RegistrationPageStellarBurgers(driver);
        objRecoverPasswordPage = new RecoverPasswordPageStellarBurgers(driver);
        clickLogInButtonOnHomePage();
        clickRecoverLink();
        clickGoLink();
        setUserData();
        checkUserHasBeenAuthorized();}
    @Step("Click recover link")
    public void clickRecoverLink() {
        objLogInPage.waitForLoadLogInPage();
        objLogInPage.clickRecoverLink();}
    @Step("Click go link")
    public void clickGoLink() {
        objRecoverPasswordPage.waitForLoadRecoverPasswordPage();
        objRecoverPasswordPage.clickGoLink();}
    }
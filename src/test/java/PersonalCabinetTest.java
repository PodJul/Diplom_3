import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import user.Credentials;
import user.UserClient;
import static org.junit.Assert.assertTrue;

public class PersonalCabinetTest extends BaseTest{
    UserClient userClient=new UserClient();
    HomePageStellarBurgers objHomePage;
    LogInPageStellarBurgers objLogInPage;
    PersonalCabinetPageStellarBurgers objPersonalCabinetPage;
    String token;
    @Before

    public void createUser() {
        Response response = userClient.createUserAPI(Credentials.user);
        token = response.then().extract().path("accessToken");
        objHomePage=new HomePageStellarBurgers(driver);
        objLogInPage=new LogInPageStellarBurgers(driver);
        objPersonalCabinetPage=new PersonalCabinetPageStellarBurgers(driver);}

    @Test
    @DisplayName("Get personal cabinet page")
    public void getPersonalCabinetPage() {
         clickLogInButtonOnHomePage();
         setUserData();
         clickPersonalCabinetButton();
         checkGetPersonalCabinetPage();
         deleteUser();}
    @Step("Click LogIn button on home page")
    public void clickLogInButtonOnHomePage() {
        objHomePage.clickLogInButton();}
    @Step("Set user data")
    public void setUserData() {
        objLogInPage.waitForLoadLogInPage();
        objLogInPage.setLogInData(Credentials.fakeEmail, Credentials.fakePassword);}
    @Step("Click personalCabinetButton on home page")
    public void clickPersonalCabinetButton() {
        objHomePage.waitForLoadHomePage();
        objHomePage.clickPersonalCabinetButton();
       }
    @Step("Check user get personal cabinet page")
    public void checkGetPersonalCabinetPage() {
        objPersonalCabinetPage.waitForLoadPersonalCabinetPage();
        assertTrue(objPersonalCabinetPage.isQuitTextVisible());}
    @Step("Delete user")
    public void deleteUser(){
        userClient.loginUserAPI(Credentials.userWithoutName);
        userClient.deleteUserAPI(token);}
    @Test
    @DisplayName("Get constructor from personal cabinet by clicking constructorButton")
    public void getConstructorPageByConstructorButton() {
        clickLogInButtonOnHomePage();
        setUserData();
        clickPersonalCabinetButton();
        clickConstructorButton();
        checkGetConstructor();
        deleteUser();}

    @Step("Click constructorButton")
    public void clickConstructorButton() {
        objPersonalCabinetPage.waitForLoadPersonalCabinetPage();
        objPersonalCabinetPage.clickConstructorButton();}
    @Step("Check user get constructor with ingredients")
    public void checkGetConstructor() {
        objHomePage.waitForLoadHomePage();
        assertTrue(objHomePage.isingredientsContainerVisible());}
    @Test
    @DisplayName("Get constructor from personal cabinet by clicking logo Stellar Burgers")
    public void getConstructorPageByLogoStellarBurgers() {
        clickLogInButtonOnHomePage();
        setUserData();
        clickPersonalCabinetButton();
        clickLogoStellarBurgers();
        checkGetConstructor();
        deleteUser();}
    @Step("Click logo Stellar Burgers")
    public void clickLogoStellarBurgers() {
        objPersonalCabinetPage.waitForLoadPersonalCabinetPage();
        objPersonalCabinetPage.clickLogoStellarBurgers();}
    @Test
    @DisplayName("Quit from profile")
    public void quitFromProfile() {
        clickLogInButtonOnHomePage();
        setUserData();
        clickPersonalCabinetButton();
        clickQuitLink();
        checkUserHadQuit();
        deleteUser();}
    @Step("Click quit link")
    public void clickQuitLink() {
        objPersonalCabinetPage.waitForLoadPersonalCabinetPage();
        objPersonalCabinetPage.clickQuitLink();}
    @Step("Check user had quit")
    public void checkUserHadQuit() {
        objLogInPage.waitForLoadLogInPage();
        assertTrue(objLogInPage.isLogoButtonVisible());}
    }

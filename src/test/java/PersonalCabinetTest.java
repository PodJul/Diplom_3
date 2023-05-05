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
    @After
    public void deleteUser(){
        userClient.loginUserAPI(Credentials.userWithoutName);
        userClient.deleteUserAPI(token);}
    @Test
    @DisplayName("Get personal cabinet page")
    public void checkGetPersonalCabinetPage() {
        objHomePage.clickLogInButton();
        objLogInPage.setUserData();
        objHomePage.clickPersonalCabinetButton();
        objPersonalCabinetPage.waitForLoadPersonalCabinetPage();
        boolean response=objPersonalCabinetPage.isQuitTextVisible();
        assertTrue(response);}
    @Test
    @DisplayName("Get constructor from personal cabinet by clicking constructorButton")
    public void checkGetConstructorPageByConstructorButton() {
        objHomePage.clickLogInButton();
        objLogInPage.setUserData();
        objHomePage.clickPersonalCabinetButton();
        objPersonalCabinetPage.clickConstructorButton();
        objHomePage.waitForLoadHomePage();
        boolean response=objHomePage.isIngredientsContainerVisible();
        assertTrue(response);}
    @Test
    @DisplayName("Get constructor from personal cabinet by clicking logo Stellar Burgers")
    public void getConstructorPageByLogoStellarBurgers() {
        objHomePage.clickLogInButton();
        objLogInPage.setUserData();
        objHomePage.clickPersonalCabinetButton();
        objPersonalCabinetPage.clickLogoStellarBurgers();
        objHomePage.waitForLoadHomePage();
        boolean response=objHomePage.isIngredientsContainerVisible();
        assertTrue(response);}
    @Test
    @DisplayName("Quit from profile")
    public void checkQuitFromProfile() {
        objHomePage.clickLogInButton();
        objLogInPage.setUserData();
        objHomePage.clickPersonalCabinetButton();
        objPersonalCabinetPage.clickQuitLink();
        objLogInPage.waitForLoadLogInPage();
        boolean response=objLogInPage.isLogoButtonVisible();
        assertTrue(response);}

    }

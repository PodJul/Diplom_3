import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import user.Credentials;
import user.UserClient;
import static org.junit.Assert.assertTrue;

public class PersonalCabinetTest extends BaseTest{
    UserClient userClient = new UserClient();
    HomePageStellarBurgers objHomePage;
    LogInPageStellarBurgers objLogInPage;
    PersonalCabinetPageStellarBurgers objPersonalCabinetPage;
    @Before
    public void createUser() {
        userClient.createUserAndCheckStatusCode(Credentials.user);}
    @After
    public void deleteUser(){
        userClient.deleteUser(Credentials.user);}
    @Test
    @DisplayName("Get personal cabinet page")
    public void getPersonalCabinetPage() {
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        objPersonalCabinetPage=new PersonalCabinetPageStellarBurgers(driver);
        clickLogInButtonOnHomePage();
        setUserData();
        clickPersonalCabinetButton();
        checkGetPersonalCabinetPage();}
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
        objHomePage.clickPersonalCabinetButton();}
    @Step("Check user get personal cabinet page")
    public void checkGetPersonalCabinetPage() {
        objPersonalCabinetPage.waitForLoadPersonalCabinetPage();
        assertTrue(objPersonalCabinetPage.isQuitTextVisible());}
    @Test
    @DisplayName("Get constructor from personal cabinet by clicking constructorButton")
    public void getConstructorPageByConstructorButton() {
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        objPersonalCabinetPage=new PersonalCabinetPageStellarBurgers(driver);
        clickLogInButtonOnHomePage();
        setUserData();
        clickPersonalCabinetButton();
        clickConstructorButton();
        checkGetConstructor();}
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
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        objPersonalCabinetPage=new PersonalCabinetPageStellarBurgers(driver);
        clickLogInButtonOnHomePage();
        setUserData();
        clickPersonalCabinetButton();
        clickLogoStellarBurgers();
        checkGetConstructor();}
    @Step("Click logo Stellar Burgers")
    public void clickLogoStellarBurgers() {
        objPersonalCabinetPage.waitForLoadPersonalCabinetPage();
        objPersonalCabinetPage.clickLogoStellarBurgers();}
    @Test
    @DisplayName("Quit from profile")
    public void quitFromProfile() {
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        objPersonalCabinetPage=new PersonalCabinetPageStellarBurgers(driver);
        clickLogInButtonOnHomePage();
        setUserData();
        clickPersonalCabinetButton();
        clickQuitLink();
        checkUserHadQuit();}
    @Step("Click quit link")
    public void clickQuitLink() {
        objPersonalCabinetPage.waitForLoadPersonalCabinetPage();
        objPersonalCabinetPage.clickQuitLink();}
    @Step("Check user had quit")
    public void checkUserHadQuit() {
        objLogInPage.waitForLoadLogInPage();
        assertTrue(objLogInPage.isLogoButtonVisible());}
    }

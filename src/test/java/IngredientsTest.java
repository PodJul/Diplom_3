import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePageStellarBurgers;
import pages.LogInPageStellarBurgers;
import user.Credentials;
import user.UserClient;
import static org.junit.Assert.assertTrue;

public class IngredientsTest extends BaseTest{

    UserClient userClient = new UserClient();
    HomePageStellarBurgers objHomePage;
    LogInPageStellarBurgers objLogInPage;
    @Before
    public void createUser() {
        userClient.createUserAndCheckStatusCode(Credentials.user);}
    @After
    public void deleteUser(){
        userClient.deleteUser(Credentials.user);}
    @Test
    @DisplayName("Get section with bun")
    public void getBunSection() {
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        clickLogInButtonOnHomePage();
        setUserData();
        clickMenuSauceText();
        clickMenuBunText();
        checkBunTextIsVisible();}
    @Step("Click LogIn button on home page")
    public void clickLogInButtonOnHomePage() {
        objHomePage.clickLogInButton();}
    @Step("Set user data")
    public void setUserData() {
        objLogInPage.waitForLoadLogInPage();
        objLogInPage.setLogInData(Credentials.fakeEmail, Credentials.fakePassword);}
    @Step("Click menuBunText")
    public void clickMenuBunText() {
        objHomePage.waitForLoadHomePage();
        objHomePage.clickMenuBunText();}
    @Step("Check BunText is visible")
    public void checkBunTextIsVisible() {
        assertTrue(objHomePage.isBunTextVisible());}
    @Test
    @DisplayName("Get section with sauce")
    public void getSauceSection() {
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        clickLogInButtonOnHomePage();
        setUserData();
        clickMenuSauceText();
        checkSauceTextIsVisible();}
    @Step("Click menuSauceText")
    public void clickMenuSauceText() {
        objHomePage.waitForLoadHomePage();
        objHomePage.clickMenuSauceText();}
    @Step("Check sauceText is visible")
    public void checkSauceTextIsVisible() {
        assertTrue(objHomePage.isSauceTextVisible());}
    @Test
    @DisplayName("Get section with filling")
    public void getFillingSection() {
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        clickLogInButtonOnHomePage();
        setUserData();
        clickMenuFillingText();
        checkFillingTextIsVisible();}
    @Step("Click menuFillingText")
    public void clickMenuFillingText() {
        objHomePage.waitForLoadHomePage();
        objHomePage.clickMenuFillingText();}
    @Step("Check fillingText is visible")
    public void checkFillingTextIsVisible() {
        assertTrue(objHomePage.isFillingTextVisible());}
    }

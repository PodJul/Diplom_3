import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
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

    @After
    public void deleteUser(){
        userClient.deleteUser(Credentials.user);}
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
    }

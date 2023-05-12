import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePageStellarBurgers;
import pages.LogInPageStellarBurgers;
import pages.RegistrationPageStellarBurgers;
import user.Credentials;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedRegistrationTest extends BaseTest {
    private final String password;
    private final boolean expected;
    HomePageStellarBurgers objHomePage;
    LogInPageStellarBurgers objLogInPage;
    RegistrationPageStellarBurgers objRegistrationPage;

    public ParametrizedRegistrationTest(String password, boolean expected) {
        this.password = password;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {Credentials.fakePasswordFive, true},
                {Credentials.fakePasswordLessSix, true},
                {Credentials.fakePasswordSeven, false},
                {Credentials.fakePassword, false},
                {Credentials.fakePasswordZero, true},//Этот тест падает из-за бага: если поле ввода пароля пустое,сообщения об ошибке нет
                };}
    @Test
    @DisplayName("Check password is correct")
    public void checkPasswordIsCorrect () {
        objHomePage = new HomePageStellarBurgers(driver);
        objLogInPage = new LogInPageStellarBurgers(driver);
        objRegistrationPage = new RegistrationPageStellarBurgers(driver);
        objHomePage.clickLogInButton();
        objLogInPage.clickRegistrationLink();
        objRegistrationPage.waitForLoadRegPage();
        objRegistrationPage.setRegistrationData(Credentials.fakeName, Credentials.fakeEmail, password);
        boolean actual = objRegistrationPage.isWrongPasswordTextVisible();
        assertEquals(expected, actual);}


}

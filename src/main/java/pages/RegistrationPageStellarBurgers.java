package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPageStellarBurgers {
    private WebDriver driver;
    public RegistrationPageStellarBurgers(WebDriver driver) {
        this.driver = driver;
    }
    // текст "Регистрация"
    private final By regText = By.xpath(".//*[text()='Регистрация']");
    // поле с именем
    private final By nameField = By.xpath("//div/form/fieldset[1]//input[@name='name']");
    // поле с email
    private final By emailField = By.xpath("//div/form/fieldset[2]//input[@name='name']");
    // поле с паролем
    private final By passwordField = By.xpath("//div/form/fieldset[3]//input[@name='Пароль']");
    // кнопка "Зарегистрироваться"
    private final By regButton = By.xpath(".//*[text()='Зарегистрироваться']");
    // текст "Некорректный пароль"
    private final By wrongPasswordText = By.xpath("//div/form/fieldset[3]/div/p");
    // ссылка "Войти"
    private final By logInLink = By.xpath("//main/div/div/p/*[@href='/login']");
    @Step("Wait for load registration page")
    public void waitForLoadRegPage() {
        new WebDriverWait(driver, 10).until(driver -> driver.findElement(regText).isDisplayed());
    }
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickRegButton() {
        driver.findElement (regButton).click();
    }
    @Step("Click logIn link")
    public void clickLogInLink() {
        waitForLoadRegPage();
        driver.findElement (logInLink).click();}
    @Step("Set registration data")
    public void setRegistrationData (String name,String email,String password){

        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegButton();}
    @Step("Check wrong password text is visible ")
    public boolean isWrongPasswordTextVisible(){
        return driver.findElements(wrongPasswordText).size() > 0;
    }
    }

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPageStellarBurgers {
    private WebDriver driver;
    // текст "Вход"
    private final By logInText = By.xpath(".//main/div/h2");
    // поле с email
    private final By emailField = By.xpath(".//*[@type='text']");
    // поле с password
    private final By passwordField = By.xpath(".//*[@type='password']");
    // кнопка "Войти"
    private final By logoButton = By.xpath("//div/form/button");
    // ссылка "Зарегистрироваться"
    private final By registerLink = By.xpath("//div/p[1]/*[@href='/register']");
    // ссылка "Восстановить пароль"
    private final By recoverLink = By.xpath("//div/p[2]/*[@href='/forgot-password']");

    public LogInPageStellarBurgers(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadLogInPage() {
        new WebDriverWait(driver, 15).until(driver -> driver.findElement(logInText).isDisplayed());
    }
    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }
    public void clickRecoverLink() {
        driver.findElement(recoverLink).click();
    }

    public void setEmail(String email) {driver.findElement(emailField).sendKeys(email);}
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogoButton() {driver.findElement(logoButton).click();}
    public void setLogInData(String email,String password) {
        setEmail(email);
        setPassword(password);
        clickLogoButton();
    }
    public boolean isLogoButtonVisible(){return driver.findElement(logoButton).isDisplayed();}

}
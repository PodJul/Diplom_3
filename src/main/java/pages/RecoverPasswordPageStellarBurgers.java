package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecoverPasswordPageStellarBurgers {
    private WebDriver driver;
    // текст "Восстановление пароля"
    private final By recoverPasswordText = By.xpath(".//main/div/h2");
    // ссылка "Войти"
    private final By goLink = By.xpath(".//main/div/div/p/*[@href='/login']");

    public RecoverPasswordPageStellarBurgers(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadRecoverPasswordPage() {
        new WebDriverWait(driver, 10).until(driver -> driver.findElement(recoverPasswordText).isDisplayed());
    }
    public void clickGoLink()  {
        driver.findElement (goLink).click();
    }
}

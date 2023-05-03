package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalCabinetPageStellarBurgers {
    private WebDriver driver;
    // ссылка "Профиль"
    private final By profileLink = By.xpath(".//nav/ul/li[1]/*[@href='/account/profile']");
    // ссылка "Выход"
    private final By quitLink = By.xpath(".//nav/ul/li[3]/button");
    // кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//nav/ul/li[1]/a/p");
    // логотип
    private final By logoStellarBurgers = By.xpath(".//header/nav/div");
    public PersonalCabinetPageStellarBurgers(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadPersonalCabinetPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(profileLink));
    }
    public boolean isQuitTextVisible() {
        return driver.findElement(quitLink).isDisplayed();
    }
    public void clickConstructorButton() {
        driver.findElement (constructorButton).click();
    }
    public void clickLogoStellarBurgers() {
        driver.findElement (logoStellarBurgers).click();
    }
    public void clickQuitLink() {
        driver.findElement (quitLink).click();
    }
}

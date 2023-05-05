package pages;

import io.qameta.allure.Step;
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
    @Step("Wait for load personal cabinet page")
    public void waitForLoadPersonalCabinetPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(profileLink));
    }
    @Step("Check quit text is visible")
    public boolean isQuitTextVisible() {
        return driver.findElement(quitLink).isDisplayed();
    }
    @Step("Click constructorButton")
    public void clickConstructorButton() {
        waitForLoadPersonalCabinetPage();
        driver.findElement (constructorButton).click();}
    @Step("Click logo Stellar Burgers")
    public void clickLogoStellarBurgers() {
        waitForLoadPersonalCabinetPage();
        driver.findElement (logoStellarBurgers).click();}
    @Step("Click quit link")
    public void clickQuitLink() {
        waitForLoadPersonalCabinetPage();
        driver.findElement (quitLink).click();}
   }

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageStellarBurgers {
    private WebDriver driver;
    // кнопка "Личный кабинет"
    private final By personalCabinetButton = By.xpath("//div/div//nav//*[@href='/account']");
    // текст "Соберите бургер"
    private final By homeText = By.xpath(".//main/section[1]/h1");
    // кнопка "Войти в аккаунт"
    private final By logInButton = By.xpath(".//button[text()='Войти в аккаунт']");
    // кнопка "Оформить заказ"
    private final By setOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    // область с ингредиентами
    private final By ingredientsContainer = By.className("BurgerIngredients_ingredients__menuContainer__Xu3Mo");
    // текст меню "Булки"
    private final By menuBunText = By.xpath(".//main/section[1]/div/div[1]");
    // текст "Булки"
    private final By bunText = By.xpath(".//main/section[1]/div/h2[1]");
    // текст меню "Соусы"
    private final By menuSauceText = By.xpath(".//main/section[1]/div/div[2]");
    // текст "Соусы"
    private final By sauceText = By.xpath(".//main/section[1]/div/h2[2]");
    // текст меню "Начинки"
    private final By menuFillingText = By.xpath(".//main/section[1]/div/div[3]");
    // текст "Начинки"
    private final By fillingText = By.xpath(".//main/section[1]/div/h2[3]");
    public HomePageStellarBurgers(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadHomePage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(homeText));
    }
    public void clickPersonalCabinetButton() {
        driver.findElement (personalCabinetButton).click();
    }
    public void clickLogInButton() {
        driver.findElement (logInButton).click();
    }
    public void clickMenuBunText() {driver.findElement (menuBunText).click();}
    public void clickMenuSauceText() {driver.findElement (menuSauceText).click();}
    public void clickMenuFillingText() {driver.findElement (menuFillingText).click();}
    public boolean isSetOrderButtonVisible() {return driver.findElement(setOrderButton).isDisplayed();}
    public boolean isingredientsContainerVisible() {
        return driver.findElement(ingredientsContainer).isDisplayed();
    }
    public boolean isBunTextVisible() {
        return driver.findElement(bunText).isDisplayed();
    }
    public boolean isSauceTextVisible() {
        return driver.findElement(sauceText).isDisplayed();
    }
    public boolean isFillingTextVisible() {
        return driver.findElement(fillingText).isDisplayed();
    }
}

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.HomePageStellarBurgers;
import static org.junit.Assert.assertTrue;

public class IngredientsTest extends BaseTest{

    HomePageStellarBurgers objHomePage;
    @Test
    @DisplayName("Get section with bun")
    public void getBunSection() {
        objHomePage= new HomePageStellarBurgers(driver);
        clickMenuSauceText();
        clickMenuBunText();
        checkBunTextIsVisible();}
    @Step("Click menuBunText")
    public void clickMenuBunText() {
        objHomePage.clickMenuBunText();}
    @Step("Check BunText is visible")
    public void checkBunTextIsVisible() {
        assertTrue(objHomePage.isBunTextVisible());}
    @Test
    @DisplayName("Get section with sauce")
    public void getSauceSection() {
        objHomePage= new HomePageStellarBurgers(driver);
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
        objHomePage= new HomePageStellarBurgers(driver);
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

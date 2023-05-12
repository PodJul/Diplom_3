import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.HomePageStellarBurgers;
import static org.junit.Assert.assertTrue;

public class IngredientsTest extends BaseTest{

    HomePageStellarBurgers objHomePage;
    @Before
    public void setUp(){
    objHomePage= new HomePageStellarBurgers(driver);}
    @Test
    @DisplayName("Get section with bun")
    public void getBunSection() {
        objHomePage.clickMenuSauceText();
        objHomePage.clickMenuBunText();
        boolean response=objHomePage.isBunTextVisible();
        assertTrue(response);}
    @Test
    @DisplayName("Get section with sauce")
    public void getSauceSection() {
        objHomePage.clickMenuSauceText();
        boolean response=objHomePage.isSauceTextVisible();
        assertTrue(response);}
    @Test
    @DisplayName("Get section with filling")
    public void getFillingSection() {
        objHomePage.clickMenuFillingText();
        boolean response=objHomePage.isFillingTextVisible();
        assertTrue(response);}
    }

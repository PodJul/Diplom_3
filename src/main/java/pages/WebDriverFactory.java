package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public static WebDriver get(){
        WebDriver driver;
        String browserName=System.getenv().get("browser");
        switch (browserName){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "yandex":
                ChromeOptions options=new ChromeOptions();
                options.setBinary("C:/Users/Julia/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
                driver=new ChromeDriver(options);
                break;
            default:throw new RuntimeException("Браузера "+browserName+" не существует");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait (5, TimeUnit.SECONDS);
        driver.navigate().to("https://stellarburgers.nomoreparties.site");
        return driver;
    }
}


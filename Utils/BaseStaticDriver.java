package Gun04.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.time.Duration;

public class BaseStaticDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    static
    {
        KalanOncekileriKapat();
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver", "/Users/metinhasal/Desktop/Selenium/ChromeDriver/chromedriver");
        driver =new ChromeDriver();
        // driver.manage().window().maximize(); // maximize

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().deleteAllCookies(); // her zaman yeni bağlanıyor gibi oluyoruz

      // Duration dr = Duration.ofSeconds(30);
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // sadece ana sayfa yüklenirken en başta
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // bütün webElement için geçerli
    }

    public static Select BekleKapat(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        return null;
    }
    public static void Bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }

}

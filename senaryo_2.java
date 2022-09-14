package Projeler.Proje_3;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class senaryo_2 extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart = driver.findElement(By.xpath("(//*[@class='basicDetails'])[2]/button"));
        addToCart.click();

        WebElement iframe = driver.findElement(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement addPromoCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Apply-Button")));
        addPromoCode.click();

        WebElement promoCodeInput = driver.findElement(By.className("Promo-Code-Value"));
        promoCodeInput.sendKeys("123456789");

        WebElement applyBtn = driver.findElement(By.className("Promo-Apply"));
        applyBtn.click();

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SnackBar")));
        Assert.assertTrue(message.isDisplayed());

        BekleKapat();
    }
}

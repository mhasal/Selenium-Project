package Projeler.Proje_3;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class senaryo_3 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart = driver.findElement(By.xpath("(//*[@class='basicDetails'])[2]/button"));
        addToCart.click();

        WebElement iframe = driver.findElement(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement payUsingDebitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("CC")));
        payUsingDebitBtn.click();

        WebElement payBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Pay-Button")));
        payBtn.click();

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SnackBar")));
        Assert.assertTrue(message.isDisplayed());

        BekleKapat();
    }
}

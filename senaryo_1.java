package Projeler.Proje_3;

import org.junit.Assert;
import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class senaryo_1 extends BaseStaticDriver {

    public static void main(String[] args) {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart = driver.findElement(By.xpath("(//*[@class='basicDetails'])[2]/button"));
        addToCart.click();

        WebElement iframe = driver.findElement(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement cartItemNo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='Cart-Items-Nos'])[2]")));
        Assert.assertTrue(cartItemNo1.getText().contains("1"));

        WebElement removeItemBtn = driver.findElement(By.cssSelector("button[class='Product-Remove']"));
        removeItemBtn.click();

        WebElement continueShoppingBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='Continue-Button Close-Cart']")));
        continueShoppingBtn.click();

        driver.switchTo().defaultContent();

        WebElement cartItemNo2 = driver.findElement(By.xpath("//span[@id='cart_item_nos']"));
        Assert.assertTrue(cartItemNo2.getText().contains("0"));

        BekleKapat();
    }
}

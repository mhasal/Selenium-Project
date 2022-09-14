package Projeler.Proje_3;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class senaryo_5 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart = driver.findElement(By.xpath("(//*[@class='basicDetails'])[2]/button"));
        addToCart.click();

        WebElement iframe = driver.findElement(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement payUsingDebitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("CC")));
        payUsingDebitBtn.click();

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Email']")));
        emailInput.sendKeys("techno121@email.com");

        WebElement confirmEmailInput = driver.findElement(By.cssSelector("[placeholder='Confirm Email']"));
        confirmEmailInput.sendKeys("techno121@email.com");

        WebElement nameInput = driver.findElement(By.cssSelector("[placeholder='Name On Card']"));
        nameInput.sendKeys("Techno");

        WebElement phoneInput = driver.findElement(By.cssSelector("[placeholder='Optional']"));
        phoneInput.sendKeys("5748968525");

        WebElement iframe2 = driver.findElement(By.cssSelector("[name^='__privateStripeFrame']"));
        driver.switchTo().frame(iframe2);

        WebElement cardNumberInput = driver.findElement(By.name("cardnumber"));
        cardNumberInput.sendKeys("4242 4242 4242 4242");

        WebElement expDateInput = driver.findElement(By.name("exp-date"));
        expDateInput.sendKeys("12/22");

        WebElement cvcInput = driver.findElement(By.name("cvc"));
        cvcInput.sendKeys("000");

        driver.switchTo().parentFrame();

        WebElement payBtn = driver.findElement(By.className("Pay-Button"));
        payBtn.click();

        Boolean message1 = wait.until(ExpectedConditions.urlContains("https://www.fatfreecartpro.com/"));

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='green_text_margin']")));
        Assert.assertTrue(message.getText().contains("Thank you!"));
    }
}

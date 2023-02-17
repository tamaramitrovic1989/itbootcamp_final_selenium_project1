package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage {

    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForPopUpMessage() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div/div[1]/ul/li")));
    }

    public String getPopUpText() {
        return driver
                .findElement(By.xpath("//div/div[1]/ul/li")).getText();
    }

    public WebElement getCloseButton() {
        return driver
                .findElement(By.xpath("//*[@class='v-snack__content']/button"));
    }

    public void waitForVerifyYourAccountPopUp() {
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.className("dlgVerifyAccount")));

    }
    public String verifyPopUpText(){
        return driver.findElement(By.className("dlgVerifyAccount")).getText();
    }

    public WebElement getVerifyAccountCloseButton(){
        return driver.findElement(By.className("btnClose"));
    }

    public void waitForSuccessDialog(){
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[contains(@class, 'success')]")));
    }

    public WebElement getSuccessMessage(){
        return driver.findElement(By.xpath(
                "//*[contains(@class,'success')]/div"));
    }


}
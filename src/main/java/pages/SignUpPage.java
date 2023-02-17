package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends  BasePage{


    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameSignUp() {
        return driver
                .findElement(By.xpath("//input[@id='name']"));

    }
    public WebElement getEmailSignUp() {
        return driver
                .findElement(By.xpath("//input[@id='email']"));
    }
    public WebElement getPasswordSignUp() {
        return driver
                .findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement getConfirmPasswordSignUp() {
        return driver
                .findElement(By.xpath("//input[@id='confirmPassword']"));
    }
    public WebElement getSignUpButton() {
        return driver
        .findElement(By.xpath("//button[@type='submit']"));
    }
}

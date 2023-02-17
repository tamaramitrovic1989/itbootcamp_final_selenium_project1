package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage extends  BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmaillogIn () {
        return driver.findElement((By.id("email")));
    }

    public WebElement getPasswordLogIn () {
        return driver.findElement((By.id("password")));
    }

    public WebElement getLogInButton () {
        return driver.findElement(By.xpath("//button[@type='submit']"));

    }
    public void waitForWelcomeHome() {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//h1[@class='display-2 font-weight-bold']")));
    }


}





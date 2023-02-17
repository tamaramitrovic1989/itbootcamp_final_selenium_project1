package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {


    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLink() {
        return driver.findElement((By.xpath("//*[@class='v-toolbar__items']/a")));
    }

    public WebElement getAboutLink() {
        return driver.findElement((By.className("//*[@class='v-toolbar__items']/a[2]")));
    }

    public WebElement getMyProfileLink() {
        return driver
                .findElement((By.xpath("//a[@href='/profile']")));
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnAdmin')]"));
    }

    public WebElement getCitiesLink() {
        return driver
                .findElement(By.className("btnAdminCities"));

    }

    public WebElement getUsersLink() {
        return driver
                .findElement(By.className("btnAdminUsers"));
    }

    public WebElement getSignUpButton() {
        return driver
                .findElement(By.xpath("//a[@href='/signup']"));
    }

    public WebElement getlogInButton() {
        return driver
                .findElement(By.xpath("//*[@class='v-toolbar__items']/a[3]"));
    }

    public WebElement getLogOutButton() {
        return wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.className("btnLogout")));
    }

    public WebElement getLanguageButton() {
        return driver
                .findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
    }

    public WebElement getEnLanguage() {
        return driver
                .findElement(By.xpath("//*[contains(@class, 'btnEN')]"));
    }

    public WebElement getEsLanguage() {
        return driver
                .findElement(By.xpath("//*[contains(@class, 'btnES')]"));
    }

    public WebElement getFrLanguage() {
        return driver
                .findElement(By.xpath("//*[contains(@class, 'btnFR')]"));
    }
    public WebElement getCnLanguage() {
        return driver
                .findElement(By.xpath("//*[contains(@class, 'btnCN')]"));

    }


}
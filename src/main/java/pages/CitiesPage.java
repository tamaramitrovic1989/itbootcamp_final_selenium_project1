package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage {


    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton() {
        return driver
                .findElement(By.xpath("//div[@class='text-right']/button"));
    }

    public WebElement getSearchInput() {
        return driver
                .findElement(By.xpath("//*[@class='v-text-field__slot']/input"));
    }

    public void waitForDialogEditOrCreateToBeVisible() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(@class, 'dlgNewEditItem ')]")));
    }
    public void waitForDialogDeleteToBevisible() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-dialog')]//header[contains(@class, 'warning')]")));
    }
    public WebElement getSaveButton() {
        return driver
         .findElement(By.xpath("//*[contains(@class, 'btnSave ')]"));
    }
    public WebElement getdeleteButton() {
        return driver
        .findElement(By.xpath("//*[contains(@class,'v-dialog--active')]//button[2]"));
    }
    public void waitFornumberOfRowsToBe(int numberOfRows) {
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//*[@class='v-data-table__wrapper']"),numberOfRows));
}

public  WebElement getCellByRowAndColumn(int row, int column) {
    return driver.findElement(By.xpath(
            "//tbody/tr[" + row + "]/td[" + column + "]"));
}
    public  WebElement getEditByRow(int row){
        return driver.findElement(By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr["+row+"]/td/div/button[1]"));
    }
    public  WebElement getDeleteByRow(int row){
        return driver
           .findElement(By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr["+row+"]/td/div/button[2]"));
    }
    public WebElement getCityNameInput() {
        return driver.findElement(By.id("name"));

    }
}


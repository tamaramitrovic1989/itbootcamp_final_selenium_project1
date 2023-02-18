package tests;

import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 10)
    @Description("Test #1: Visits the admin cities page and list cities")
    public void visitTheAdminCitiesPageAndListCities() {
        navPage.getlogInButton().click();
        loginPage.getEmaillogIn().sendKeys("admin@admin.com");
        loginPage.getPasswordLogIn().sendKeys("12345");
        loginPage.getLogInButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "Wrong URL, not on admin cities page");
    }

    @Test(priority = 20)
    @Description("Test #2: Checks input types for create/edit new city")
    public void checkInputTypesForCreateEditNewCity() throws InterruptedException{

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForDialogEditOrCreateToBeVisible();
        Assert.assertEquals(citiesPage.getCityNameInput().
                        getAttribute("type"), "text",
                "Wrong input type");
    }

    @Test (priority = 30)
    @Description("Test #3: Create new city")
    public void createNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForDialogEditOrCreateToBeVisible();
        citiesPage.getCityNameInput().sendKeys("Tamara Mitrovic's city");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForSuccessDialog();
        Assert.assertTrue(messagePopUpPage.getSuccessMessage().getText().contains("Saved successfully"),
                "Error notification doesn't contain 'Saved successfully' text!");
    }

    @Test (priority = 40)
    @Description("Test #4: Edit city")
    public void editCity() {
    navPage.getAdminButton().click();
    navPage.getCitiesLink().click();
    citiesPage.getSearchInput().sendKeys("Tamara Mitrovic's city");
        citiesPage.waitFornumberOfRowsToBe(1);
        citiesPage.getEditByRow(1).click();
        citiesPage.getCityNameInput().click();
        citiesPage.getCityNameInput().sendKeys(Keys.CONTROL + "a");
        citiesPage.getCityNameInput().sendKeys(Keys.BACK_SPACE);
        citiesPage.getCityNameInput()
                .sendKeys("Tamara Mitrovic's city edited");
        citiesPage.getSaveButton()
                .click();
        messagePopUpPage.waitForSuccessDialog();
        Assert.assertTrue(messagePopUpPage.getSuccessMessage()
                        .getText().contains("Saved successfully"),
                "Error notification doesn't contain 'Saved successfully' text!");
    }

    @Test (priority = 50)
    @Description("Test #5: Search city")
    public void searchCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Tamara Mitrovic's city edited");
        citiesPage.waitFornumberOfRowsToBe(1);
        Assert.assertEquals(citiesPage.getCellByRowAndColumn(1, 2).getText(), "Tamara Mitrovic's city edited",
                "Wrong city name!");
    }

    @Test (priority = 60)
    @Description("Test #6: Delete city")
    public void deleteCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Tamara Mitrovic's city edited");
        citiesPage.waitFornumberOfRowsToBe(1);
        Assert.assertEquals(citiesPage.getCellByRowAndColumn(1, 2).getText(), "Tamara Mitrovic's city edited",
                "Wrong city name!");
        citiesPage.getDeleteByRow(1).click();
        citiesPage.waitForDialogDeleteToBevisible();
        citiesPage.getdeleteButton().click();
        messagePopUpPage.waitForSuccessDialog();
        Assert.assertTrue(messagePopUpPage.getSuccessMessage().getText().contains("Deleted successfully"),
                "Notification doesn't contain 'Deleted successfully' text!");
    }


}









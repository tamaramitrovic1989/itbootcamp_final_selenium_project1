package tests;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 10)
    @Description("Test #1: Visits the profile page")
    public void visitTheprofilePage() {
        navPage.getLanguageButton().click();
        navPage.getEnLanguage().click();
        navPage.getlogInButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page!");
    }

    @Test(priority = 20)
    @Description("Test #2: Checks input types")
    public void checkInputTypes() {
        navPage.getlogInButton().click();
        Assert.assertEquals(loginPage.getEmaillogIn().getAttribute("type"), "email",
                "Wrong input type!");
        Assert.assertEquals(loginPage.getPasswordLogIn().getAttribute("type"), "password",
                "Wrong password type!");
    }

    @Test(priority = 30)
    @Description("Test #3: Displays errors when user does not exist")
    public void displaysErrorsWhenUserDoesNotExists() {
        navPage.getlogInButton().click();
        loginPage.getEmaillogIn().sendKeys("non-existing-user@gmail.com");
        loginPage.getPasswordLogIn().sendKeys("password123");
        loginPage.getLogInButton().click();
        messagePopUpPage.waitForPopUpMessage();
        Assert.assertTrue(messagePopUpPage.getPopUpText().contains("User does not exists"),
                "Error notification doesn't contain 'User does not exists' text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page!");
    }

    @Test(priority = 40)
    @Description("Test #4: Displays errors when password is wrong")
    public void displaysErrorsWhenPasswordIsWrong() {
        navPage.getlogInButton().click();
        loginPage.getEmaillogIn().sendKeys("admin@admin.com");
        loginPage.getPasswordLogIn().sendKeys("password123");
        loginPage.getLogInButton().click();
        messagePopUpPage.waitForPopUpMessage();
        Assert.assertTrue(messagePopUpPage.getPopUpText().contains("Wrong password"),
                "Error notification doesn't contain 'Wrong password' text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page!");
    }

    @Test(priority = 50)
    @Description("Test #5: Login")
    public void login() throws InterruptedException {
        navPage.getlogInButton().click();
        loginPage.getEmaillogIn().sendKeys("admin@admin.com");
        loginPage.getPasswordLogIn().sendKeys("12345");
        loginPage.getLogInButton().click();
        loginPage.waitForWelcomeHome();
        Thread.sleep(500);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "Wrong URL, not on home page");
    }

    @Test(priority = 60)
    @Description("Test #6: Logout")
    public void logout() {
        Assert.assertTrue(navPage.getLogOutButton().isDisplayed(),
                "Logout button is not visible!");
        navPage.getLogOutButton().click();
    }


}
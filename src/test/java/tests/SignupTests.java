package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class SignupTests extends BasicTest {
        @Test(priority = 10)
        @Description("Test #1: Visits the signup page")
        public void visitTheSignUpPage() {
            navPage.getSignUpButton().click();
            Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                    "Wrong URL, not on login page!");
        }

        @Test(priority = 20)
        @Description("Test #2: Checks input types")
        public void checkInputTypes() {
            navPage.getSignUpButton().click();
            Assert.assertEquals(signUpPage.getEmailSignUp().getAttribute("type"), "email",
                    "Wrong email type!");
            Assert.assertEquals(signUpPage
                            .getPasswordSignUp().getAttribute("type"),
                    "password",
                    "Wrong password type");
            Assert.assertEquals(signUpPage
                            .getConfirmPasswordSignUp().getAttribute("type"),
                    "password",
                    "Wrong confirm password type");
        }

        @Test(priority = 30)
        @Description("Test #3:  Displays errors when user already exists")
        public void displaysErrorsWhenuserAlreadyExists()throws InterruptedException {
            navPage.getSignUpButton().click();
            Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                    "Wrong URL, not on signup page!");
            signUpPage.getNameSignUp().sendKeys(" Another User");
            signUpPage.getEmailSignUp()
                    .sendKeys("admin@admin.com");
            signUpPage.getPasswordSignUp()
                    .sendKeys("12345");
            signUpPage.getConfirmPasswordSignUp()
                    .sendKeys("12345");
            signUpPage.getSignUpButton()
                    .click();
            messagePopUpPage.waitForPopUpMessage();
            Assert.assertEquals(messagePopUpPage.getPopUpText(),
                    "E-mail already exists",
                    "Wrong error message");
            Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                    "Wrong URL, not on signup page");
        }

        @Test(priority = 40)
        @Description("Test #4: Signup")
        public void signUp() throws InterruptedException {
            navPage.getSignUpButton().click();
            signUpPage.getNameSignUp().sendKeys("Tamara Mitrovic");
            signUpPage.getEmailSignUp().sendKeys("tamaramitrovic1989@itbootcamp.rs");
            signUpPage.getPasswordSignUp().sendKeys("12345");
            signUpPage.getConfirmPasswordSignUp().sendKeys("12345");
            signUpPage.getSignUpButton().click();
            messagePopUpPage.waitForVerifyYourAccountPopUp();
            Assert.assertTrue(messagePopUpPage.verifyPopUpText().contains("IMPORTANT: Verify your account"),
                    "Notification doesn't contain 'IMPORTANT: Verify your account' text!");
            messagePopUpPage.getVerifyAccountCloseButton().click();
            navPage.getLogOutButton().click();

        }



    }








package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NavPage;

public class LocaleTests extends BasicTest {
    @Test(priority = 10)
    @Description("Test #1: Set locale to ES")
    public void setLocaleToEs() {
        navPage.getLanguageButton().click();
        navPage.getEsLanguage().click();
        Assert.assertTrue(driver.getPageSource().contains("Página de aterrizaje"),
                "Header doesn't contain 'Página de aterrizaje' text!");
    }
    @Test(priority = 20)
    @Description("Test #1: Set locale to EN")
    public void setLocaleToEn() {
        navPage.getLanguageButton().click();
        navPage.getEnLanguage().click();
        Assert.assertTrue(driver.getPageSource().contains("Landing"),
                "Header doesn't contain 'Landing' text!");
    }
    @Test(priority = 30)
    @Description("Test #3: Set locale to CN")
    public void setLocaleToCn() {
        navPage.getLanguageButton().click();
        navPage.getCnLanguage().click();
        Assert.assertTrue(driver.getPageSource().contains("首页"),
                "Header doesn't contain '首页' text!");
    }
    @Test(priority = 40)
    @Description("Test #4: Set locale to FR")
    public void setLocaleToFr() {
        navPage.getLanguageButton().click();
        navPage.getFrLanguage().click();
        Assert.assertTrue(driver.getPageSource().contains("Page d'atterrissage"),
                "Header doesn't contain 'Page d'atterrissage' text!");
    }

}
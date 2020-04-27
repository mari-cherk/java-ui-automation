package tests.additional;

import common.Config;
import common.Utils;
import common.dataObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class PreconditionForAutomationTest extends BaseTest {
    @Test(description = "C25498 Configuration Test - Settings", priority = 1)
    public void configurationTestSettings() {
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
        loginPage.makeLogin(Config.SUPERADMINNAME, Config.SUPERADMINPASSWORD);
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard page should be displayed");
        driver.get(Config.SUPER_ADMIN_SETTING_URL);
        logoutAfterTest();
    }

    private void logoutAfterTest(){
        dashboardPage.clickOnUserButton();
        Assert.assertTrue(userPage.pageIsDisplayed(), "User page should be displayed");
        userPage.makeLogout();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
    }
}





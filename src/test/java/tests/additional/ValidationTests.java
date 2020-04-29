package tests.additional;

import common.Config;
import common.dataObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ValidationTests extends BaseTest {
    @Test(description = "C41588 - Admin Dashboard Validation", priority = 1)
    public void adminDashboardValidation(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
        loginPage.makeLogin(Config.USERNAME, Config.PASSWORD);
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard page should be displayed");
    /*    Assert.assertTrue(dashboardPage.isToggleTrafficDisplayed(), "Trafic should be displayed on map");
        Assert.assertTrue(dashboardPage.isToggleTrafficDisplayed(), "Trafic should be not visible on map");
        Assert.assertTrue(dashboardPage.isToggleRoutesDisplayed(), "Routes are displayed on map");
        Assert.assertTrue(dashboardPage.isToggleRoutesDisplayed(), "Routes are NOT displayed on map");
        Assert.assertTrue(dashboardPage.isToggleStopsDisplayed(), "Stops should be NOT displayed on map");
        Assert.assertTrue(dashboardPage.isToggleStopsDisplayed(), "Stops should be displayed on map");
        dashboardPage.clickOnToggleSidebarButton();
        Assert.assertTrue(dashboardPage.isSideBarNotPresent(), "Side Bar should be not displayed");
        dashboardPage.clickOnToggleSidebarButton();
        Assert.assertTrue(dashboardPage.isSideBarPresent(), "Side Bar should be displayed");*/
    }
}

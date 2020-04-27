package tests.admin;

import common.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginTests extends BaseTest {

    @Test(description = "C19010 Login with Valid Credentials", priority = 1)
    public void loginWithValidCredentials(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
        loginPage.makeLogin(Config.USERNAME, Config.PASSWORD);
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard page should be displayed");
        dashboardPage.clickOnUserButton();
        Assert.assertTrue(userPage.pageIsDisplayed(), "Viewer User page should be displayed");
        userPage.makeLogout();
    }

    @Test(description = "C19012 Login with Invalid User", priority = 2)
    public void loginWithInInvalidUser(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
        loginPage.makeLogin(Config.USERNAME, Config.PASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(), Config.BASE_URL, "User should stay on Login Page");
        Assert.assertTrue(loginPage.invalidMassageIsDisplayed(), "Invalid massage 'Invalid username or password. Please try again.' should be displayed");

    }
    @Test(description = "C19015 Logout", priority = 3)
    public void logout(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
        loginPage.makeLogin(Config.USERNAME, Config.PASSWORD);
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard page should be displayed");
        dashboardPage.clickOnUserButton();
        Assert.assertTrue(userPage.pageIsDisplayed(), "User page should be displayed");
        userPage.makeLogout();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
    }
}

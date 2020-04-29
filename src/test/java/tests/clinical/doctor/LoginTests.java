package tests.clinical.doctor;

import common.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.awt.*;

public class LoginTests extends BaseTest {

    @Test(description = "Login of the doctor with Valid Credentials", priority = 1)
    public void loginWithValidCredentials() throws AWTException {
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
        loginPage.handleLoginAlert();
        loginPage.makeLogin(Config.DOCTORNAME,Config.DOCTORPASS);
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "The Dashboard page isn't displayed");
        dashboardPage.makeLogout();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
    }

    @Test(description = "Login of the doctor with Invalid Credentials", priority = 2)
    public void loginWithInvalidCredentials() throws AWTException {
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
        loginPage.handleLoginAlert();
        loginPage.makeLogin(Config.USERNAME,Config.DOCTORPASS);
        Assert.assertEquals(driver.getCurrentUrl(), Config.BASE_URL, "The user doesn't stay on the Login Page");
        Assert.assertTrue(loginPage.errorMessageIsDisplayed(), "The 'Username or password is incorrect.' error message isn't displayed");
    }

}

package tests.administrative.hospitalAdmin;

import common.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.awt.*;

public class LoginTestsHospitalAdmin extends BaseTest {

    @Test(description = "Login of the Hospital Administrator with Valid Credentials", priority = 1)
    public void loginWithValidCredentials() throws AWTException {
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
        loginPage.handleLoginAlert();
        loginPage.makeLogin(Config.HOSPITALADMINNAME,Config.HOSPITALADMINPASS);
        Assert.assertTrue(dashboardPageHospitalAdmin.pageIsDisplayed(), "The Hospital Administrator Dashboard page isn't displayed");
        dashboardPageHospitalAdmin.makeLogout();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
    }

    @Test(description = "Login of the Hospital Administrator with Invalid Credentials", priority = 2)
    public void loginWithInvalidCredentials() throws AWTException {
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
        loginPage.handleLoginAlert();
        loginPage.makeLogin(Config.HOSPITALADMINNAME + "1",Config.HOSPITALADMINPASS + "1");
        Assert.assertEquals(driver.getCurrentUrl(), Config.BASE_URL, "The user doesn't stay on the Login Page");
        Assert.assertTrue(loginPage.errorMessageIsDisplayed(), "The 'Username or password is incorrect.' error message isn't displayed");
    }

}

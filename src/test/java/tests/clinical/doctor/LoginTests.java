package tests.clinical.doctor;

import common.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.awt.*;

public class LoginTests extends BaseTest {

    @Test(description = "Login of the Doctor with Valid Credentials", priority = 1)
    public void loginWithValidCredentials() throws AWTException {
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
        loginPage.handleLoginAlert();
        loginPage.makeLogin(Config.DOCTORNAME,Config.DOCTORPASS);
        Assert.assertTrue(dashboardPageDoctor.pageIsDisplayed(), "The Doctor Dashboard page isn't displayed");
        //dashboardPageDoctor.makeLogout();
        //Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
    }

    @Test(description = "Login of the Doctor with Invalid Credentials", priority = 2)
    public void loginWithInvalidCredentials() throws AWTException {
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
        loginPage.handleLoginAlert();
        loginPage.makeLogin(Config.DOCTORNAME + "1",Config.DOCTORPASS + "1");
        Assert.assertEquals(driver.getCurrentUrl(), Config.BASE_URL, "The user doesn't stay on the Login Page");
        Assert.assertTrue(loginPage.errorMessageIsDisplayed(), "The 'Username or password is incorrect.' error message isn't displayed");
    }

}

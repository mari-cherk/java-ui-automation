package tests.clinical.doctor;

import common.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.awt.event.KeyEvent;

public class LoginTests extends BaseTest {

    @Test(description = "Login of the doctor with Valid Credentials", priority = 1)
    public void loginWithValidCredentials() {
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        loginPage.makeLogin(Config.DOCTORNAME,Config.DOCTORPASS);
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "The Dashboard page isn't displayed");
        dashboardPage.makeLogout();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
    }

}

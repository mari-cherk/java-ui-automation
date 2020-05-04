package tests.clinical.doctor;

import common.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.awt.*;


public class LogoutTests extends BaseTest {

    @Test(description = "Logout of the Doctor using the config dropdown menu", priority = 1)
    public void logoutUsingConfigMenu() throws AWTException {

        driver.get(Config.BASE_URL);
        loginPage.handleLoginAlert();
        loginPage.makeLogin(Config.DOCTORNAME, Config.DOCTORPASS);
        dashboardPageDoctor.makeLogout();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "The Login page isn't displayed");
    }
}

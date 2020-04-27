package tests.admin;

import common.Config;
import common.Utils;
import common.dataObjects.AdminDataObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class AdminTests extends BaseTest {

    @Test(description = "C19017 Create new admin - Login", priority = 1)
    public void createNewAdminLogin(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
        loginPage.makeLogin(Config.NEW_ADMIN_USERNAME, Config.NEW_ADMIN_PASSWORD);
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard page should be displayed");
    }
}

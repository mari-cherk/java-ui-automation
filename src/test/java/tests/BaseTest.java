package tests;

import common.Config;
import common.Utils;
import common.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;
import workflows.*;

import java.awt.*;
import java.lang.reflect.*;

public class BaseTest {

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected UserPage userPage;
    protected AddNewUserPage addNewUserPage;
    protected AdminWorkflow adminWorkflow;
    protected ViewUserPage viewUserPage;
    protected AddNewBusPage addNewBusPage;
    protected AddRoutePage addRoutePage;
    protected AddSeasonPage addSeasonPage;
    protected AddStopPage addStopPage;
    protected AddSignPage addSignPage;

    public static WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setupTestRun(@Optional("Chrome") String browserName) {
        driver = new DriverFactory(browserName).getDriver();
        initPages();
    }
/*
    @BeforeMethod
    public void logout() {
        if (dashboardPage.isAlertPresent()) {
            dashboardPage.handleAlert();
        }
        if (dashboardPage.isServerInternalError()) {
            driver.get(Config.BASE_URL);
        }
        try {
            dashboardPage.isLoggedIn();
        } catch (org.openqa.selenium.WebDriverException e) {
            Utils.sleep(3000);
            dashboardPage.isLoggedIn();
        }
    }*/

    @AfterTest
    public void turnDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void initPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        userPage = new UserPage(driver);
        addNewUserPage = new AddNewUserPage(driver);
        adminWorkflow = new AdminWorkflow(driver);
        viewUserPage = new ViewUserPage(driver);
        addNewBusPage = new AddNewBusPage(driver);
        addRoutePage = new AddRoutePage(driver);
        addSeasonPage = new AddSeasonPage(driver);
        addStopPage = new AddStopPage(driver);
        addSignPage = new AddSignPage(driver);
    }
}

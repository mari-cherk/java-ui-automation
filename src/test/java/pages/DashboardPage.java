package pages;

import common.Config;
import common.PageElement;
import common.Utils;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DashboardPage extends BasePage {
    /*private static final PageElement dashboardButton = new PageElement(
            "DASHBOARD button",
            By.id("nav-dashboard-btn"),
            true);
    private static final PageElement fleetButton = new PageElement(
            "FLEET button",
            By.cssSelector("li.navbar-item.has-submenu:nth-child(2) > a"),
            true);
    private static final PageElement serviceButton = new PageElement(
            "SERVICE button",
            By.cssSelector("li.navbar-item.has-submenu:nth-child(3) > a"),
            true);
    private static final PageElement ridersButton = new PageElement(
            "RIDERS button",
            By.cssSelector("li.navbar-item.has-submenu:nth-child(4) > a"),
            true);
    private static final PageElement reportingButton = new PageElement(
            "REPORTING button",
            By.cssSelector("li.navbar-item.has-submenu:nth-child(5) > a"),
            true);
    private static final PageElement historyButton = new PageElement(
            "History button",
            By.id("nav-history-btn"),
            false);
    private static final PageElement reportsButton = new PageElement(
            "Reports Button",
            By.xpath("//*[@id=\"nav-reports-btn\"]"),
            false);
    private static final PageElement helpButton = new PageElement(
            "Help button",
            By.cssSelector("a.empty-link > i.material-icons"),
            true);
    private static final PageElement userButton = new PageElement(
            "User button",
            By.xpath("//i[contains(text(), 'person_outline')]"),
            true);
    private static final PageElement driverButton = new PageElement(
            "Driver button",
            By.xpath("//*[@id='nav-drivers-btn']"),
            true);
    private static final PageElement busesButton = new PageElement(
            "Buses button",
            By.id("nav-buses-btn"),
            true);
    private static final PageElement alertsButton = new PageElement(
            "Alerts button",
            By.xpath("//span[@id='nav-alerts-btn' and text()='Alerts']"),
            true);
    private static final PageElement messagesButton = new PageElement(
            "Messages button",
            By.xpath("//span[contains(@id,'nav') and text()='Messages']"),
            true);
    private static final PageElement routesButton = new PageElement(
            "Routes button",
            By.xpath("//*[@id=\"nav-routes-btn\"]"),
            true);
    private static final PageElement stopsButton = new PageElement(
            "Stops button",
            By.xpath("//*[@id=\"nav-stops-btn\"]"),
            false);
    private static final PageElement toggleStopVisibilityButton = new PageElement(
            "Toggle StopVisibilityButton button",
            By.xpath("//div[@tooltip='Toggle Stops visibility']"),
            false);
    private static final PageElement toggleTraficVisibilityButton = new PageElement(
            "Toggle Trafic Visibility button",
            By.xpath("//div[@tooltip='Toggle Traffic visibility']"),
            false);
    private static final PageElement toggleRoutesVisibilityButton = new PageElement(
            "Toggle Trafic Visibility button",
            By.xpath("//div[@tooltip='Toggle Routes visibility']"),
            false);
    private static final PageElement toggleSideBarButton = new PageElement(
            "Toggle Side Bar Button",
            By.xpath("//div[@tooltip='Toggle Sidebar']"),
            false);
    private static final PageElement zoomInButton = new PageElement(
            "Zoom In Button",
            By.xpath("//*[@id='map']//button[@title='Zoom in']"),
            false);
    private static final PageElement zoomOutButton = new PageElement(
            "Toggle StopVisibilityButton button",
            By.xpath("//*[@id='map']//button[@title='Zoom out']"),
            false);
    private static final PageElement firstBusOnTable = new PageElement(
            "First bus on table",
            By.xpath("//*[@id='BusIndexForm']/div[2]/div[2]/table/tbody/tr[1]/td[1]"),
            false);
    private static final PageElement blocksButton = new PageElement(
            "Blocks Button",
            By.id("nav-blocks-btn"),
            false);
    private static final PageElement dailySchedulesButton = new PageElement(
            "Daily Schedules Button",
            By.id("nav-daily_schedules-btn"),
            false);
    private final static PageElement announcementsButton = new PageElement(
            "Announcements button",
            By.xpath("//*[@id=\"nav-announcements-btn\"]"),
            true);
    private final static PageElement signsButton = new PageElement(
            "Signs button",
            By.xpath("//*[@id='container']/header/nav/ul[1]/li[4]/ul/li[2]"),
            false);
    private final static PageElement linksButton = new PageElement(
            "Links button",
            By.xpath("//*[@id='container']/header/nav/ul[1]/li[4]/ul/li[3]"),
            false);
    private final static PageElement userIcon = new PageElement(
            "User`s icon",
            By.cssSelector("#nav-user-container > a > i"),
            true);
    private final static PageElement saveChangesButton = new PageElement(
            "Save Changes Button",
            By.cssSelector("input#bus_submit"),
            true);
    private final static PageElement firstBusWithoutRoute = new PageElement(
            "First Bus Without Route",
            By.xpath("(//tr[.//td//div[@class='item' and text()='[None]']])[1]"),
            false);
    private final static PageElement firstDropdownWithoutRoute = new PageElement(
            "First Dropdown Without Route",
            By.xpath("(//div[contains(text(),'[None]')])[1]"),
            false);
    private final static PageElement map = new PageElement(
            "map",
            By.xpath(".//div[@data-value='0']/../../../../../td"),
            false);
    private static final PageElement allBussesSavedMessage = new PageElement(
            "All buses saved Message",
            By.xpath(".//div[contains(text(),'All buses successfully saved')]"),
            false);
    private static final PageElement configBusInTable = new PageElement(
            "Config Bus In Table",
            By.xpath("//td[contains(text(), 'Config_Bus')]"),
            false);
    private static final PageElement messagesErrorMessage = new PageElement(
            "Messages Error Message",
            By.xpath("//p[@class='modal-text']"),
            false);
    private static final PageElement maybeLaterButton = new PageElement(
            "Maybe Later Button",
            By.xpath("//a[contains(text(), 'Maybe later')]"),
            false);
    private static final PageElement sideBarPresent = new PageElement(
            "Side Bar Present",
            By.xpath("//div[@class='right column sidebar' and @style='display: flex;']"),
            false);
    private static final PageElement sideBarNotPresent = new PageElement(
            "Side Bar Present",
            By.xpath("//div[@class='right column sidebar' and @style='display: none;']"),
            false);
    private static final PageElement helpWindow = new PageElement(
            "Help Window",
            By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-resizable']"),
            false);
    private static final PageElement busInBusesSection = new PageElement(
            "busInBusesSection",
            By.xpath("//div[2]/table[1]/tbody[1]/tr[1]/td[1]"),
            false);
    private static final PageElement busOnMapLargeImage = new PageElement(
            "Bus On Map Large Image",
            By.cssSelector("div:nth-child(3) div:nth-child(1) div:nth-child(3) div:nth-child(115) > img:nth-child(1)"),
            false);
    private static final PageElement toggleTrafficVisibilityButton = new PageElement(
            "Toggle Traffic visibility button ",
            By.xpath("//div[contains(@class, 'map-control-button-traffic-layer')]"),
            false);

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void clickOnUserButton() {
        try {
            waitToBeClickable(userButton);
            click(userButton);
        } catch (org.openqa.selenium.TimeoutException e) {
            waitToBeClickable(userIcon);
            click(userIcon);
        }
    }

    public void clickOnDashboardButton() {
        waitToBeVisible(dashboardButton);
        click(dashboardButton);
    }

    public void clickOnFleetButton() {
        waitToBeClickable(fleetButton);
        click(fleetButton);
    }

    public void clickOnDriverButton() {
        clickOnFleetButton();
        waitToBeVisible(driverButton);
        click(driverButton);
    }

    public void clickOnAlertsButton() {
        clickOnFleetButton();
        waitToBeClickable(alertsButton);
        click(alertsButton);
    }

    public void clickOnMessagesButton() {
        clickOnFleetButton();
        waitToBeClickable(messagesButton);
        click(messagesButton);
    }

    public void clickOnServiceButtom() {
        waitToBeClickable(serviceButton);
        click(serviceButton);
    }

    public void clickOnRoutesButton() {
        clickOnServiceButtom();
        click(routesButton);
    }

    public void clickOnStopsButton() {
        clickOnServiceButtom();
        click(stopsButton);
    }

    public void clickOnBlocksButton() {
        clickOnServiceButtom();
        click(blocksButton);
    }

    public void clickOnDailyShedulesButton() {
        clickOnServiceButtom();
        click(dailySchedulesButton);
    }

    public void openServiceStopSections() {
        clickOnServiceButtom();
        waitToBeClickable(stopsButton);
        click(stopsButton);
    }

    public void clickOnRidersButton() {
        waitToBeClickable(ridersButton);
        click(ridersButton);
    }

    public void clickOnAnnouncementsButton() {
        clickOnRidersButton();
        waitToBeClickable(announcementsButton);
        click(announcementsButton);
    }

    public void clickOnSignsButton() {
        clickOnRidersButton();
        waitToBeClickable(signsButton);
        click(signsButton);
    }

    public void clickOnLinksButton() {
        clickOnRidersButton();
        waitToBeClickable(linksButton);
        click(linksButton);
    }

    public void clickOnBusesButton() {
        clickOnFleetButton();
        waitToBeClickable(busesButton);
        click(busesButton);
    }

    public void clickOnReportingButton() {
        waitToBeClickable(reportingButton);
        click(reportingButton);
    }

    public void clickOnHistoryButton() {
        clickOnReportingButton();
        waitToBeVisible(historyButton);
        click(historyButton);
    }

    public void clickOnReportsButton() {
        clickOnReportingButton();
        waitToBeVisible(reportsButton);
        click(reportsButton);
    }

    public boolean isMessageErrorMessageDisplayed() {
        waitToBeVisible(messagesErrorMessage);
        return isElementPresent(messagesErrorMessage);
    }

    public void clickOnMaybeLaterButton() {
        waitToBeVisible(maybeLaterButton);
        click(maybeLaterButton);
    }

    public boolean isBusOff(String busName) {
        String isBusOn = find(By.xpath("//td[contains(.,'" + busName.replace(" ", "") + "')]")).getAttribute("class").substring(0, 6);
        return isBusOn.equals("busOff");
    }

    public boolean isBusOn(String busName) {
        String isBusOn = find(By.xpath("//td[contains(.,'" + busName.replace(" ", "") + "')]")).getAttribute("class").substring(0, 5);
        return isBusOn.equals("busOn");
    }

    public void isLoggedIn() {
        UserPage userPage = new UserPage(driver);
        PageElement loggedUser = new PageElement(
                "User button",
                By.id("nav-user-btn"),
                false);
        if (isElementPresent(loggedUser)) {
            clickOnUserButton();
            userPage.makeLogout();
        }
    }

    public void changeScreenResolution(int width, int height) {
        Dimension dim = new Dimension(width, height);
        driver.manage().window().setSize(dim);
    }

    public void clickToToggleTrafficVisibilityButton() {
        waitToBeClickable(toggleTraficVisibilityButton);
        click(toggleTraficVisibilityButton);
    }

    public void clickOnToggleRoutesVisibilityButton() {
        waitToBeClickable(toggleRoutesVisibilityButton);
        click(toggleRoutesVisibilityButton);
    }

    public void clickToStopsVisibilityButton() {
        waitToBeClickable(toggleStopVisibilityButton);
        click(toggleStopVisibilityButton);
    }

    public void clickToToggleSidebarButton() {
        waitToBeClickable(toggleSideBarButton);
        click(toggleSideBarButton);
    }

    public boolean isPointDisplayedOnMap() {
        try {
            driver.findElement(By.xpath("(//img[@src='/map/img/stop_icon.png'])[1]"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public String getClassValueFromSidebar() {
        return driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div[1]")).getAttribute("class");
    }

    public boolean isSideBarDisplayed() {
        PageElement sideBar = new PageElement(
                "Side Bar",
                By.xpath("//div[@class='right column sidebar']")
        );
        String sideBarAttr = getAttribute(sideBar, "style");
        return sideBarAttr.contentEquals("display: none;");
    }

    public void clickOnHelpButton() {
        waitToBeClickable(helpButton);
        click(helpButton);
    }

    public boolean isHelpModalAppears() {
        try {
            driver.findElement(By.xpath("/html/body/div[2]/div[1]"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnFirstBusOnTable() {
        Utils.sleep(2000);
        waitToBeClickable(firstBusOnTable);
        click(firstBusOnTable);
    }

    public boolean isBusInformationModalAppears() {
        try {
            driver.findElement(By.xpath("//*[@id='map']/div/div/div[1]/div[3]/div/div[4]/div[2]/div[1]/div[4]"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEditButtonAppears() {
        try {
            driver.findElement(By.linkText("Edit button"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean checkDisplayedText(PageElement element, String expText) {
        boolean isVisible = false;
        try {
            if (getText(element).contains(expText)) {
                isVisible = true;
            } else {
                isVisible = false;
            }
        } catch (NoSuchElementException e) {
        }
        return isVisible;
    }

    public boolean isMenuItemsDisplayedCorrectly(String userRole, String menuSection) {
        switch (userRole) {
            case "User":
                switch (menuSection) {
                    case "DASHBOARD":
                        return checkDisplayedText(dashboardButton, "DASHBOARD");
                    case "FLEET":
                        waitToBeClickable(fleetButton);
                        click(fleetButton);
                        return checkDisplayedText(fleetButton, "FLEET")
                                && checkDisplayedText(alertsButton, "ALERTS")
                                && checkDisplayedText(busesButton, "BUSES")
                                && checkDisplayedText(driverButton, "DRIVERS")
                                && checkDisplayedText(messagesButton, "MESSAGES");
                    case "SERVICE":
                        waitToBeClickable(serviceButton);
                        click(serviceButton);
                        return checkDisplayedText(serviceButton, "SERVICE")
                                && checkDisplayedText(stopsButton, "STOPS")
                                && checkDisplayedText(routesButton, "ROUTES")
                                && checkDisplayedText(blocksButton, "BLOCKS")
                                && checkDisplayedText(dailySchedulesButton, "DAILY SCHEDULES");
                    case "REPORTING":
                        waitToBeClickable(reportingButton);
                        click(reportingButton);
                        return checkDisplayedText(reportingButton, "REPORTING")
                                && checkDisplayedText(historyButton, "HISTORY")
                                && checkDisplayedText(reportsButton, "REPORTS");
                    default:
                        return false;
                }
            case "Vendor":
                switch (menuSection) {
                    case "DASHBOARD":
                        return checkDisplayedText(dashboardButton, "DASHBOARD");
                    case "FLEET":
                        waitToBeClickable(fleetButton);
                        click(fleetButton);
                        return checkDisplayedText(fleetButton, "FLEET")
                                && checkDisplayedText(alertsButton, "ALERTS")
                                && checkDisplayedText(busesButton, "BUSES")
                                && checkDisplayedText(driverButton, "DRIVERS")
                                && checkDisplayedText(messagesButton, "MESSAGES");
                    case "SERVICE":
                        waitToBeClickable(serviceButton);
                        click(serviceButton);
                        return checkDisplayedText(serviceButton, "SERVICE")
                                && checkDisplayedText(stopsButton, "STOPS")
                                && checkDisplayedText(routesButton, "ROUTES")
                                && checkDisplayedText(blocksButton, "BLOCKS")
                                && checkDisplayedText(dailySchedulesButton, "DAILY SCHEDULES");
                    case "RIDERS":
                        waitToBeClickable(ridersButton);
                        click(ridersButton);
                        return checkDisplayedText(ridersButton, "RIDERS")
                                && checkDisplayedText(announcementsButton, "ANNOUNCEMENTS")
                                && checkDisplayedText(signsButton, "SIGNS")
                                && checkDisplayedText(linksButton, "LINKS");
                    case "REPORTING":
                        waitToBeClickable(reportingButton);
                        click(reportingButton);
                        return checkDisplayedText(reportingButton, "REPORTING")
                                && checkDisplayedText(historyButton, "HISTORY");
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    public String isAllBusesOn() {
        List<WebElement> allOnBuses = findAll(By.className("busOn"));
        return String.valueOf(allOnBuses.size());
    }

    public String isAllBusesOff() {
        List<WebElement> allOffBuses = findAll(By.className("busOff"));
        return String.valueOf(allOffBuses.size());
    }

    public String getRouteNameForFirstBus() {
        String routeName = find(By.cssSelector("td:nth-child(2) > div > div > div.selectize-input.items.has-options.full.has-items > div")).getText();
        return routeName;
    }

    public boolean isServerInternalError() {
        PageElement debagData = new PageElement(
                "Debag Data text area",
                By.id("debug-data"),
                false);
        return isElementPresent(debagData);
    }

    public String chooseBusWithoutRoute() {
        PageElement busNameWithNoRoute = new PageElement(
                "Bus Not HaveRoute",
                By.xpath("(//tr[.//td//div[@class='item' and text()='[None]']])[1]//td[1]"));
        String busName = getText(busNameWithNoRoute).replace(" ", "");
        String busNameWithNonRoute = getText(busNameWithNoRoute).replace(" ", "");
        return busNameWithNonRoute;
    }

    public boolean chooseBusConfigInTable() {
        waitToBeVisible(configBusInTable);
        return isElementPresent(configBusInTable);
    }

    public boolean isConfigWinterRouteSelected() {
        PageElement configBusDropdown = new PageElement(
                "Config Bus Dropdown",
                By.xpath("//td[contains(text(), 'Config_Bus')]/..//div[@class='item']"));
        waitToBeVisible(configBusDropdown);
        click(configBusDropdown);
        PageElement configRouteOption = new PageElement(
                "Config Winter Route Option",
                By.xpath("//td[contains(text(), 'Config_Bus')]/..//div[contains(text(), 'Config_Route')]"));
        waitToBeVisible(configRouteOption);
        click(configRouteOption);
        return getText(configBusDropdown).replace(" ", "").contentEquals("Config_Route");
    }

    public void selectNoneRouteForConfigBus() {
        PageElement configBusDropdown = new PageElement(
                "Config Bus Dropdown",
                By.xpath("//td[contains(text(), 'Config_Bus')]/..//div[@class='item']"));
        waitToBeVisible(configBusDropdown);
        click(configBusDropdown);
        PageElement noneOption = new PageElement(
                "None Option",
                By.xpath("//td[contains(text(), 'Config_Bus')]/..//div[contains(text(), '[None]')]"));
        waitToBeVisible(noneOption);
        click(noneOption);
    }

    public boolean isNoneRouteSelectedForConfigBus() {
        PageElement busDropdown = new PageElement(
                "Selected Bus Dropdown",
                By.xpath("//td[contains(text(), 'Config_Bus')]/..//div[contains(text(), '[None]') and @class='item']"));
        return isElementPresent(busDropdown);
    }

    public String selectRouteForBusWithoutRoute() {
        PageElement busNotHaveRoute = new PageElement(
                "Bus Not HaveRoute",
                By.xpath("(//tr[.//td//div[@class='item' and text()='[None]']])[1]"));
        String busID = getAttribute(busNotHaveRoute, "id");
        PageElement busNameNotHaveRoute = new PageElement(
                "Bus Not HaveRoute",
                By.xpath("(//tr[.//td//div[@class='item' and text()='[None]']])[1]//td[1]"));
        String busName = getText(busNameNotHaveRoute).replace(" ", "");
        Config.SELECTED_BUS_NAME = busName;
        PageElement notHaveRouteDropdwn = new PageElement(
                "Not Have Route Dropdwn",
                By.xpath("//div[@class='container-fluid dashboard has-preloader-faded']//tr[@id='" + busID + "']/td[2]//*[@class='item']"));
        click(notHaveRouteDropdwn);
        PageElement firstOptionInDropdwn = new PageElement(
                "First Option In Dropdwn",
                By.xpath("(//tr[@id='" + busID + "']/td[2]//div[@class='option'])[1]"));
        click(firstOptionInDropdwn);
        String selectedRoute = getText(notHaveRouteDropdwn);
        return selectedRoute;
    }

    public boolean isSelectedRouteNameDisplayed(String busName, String routeName) {
        PageElement busDropdown = new PageElement(
                "Selected Bus Dropdown",
                By.xpath("//td[contains(text(), '" + busName + "')]/..//div[contains(text(), '" + routeName + "') and @class='item']"));
        return isElementPresent(busDropdown);
    }

    public String selectRouteNoneForBusWithoutRoute() {
        PageElement busNotHaveRoute = new PageElement(
                "Bus Not HaveRoute",
                By.xpath("(//tr[.//td//div[@class='item' and text()='[None]']])[1]"));
        String busID = getAttribute(busNotHaveRoute, "id");
        PageElement notHaveRouteDropdwn = new PageElement(
                "Not Have Route Dropdwn",
                By.xpath("//tr[@id='" + busID + "']/td[2]//div[@class='item']"));
        click(notHaveRouteDropdwn);
        PageElement optionNone = new PageElement(
                "Option None",
                By.xpath("(//tr[@id='" + busID + "']/td[2]//div[text()='[None]'])[1]"));
        click(optionNone);
        String optionNoneText = getText(notHaveRouteDropdwn).replace(" ", "");
        return optionNoneText;
    }

    public String selectRouteForFirstBus() {

        PageElement routeDrpdwn = new PageElement(
                "routeDrpdwn",
                By.xpath("(//*[@class='input select'])[1]"));

        click(routeDrpdwn);

        PageElement routeOption = new PageElement(
                "routeOption",
                By.xpath("(//*[@class='input select'])[1]//*[@class='option'][1]"));
        click(routeOption);

        return getText(routeDrpdwn).replace("[", "").replace("]", "");
    }

    public boolean isNoneRouteSelectedForBus(String busName, String routeName) {
        PageElement busDropdown = new PageElement(
                "Selected Bus Dropdown",
                By.xpath("//td[contains(text(), '" + busName + "')]/..//div[contains(text(), '" + routeName + "') and @class='item']"));
        return isElementPresent(busDropdown);
    }

    public void clickSaveChangesButton() {
        waitToBeVisible(saveChangesButton);
        click(saveChangesButton);
    }

    public boolean isAllBusSavedMessage() {
        waitToBeVisible(allBussesSavedMessage);
        return isElementPresent(allBussesSavedMessage);
    }

    public boolean isDriverNameDisplayedInBusInformationPopup(String busName) {
        waitToBeVisible(map);
        PageElement busNameInTable = new PageElement(
                "Bus name in table",
                By.xpath("//td[contains(text(), '" + busName + "')]"));
        waitToBeClickable(busNameInTable);
        Utils.sleep(500);
        click(busNameInTable);
        PageElement busInformationForm = new PageElement(
                "Bus information form",
                By.xpath("//div[@class='gm-style-iw-d']//div[contains(text(),'Driver')]"));
        waitToBeVisible(busInformationForm);
        return isElementPresent(busInformationForm);
    }

    public boolean isDriverNameNotDisplayed(String busName) {
        waitToBeVisible(map);
        PageElement busNameInTable = new PageElement(
                "Bus name in table",
                By.xpath("//td[contains(text(), '" + busName + "') and @class='busOff bus-id footable-first-visible']"));
        waitToBeVisible(busNameInTable);
        click(busNameInTable);
        click(busNameInTable);
        PageElement busInformationForm = new PageElement(
                "Bus information form",
                By.xpath("//div[contains(h2,'" + busName + "')]"));
        waitToBeVisible(busInformationForm);
        return !getText(busInformationForm).contains("Driver:");
    }

    public boolean isFleetMenuAllElementsDisplayed() {
        if (isElementPresent(alertsButton) && isElementPresent(busesButton) && isElementPresent(driverButton) && isElementPresent(messagesButton)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isToggleTrafficDisplayed() {
        waitToBeVisible(map);
        takeScrenshotByElement("Toggle Traffic before");
        click(toggleTraficVisibilityButton);
        takeScrenshotByElement("Toggle Traffic after");
        return screenshotCompare("Toggle Traffic before", "Toggle Traffic after", "Toggle Traffic Diff");
    }

    public boolean isToggleRoutesDisplayed() {
        waitToBeVisible(map);
        takeScrenshotByElement("Toggle Route before");
        click(toggleRoutesVisibilityButton);
        takeScrenshotByElement("Toggle Route after");
        return screenshotCompare("Toggle Route before", "Toggle Route after", "Toggle Route Diff");
    }

    public boolean isToggleStopsDisplayed() {
        waitToBeVisible(map);
        takeScrenshotByElement("Toggle Stops before");
        click(toggleStopVisibilityButton);
        takeScrenshotByElement("Toggle Stops after");
        return screenshotCompare("Toggle Stops before", "Toggle Stops after", "Toggle Stops Diff");
    }

    public void clickOnToggleSidebarButton() {
        click(toggleSideBarButton);
    }

    public boolean isSideBarPresent() {
        return isElementPresent(sideBarPresent);
    }

    public boolean isSideBarNotPresent() {
        return isElementPresent(sideBarNotPresent);
    }

    public boolean isMapZoomedOut() {
        waitToBeVisible(map);
        takeScrenshotByElement("Map Zoom Out before");
        click(zoomOutButton);
        takeScrenshotByElement("Map Zoom Out after");
        return screenshotCompare("Map Zoom Out before", "Map Zoom Out after", "Map Zoom Out Diff");
    }

    public boolean isMapZoomedIn() {
        waitToBeVisible(map);
        takeScrenshotByElement("Map Zoom In before");
        click(zoomInButton);
        takeScrenshotByElement("Map Zoom In after");
        return screenshotCompare("Map Zoom In before", "Map Zoom In after", "Map Zoom In Diff");
    }

    public void helpButtonClick() {
        click(helpButton);
    }

    public boolean isHelpWindowDisplayed() {
        return isElementPresent(helpWindow);
    }

    public void clickOnBusInMap() {
        waitForPageLoaded();
        waitToBeVisible(busInBusesSection);
        click(busInBusesSection);
    }

    public boolean isTrafficVisible() {
        String linkBeforeClick = driver.findElement(By.xpath("//*[@id='map']/div/div/div[1]/div[1]/div[5]/div/div[1]/img")).getAttribute("src");
        waitToBeClickable(toggleTrafficVisibilityButton);
        click(toggleTrafficVisibilityButton);
        String linkAfterClick = driver.findElement(By.xpath("//*[@id='map']/div/div/div[1]/div[1]/div[5]/div/div[1]/img")).getAttribute("src");
        if (linkAfterClick != linkBeforeClick) {
            return false;
        } else {
            return true;
        }
    }

    public String checkStatusCheckbox() {
        PageElement firstCheckbox = new PageElement(
                "First Bus In Table",
                By.xpath("(//div[@class='input checkbox']//input[@type='checkbox'])[1]"));
        if (!isChecked(firstCheckbox)) {
            check(firstCheckbox);
            clickSaveChangesButton();
        }
        PageElement firstBusInTable = new PageElement(
                "First Bus In Table",
                By.xpath("(//table[1]/tbody[1]/tr[1]/td[1])[last()]"));
        return getText(firstBusInTable).replace(" ", "");
    }

    public String uncheckStatusCheckbox() {
        WebElement statusCheckox = find(By.xpath("(//input[@type='checkbox' and @class='vis-toggle'])[1]"));
        if (statusCheckox.isSelected()) {
            statusCheckox.click();
        }
        PageElement firstBusInTable = new PageElement(
                "First Bus In Table",
                By.xpath("//tbody//tr[1]//td[@class='busOn bus-id footable-first-visible']"));
        clickSaveChangesButton();
        return getText(firstBusInTable).replace(" ", "");
    }

    public boolean isCheckSelectedBusStatusIsActive() {
        PageElement selectedBusInTableCheckbox = new PageElement(
                "Selected Bus In Table",
                By.xpath("//td[contains(text(), '" + Config.BUS_NAME_STATUS_ACTIVE + "')]/..//*[@type='checkbox']"));
        return isChecked(selectedBusInTableCheckbox);
    }

    public boolean isCheckSelectedBusStatusIsInactive() {
        PageElement selectedBusInTableCheckbox = new PageElement(
                "Selected Bus In Table",
                By.xpath("//td[contains(text(), '" + Config.BUS_NAME_STATUS_INACTIVE + "')]/..//*[@type='checkbox']"));
        return isUnchecked(selectedBusInTableCheckbox);
    }

    public String getDriverNameForFirstBus() {
        waitForPageLoaded();
        waitToBeVisible(saveChangesButton);
        PageElement hardBusInTable = new PageElement(
                "Hard Bus In Table",
                By.xpath("//td[contains(text(),'Config_Bus')]"));
        Config.BUS_NAME = getText(hardBusInTable).replace(" ", "");
        waitForPageLoaded();
        click(hardBusInTable);
        waitForPageLoaded();
        PageElement driverNameForFirstBusInTable = new PageElement(
                "Driver Name First Bus In Table",
                By.xpath("//div[contains(text(),'Driver:')]"));
        String driverName = getText(driverNameForFirstBusInTable).replace(" ", "").substring(7);
        return driverName;
    }

    public boolean isRouteChangedForBus(String busName, String routeName) {
        PageElement busNameInTable = new PageElement(
                "Bus name in table",
                By.xpath("//td[contains(text(), '" + busName + "')]/..//*[contains(text(), '" + routeName + "')]"));

        return isElementPresent(busNameInTable);
    }

    public void selectRouteForBusUsingNames(String busName, String routeName) {

        PageElement routeDrpdwn = new PageElement(
                "routeDrpdwn",
                By.xpath("//td[contains(text(),'" + busName + "')]/..//*[@class='input select']"));
        click(routeDrpdwn);
        PageElement routeOption = new PageElement(
                "routeOption",
                By.xpath("//td[contains(text(),'" + busName + "')]/..//*[@class='option' and contains(text(),'" + routeName + "')]"));
        click(routeOption);
    }
    */

    public static final PageElement configButton = new PageElement(
            "Config Button",
            By.xpath("//span[@class='mega-octicon octicon-gear']"),
            true);

    public static final PageElement logoutButton = new PageElement(
            "Logout Button",
            By.className("logout"),
            false);

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void clickConfigButton(){
        waitToBeVisible(configButton);
        click(configButton);
    }

    public void clickLogoutButton(){
        click(logoutButton);
    }

    public void makeLogout(){
        clickConfigButton();
        clickLogoutButton();
    }
}
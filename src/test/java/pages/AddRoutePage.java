package pages;

import common.PageElement;
import common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddRoutePage extends BasePage {
    private static final PageElement listSeasonsButton = new PageElement(
            "List Seasons button",
            By.linkText("List Seasons"),
            false);
    private static final PageElement submitButton = new PageElement(
            "Submit button",
            By.className("submit"),
            true);
    private static final PageElement dropdownStop = new PageElement(
            "Dropdown Stop",
            By.id("allStops"),
            false);
    private static final PageElement privateName = new PageElement(
            "Private Name field",
            By.id("RouteName"),
            true);
    private static final PageElement displayName = new PageElement(
            "Display Name field",
            By.id("RouteDisplayName"),
            true);
    private static final PageElement abbreviation = new PageElement(
            "Abbreviation field",
            By.id("RouteShortName"),
            true);
    private static final PageElement pronunciation = new PageElement(
            "Pronunciation field",
            By.id("RoutePhonetic"),
            true);
    private static final PageElement routeColor = new PageElement(
            "Color field",
            By.id("RouteColor"),
            true);
    private static final PageElement routeNotes = new PageElement(
            "Notes field",
            By.id("RouteNotes"),
            true);
    private static final PageElement checkboxMonday = new PageElement(
            "Monday checkbox",
            By.id("RouteMonday"),
            true);
    private static final PageElement checkboxTuesday = new PageElement(
            "Tuesday checkbox",
            By.id("RouteTuesday"),
            true);
    private static final PageElement checkboxWednesday = new PageElement(
            "Wednesday checkbox",
            By.id("RouteWednesday"),
            true);
    private static final PageElement checkboxThursday = new PageElement(
            "Thursday checkbox",
            By.id("RouteThursday"),
            true);
    private static final PageElement checkboxFriday = new PageElement(
            "Friday checkbox",
            By.id("RouteFriday"),
            true);
    private static final PageElement checkboxSaturday = new PageElement(
            "Saturday checkbox",
            By.id("RouteSaturday"),
            true);
    private static final PageElement checkboxSunday = new PageElement(
            "Sunday checkbox",
            By.id("RouteSunday"),
            true);
    private static final PageElement startDate = new PageElement(
            "Start Date field",
            By.id("RouteStartDate"),
            true);
    private static final PageElement endDate = new PageElement(
            "End Date field",
            By.id("RouteEndDate"),
            true);
    private static final PageElement startTime = new PageElement(
            "Start Time field",
            By.id("RouteStartTime"),
            true);
    private static final PageElement endTime = new PageElement(
            "End Time field",
            By.id("RouteEndTime"),
            true);
    private static final PageElement addStopButton = new PageElement(
            "Add Stop button",
            By.xpath("//*[@id='AllStopsContainer']/button"),
            true);
    private static final PageElement nextMonthButton = new PageElement(
            "Next Month button",
            By.xpath("//div[contains(@class, 'open')]//span[contains(@class, 'flatpickr-next-month')]"),
            false);
    private static final PageElement arrowUpButton = new PageElement(
            "Arrow Up button",
            By.xpath("//div[contains(@class, 'open')]//input[contains(@class, 'numInput flatpickr-hour')]/..//following-sibling::span[contains(@class, 'arrowUp')]"),
            false);
    private static final PageElement arrowDownButton = new PageElement(
            "Arrow Down button",
            By.xpath("//div[contains(@class, 'open')]//input[contains(@class, 'numInput flatpickr-hour')]/..//following-sibling::span[contains(@class, 'arrowDown')]"),
            false);
    private static final PageElement timeArea = new PageElement(
            "Time Area selector",
            By.xpath("//div[contains(@class, 'open')]//input[contains(@class, 'numInput flatpickr-hour')]"),
            false);
    public static final PageElement endRedPoint = new PageElement(
            "End Red point on map",
            By.xpath("//div[contains(@style, 'z-index: 1; position: absolute; left: 50%; top: 50%;')]//img[contains(@src,'/admin/img/marker-icon-red.png')]"),
            false);
    public static final PageElement startGreenPoint = new PageElement(
            "Start Green point on map",
            By.xpath("//div[contains(@style, 'z-index: 1; position: absolute; left: 50%; top: 50%;')]//img[contains(@src,'/admin/img/marker-icon-green.png')]"),
            false);
    private static final PageElement undoButton = new PageElement(
            "Undo button on map",
            By.xpath("//div[contains(@class,'rc-controls')]/div[contains(@class,'rc-control-undo')]"),
            true);
    public static final PageElement clearButton = new PageElement(
            "Clear button on map",
            By.xpath("//div[contains(@class,'rc-controls')]/div[contains(@class,'rc-control-clear')]"),
            true);
    public static final PageElement editButton = new PageElement(
            "Edit button on map",
            By.xpath("(//div[contains(@class,'rc-controls')]/div[contains(@class,'rc-control-edit')])[1]"),
            true);
    public static final PageElement doneButton = new PageElement(
            "Done button on map",
            By.xpath("(//div[contains(@class,'rc-controls')]/div[contains(@class,'rc-control-edit')])[last()]"),
            false);
    public static final PageElement editablePoint = new PageElement(
            "Editable point on map",
            By.xpath("(//*[@class='route-creator']/div/div/div[1]/div[3]/div/div/div/div/div)[5]"),
            false);
    public static final PageElement autoDrawRouteButton = new PageElement(
            "Auto-Draw Route button",
            By.xpath("//div[contains(@class,'rc-controls')]/div[contains(@class,'rc-control-autodraw')]"),
            true);
    public static final PageElement endTimeText = new PageElement(
            "End Time Text",
            By.xpath(".//label[contains(text(),'End Time')]"),
            true);
    public static final PageElement stopsDropdown = new PageElement(
            "Stops Dropdown",
            By.id("allStops"),
            true);
    public static final PageElement startDateNextMonthArrow = new PageElement(
            "Start date next month Arrow",
            By.xpath("(//span[@class='flatpickr-next-month'])[1]"),
            false);
    public static final PageElement endDateNextMonthArrow = new PageElement(
            "End date next month Arrow",
            By.xpath("(//span[@class='flatpickr-next-month'])[2]"),
            false);
    public static final PageElement arrowUpStartTimeButton = new PageElement(
            "Arrow Up Start Time button",
            By.xpath("//div[contains(@class, 'open')]//input[contains(@class, 'numInput flatpickr-hour')]/..//following-sibling::span[contains(@class, 'arrowUp')]"),
            false);


    public AddRoutePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void clickOnListSeasonsButton() {
        waitToBeClickable(listSeasonsButton);
        click(listSeasonsButton);
    }

    public void clickSubmitButton() {
        try {
            waitToBeClickable(submitButton);
            click(submitButton);
        } catch (org.openqa.selenium.UnhandledAlertException e) {
            driver.switchTo().alert().accept();
            click(submitButton);
        }
    }

    public void selectFromDropdownStop() {
        Select listDropdown = new Select(driver.findElement(By.id("allStops")));
        List<WebElement> list = listDropdown.getOptions();
        listDropdown.selectByIndex(Utils.getRandomInteger(list.size()));
    }

    public void fillPrivateNameField(String strPrivateName) {
        enterText(privateName, strPrivateName);
    }

    public void fillDisplayNameField(String strDisplayName) {
        enterText(displayName, strDisplayName);
    }

    public void fillAbbreviationField(String strAbbreviation) {
        enterText(abbreviation, strAbbreviation);
    }

    public void fillPronunciationField(String strPronunciation) {
        enterText(pronunciation, strPronunciation);
    }

    public void fillColorField(String strColor) {
        enterText(routeColor, strColor);
    }

    public void fillNotesField(String strNotes) {
        enterText(routeNotes, strNotes);
    }

    public void selectDayCheckbox(String strDay) {
        PageElement selectedDay = new PageElement(
                "Selected Day checkbox",
                By.id("Route" + strDay),
                false);
        click(selectedDay);
    }

    public void selectStartDate(String strStartDate) {
        click(startDate);
        PageElement selectDate = new PageElement(
                "Select Start Date from pop up",
                By.xpath("//div[contains(@class, 'open')]//span[@aria-label='" + strStartDate + "']"),
                false);
        click(selectDate);
    }

    public void selectEndDate(String strEndDate) {
        click(endDate);
        waitToBeClickable(nextMonthButton);
        click(nextMonthButton);

        System.out.println(strEndDate);

        PageElement selectDate = new PageElement(
                "Select End Date from pop up",
                By.xpath("//div[contains(@class, 'open')]//span[@aria-label='" + strEndDate + "']"),
                false);
        waitToBeClickable(selectDate);
        click(selectDate);
    }

    public void selectStartTime(int intStartTime) {
        click(startTime);
        for (int i = 0; i < intStartTime; i++) {
            waitToBeClickable(timeArea);
            click(timeArea);
            waitToBeClickable(arrowDownButton);
            click(arrowDownButton);
        }
    }

    public void selectEndTime(int intEndTime) {
        try {
            click(endTime);
            for (int i = 1; i < intEndTime; i++) {
                waitToBeClickable(timeArea);
                click(timeArea);
                waitToBeVisible(arrowUpButton);
                click(arrowUpButton);
            }
        } catch (org.openqa.selenium.UnhandledAlertException e) {
            driver.switchTo().alert().accept();
        }
        waitToBeClickable(endTimeText);
        click(endTimeText);
    }

    public void selectSeason(String seasonName) {
        Select season = new Select(driver.findElement(By.id("RouteSeasonId")));
        season.selectByVisibleText(seasonName);
    }

    public void selectStops(int stopsCount) {
        try {
            for (int i = 1; i <= stopsCount; i++) {
                Select stop = new Select(driver.findElement(By.id("allStops")));
                List<WebElement> dropdown = stop.getOptions();
                stop.selectByIndex(Utils.getRandomInteger(dropdown.size()));
                click(addStopButton);
            }
            Utils.sleep(1000);
        } catch (org.openqa.selenium.UnhandledAlertException e1) {
            try {
                driver.switchTo().alert().accept();
                Select stop = new Select(driver.findElement(By.id("allStops")));
                List<WebElement> dropdown = stop.getOptions();
                stop.selectByIndex(Utils.getRandomInteger(dropdown.size()));
                click(addStopButton);
            } catch (org.openqa.selenium.UnhandledAlertException e2) {
                Select stop = new Select(driver.findElement(By.id("allStops")));
                List<WebElement> dropdown = stop.getOptions();
                stop.selectByIndex(Utils.getRandomInteger(dropdown.size()));
                click(addStopButton);
            }
        }
    }

    public void clickPointOnMap(int X, int Y) {
        WebElement map = driver.findElement(By.className("route-creator"));
        Actions action = new Actions(driver);
        Utils.sleep(1000);
        action.moveToElement(map, X, Y).click().build().perform();
    }

    public void dragAndDropEditablePoint() {
        WebElement editablePointOnMap = driver.findElement(By.xpath("//div[contains(@style, \"position: absolute; left: 0px; top: 0px; z-index: 0\")]//div[contains(@style, \"display: block; width: 11px; height: 11px; cursor: pointer; touch-action: none; position: absolute\")][5]"));
        WebElement moveTo = driver.findElement(By.xpath("//*[@class='route-creator']/div/div/div[7]/button[4]"));
        Actions actions = new Actions(driver);
        Action dradAndDrop = actions.clickAndHold(editablePointOnMap)
                .moveToElement(moveTo)
                .release(moveTo)
                .build();

        dradAndDrop.perform();
    }

    public void clickOnUndoButton() {
        Utils.sleep(1000);
        click(undoButton);
    }

    public boolean isStartGreenPointDisplayed() {
        waitToBeClickable(startGreenPoint);
        return isElementPresent(startGreenPoint);
    }

    public boolean isEndRedPointDisplayed() {
        waitToBeClickable(endRedPoint);
        return isElementPresent(endRedPoint);
    }

    public void clickOnClearButton() {
        waitToBeClickable(clearButton);
        click(clearButton);
    }

    public void clickOnEditButton() {
        waitToBeClickable(editButton);
        click(editButton);
    }

    public void clickOnDoneButton() {
        waitToBeClickable(doneButton);
        click(doneButton);
    }

    public void clickOnAutoRouteButton() {
        waitToBeClickable(autoDrawRouteButton);
        click(autoDrawRouteButton);
    }

    public void selectDefaultStops() {
        String configStopFirst = "Config_Stop_1";
        String configStopSecond = "Config_Stop_2";

        waitToBeClickable(stopsDropdown);
        click(stopsDropdown);
        PageElement stopNameFirst = new PageElement(
                "Stop name from Stops dropdown",
                By.xpath(".//select[@id='allStops']/option[contains(text(),'" + configStopFirst + "')]"),
                false
        );
        waitToBeClickable(stopNameFirst);
        click(stopNameFirst);
        waitToBeClickable(addStopButton);
        click(addStopButton);

        waitToBeClickable(stopsDropdown);
        click(stopsDropdown);
        PageElement stopNameSecond = new PageElement(
                "Stop name from Stops dropdown",
                By.xpath(".//select[@id='allStops']/option[contains(text(),'" + configStopSecond + "')]"),
                false
        );
        waitToBeClickable(stopNameSecond);
        click(stopNameSecond);
        waitToBeClickable(addStopButton);
        click(addStopButton);
    }

    public boolean isEditablePointDisplayed() {
        waitToBeClickable(editablePoint);
        return isElementPresent(editablePoint);
    }

    public void selectStartDateWithFutureDate(String strStartDate) {
        click(startDate);
        PageElement selectDate = new PageElement(
                "Select Start Date from pop up",
                By.xpath("//div[contains(@class, 'open')]//span[@aria-label='" + strStartDate + "']"),
                false);
        while (!isElementPresent(selectDate)) {
            click(startDateNextMonthArrow);
        }
        click(selectDate);
    }

    public void selectEndDateWithFutureDate(String strEndDate) {
        click(endDate);
        PageElement selectDate = new PageElement(
                "Select End Date from pop up",
                By.xpath("//div[contains(@class, 'open')]//span[@aria-label='" + strEndDate + "']"),
                false);
        while (!isElementPresent(selectDate)) {
            click(endDateNextMonthArrow);
        }
        click(selectDate);
    }

    public void selectStartFutureTime(int intStartTime) {
        click(privateName);
        click(startTime);
        for (int i = 0; i < intStartTime; i++) {
            waitToBeClickable(timeArea);
            click(timeArea);
            waitToBeClickable(arrowUpStartTimeButton);
            click(arrowUpStartTimeButton);
        }
        Utils.sleep(1000);
    }

    public void clickSubmitButton(boolean handleAlert) {
        waitToBeClickable(submitButton);
        click(submitButton);
        Utils.sleep(2000);
    }
}

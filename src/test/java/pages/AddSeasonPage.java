package pages;

import common.Config;
import common.PageElement;
import common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class AddSeasonPage extends BasePage {
    private static final PageElement listSeasonButton = new PageElement(
            "List Season button",
            By.linkText("List Seasons"),
            false);
    private static final PageElement seasonNameField = new PageElement(
            "Season Name Field",
            By.id("SeasonName"),
            true);
    private static final PageElement startDate = new PageElement(
            "Start Date field",
            By.id("SeasonStart"),
            true);
    private static final PageElement endDate = new PageElement(
            "End Date field",
            By.id("SeasonEnd"),
            true);
    private static final PageElement submitButton = new PageElement(
            "Submit button",
            By.className("submit"),
            true);
    private static final PageElement nextMonthButton = new PageElement(
            "Next Month button",
            By.xpath("//div[contains(@class, 'open')]//span[contains(@class, 'flatpickr-next-month')]"),
            false);
    private static final PageElement prevMonthButton = new PageElement(
            "Next Month button",
            By.xpath("//div[contains(@class, 'open')]//span[contains(@class, 'flatpickr-prev-month')]"),
            false);

    public AddSeasonPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    public void clickOnListSeasonButton(){
        waitToBeClickable(listSeasonButton);
        click(listSeasonButton);
    }

    public void fillNameField(){
        String strSeasonName = "Season Name " + Utils.getRandomInteger(999);
        Config.SEASON_NAME = strSeasonName;
        enterText(seasonNameField, strSeasonName);
    }

    public void selectStartDate(String strStartDate){
        click(startDate);

        switch (strStartDate){
            case "yesterday":
                strStartDate = Utils.getMonth() + " " + Utils.getYesterdayDay() + ", " + Utils.getYear();
                break;
            case "today":
                strStartDate = Utils.getMonth() + " " + Utils.getDay() + ", " + Utils.getYear();
                break;
            case "3MonthBefore":
                strStartDate = Utils.getPreviousThirdMonth() + " " + Utils.getStartDay() + ", ";
                for (int i = 0; i < 3; i++) {
                    waitToBeClickable(prevMonthButton);
                    click(prevMonthButton);
                }
                break;
            case "3MonthLater":
                strStartDate = Utils.getNextThirdMonth() + " " + Utils.getStartDay() + ", ";
                for (int i = 0; i < 3; i++) {
                    waitToBeClickable(nextMonthButton);
                    click(nextMonthButton);
                }
                break;
        }

        PageElement selectDate = new PageElement(
                "Select Start Date from pop up",
                By.xpath("//div[contains(@class, 'open')]//span[contains(@aria-label,'" + strStartDate + "')]"),
                false);
        waitToBeClickable(selectDate);
        click(selectDate);
    }

    public void selectEndDate(String strEndDate){
        click(endDate);
        switch (strEndDate){
            case "3MonthLater":
                strEndDate = Utils.getNextThirdMonth() + " " + Utils.getStartDay() + ", ";
                for (int i = 0; i < 3; i++) {
                    waitToBeClickable(nextMonthButton);
                    click(nextMonthButton);
                }
                break;
            case "3MonthBefore":
                strEndDate = Utils.getPreviousThirdMonth() + " " + Utils.getStartDay() + ", ";
                for (int i = 0; i < 3; i++) {
                    waitToBeClickable(prevMonthButton);
                    click(prevMonthButton);
                }
                break;
            case "yesterday":
                strEndDate = Utils.getMonth() + " " + Utils.getYesterdayDay() + ", " + Utils.getYear();
                break;
            case "today":
                strEndDate = Utils.getMonth() + " " + Utils.getDay() + ", " + Utils.getYear();
                break;
        }
        PageElement selectDate = new PageElement(
                "Select End Date from pop up",
                By.xpath("//div[contains(@class, 'open')]//span[contains(@aria-label, '" + strEndDate + "')]"),
                false);
        waitToBeClickable(selectDate);
        click(selectDate);
    }

    public void clickOnSubmitButton(){
        waitToBeClickable(submitButton);
        click(submitButton);
    }

    public void createNewSeason(){
        fillNameField();
        selectStartDate("today");
        selectEndDate("3MonthLater");
        clickOnSubmitButton();
    }

    public void createSeason(String seasonName, String strStartDate, String strEndDate){
        enterText(seasonNameField, seasonName);
        selectStartDate(strStartDate);
        selectEndDate(strEndDate);
        clickOnSubmitButton();
    }

    public void createSeason(String seasonName, String strStartDate, String strEndDate, boolean handleAlert) throws AWTException {
        enterText(seasonNameField, seasonName);
        selectStartDate(strStartDate);
        selectEndDate(strEndDate);
        if (handleAlert){
            handleAlert();
            clickOnSubmitButton();
        }
    }
}
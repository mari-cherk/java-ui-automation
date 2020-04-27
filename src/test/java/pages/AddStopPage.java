package pages;

import common.PageElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class AddStopPage extends BasePage {
    private static final PageElement saveButton = new PageElement(
            "Save button",
            By.xpath(".//input[@value='Save']"),
            true);
    private static final PageElement cancelButton = new PageElement(
            "Cancel button",
            By.linkText("Cancel"),
            true);
    private static final PageElement nameField = new PageElement(
            "Name field",
            By.id("StopName"),
            true);
    private static final PageElement pronunciationField = new PageElement(
            "Pronunciation field",
            By.id("StopPhonetic"),
            true);
    private static final PageElement latitudeField = new PageElement(
            "Latitude field",
            By.id("StopLatitude"),
            true);
    private static final PageElement longitudeField = new PageElement(
            "Longitude field",
            By.id("StopLongitude"),
            true);
    private static final PageElement descriptionField = new PageElement(
            "Description field",
            By.id("StopDescription"),
            true);
    private static final PageElement visibleCheckbox = new PageElement(
            "Stop Visible checkbox",
            By.id("StopVisible"),
            true);
    private static final PageElement buddySelectField = new PageElement(
            "Buddy Select Field",
            By.id("StopBuddy-selectized"),
            true);
    private static final PageElement radiusField = new PageElement(
            "Radius Field",
            By.id("StopRadius"),
            true);
    private static final PageElement approachHeadingField = new PageElement(
            "Approach Heating Filed",
            By.id("StopHeading"),
            true);
    private static final PageElement approachHeadingIncrementButton = new PageElement(
            "Approach Heating Increment Button",
            By.id("StopHeading"),
            true);

    public AddStopPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    private void fillInStopNameField(String strStopName){
        enterText(nameField, strStopName);
    }

    private void fillInPronunciationNameField(String strPronunciationName){
        enterText(pronunciationField, strPronunciationName);
    }

    private void fillInDescriptionNameField(String strDescriptionName){
        enterText(descriptionField, strDescriptionName);
    }

    private void fillInLatitudeField(String strLatitude){
        enterText(latitudeField, strLatitude);
    }

    private void fillInLongitudeField(String strLongitude){
        enterText(longitudeField, strLongitude);
    }

    private void fillStopRadiusField(int radius){
        String strRadius = Integer.toString(radius);
        enterText(radiusField, strRadius);
    }

    private void fillApproachHeadingField(int approachHeading){
        String strApproachHeading = Integer.toString(approachHeading);
        enterText(approachHeadingField, strApproachHeading);
    }

    private void clearApproachHeadingField(){
        driver.findElement(By.id("StopHeading")).clear();
    }

    public void clickSaveButton(){
        click(saveButton);
    }

    private void unselectVisibleCheckbox(){
        waitToBeClickable(visibleCheckbox);
        click(visibleCheckbox);
    }

    private void selectBuddyStop(String value){
        WebElement buddySelectField = driver.findElement(By.id("StopBuddy-selectized"));
        buddySelectField.clear();
        buddySelectField.sendKeys(value);
        buddySelectField.sendKeys(Keys.ENTER);
    }

    public void createNewStop(String strStopName, String strPronunciationName,String strLatitude, String strLongitude, String strDescriptionName){
        this.fillInStopNameField(strStopName);
        this.fillInPronunciationNameField(strPronunciationName);
        this.fillInLatitudeField(strLatitude);
        this.fillInLongitudeField(strLongitude);
        this.fillInDescriptionNameField(strDescriptionName);
        this.clickSaveButton();
    }

    public void createBuddyStop(String strStopName, String strPronunciationName,String strLatitude, String strLongitude, String strDescriptionName, String strBuddyName){
        this.fillInStopNameField(strStopName);
        this.fillInPronunciationNameField(strPronunciationName);
        this.fillInLatitudeField(strLatitude);
        this.fillInLongitudeField(strLongitude);
        this.fillInDescriptionNameField(strDescriptionName);
        this.selectBuddyStop(strBuddyName);
        this.clickSaveButton();
    }

    public void createNewHiddenStop(String strStopName, String strPronunciationName,String strLatitude, String strLongitude, String strDescriptionName){
        this.fillInStopNameField(strStopName);
        this.fillInPronunciationNameField(strPronunciationName);
        this.fillInLatitudeField(strLatitude);
        this.fillInLongitudeField(strLongitude);
        this.fillInDescriptionNameField(strDescriptionName);
        this.unselectVisibleCheckbox();
        this.clickSaveButton();
    }

    public void createNewStopRadius(String strStopName, String strPronunciationName,String strLatitude, String strLongitude, String strDescriptionName, int radius){
        this.fillInStopNameField(strStopName);
        this.fillInPronunciationNameField(strPronunciationName);
        this.fillInLatitudeField(strLatitude);
        this.fillInLongitudeField(strLongitude);
        this.fillInDescriptionNameField(strDescriptionName);
        this.fillStopRadiusField(radius);
        this.clickSaveButton();
    }

    public void createNewStopWithApproachHeading(String strStopName, String strPronunciationName,String strLatitude, String strLongitude, String strDescriptionName, int approachHeading, boolean clearApproachHeading){
        this.fillInStopNameField(strStopName);
        this.fillInPronunciationNameField(strPronunciationName);
        this.fillInLatitudeField(strLatitude);
        this.fillInLongitudeField(strLongitude);
        this.fillInDescriptionNameField(strDescriptionName);
        this.fillApproachHeadingField(approachHeading);
        if(clearApproachHeading){
            clearApproachHeadingField();
        }
        this.clickSaveButton();
    }

    public boolean isFieldValidationDisplayed(String strElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement field = driver.findElement(By.id(strElement));
        Boolean isFieldValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", field);
        return isFieldValid;
    }

    public void createNewStopWithApproachHeadingWithoutSaving(String strStopName, String strPronunciationName,String strLatitude, String strLongitude, String strDescriptionName, int approachHeading, boolean clearApproachHeading){
        this.fillInStopNameField(strStopName);
        this.fillInPronunciationNameField(strPronunciationName);
        this.fillInLatitudeField(strLatitude);
        this.fillInLongitudeField(strLongitude);
        this.fillInDescriptionNameField(strDescriptionName);
        this.fillApproachHeadingField(approachHeading);
        if(clearApproachHeading){
            clearApproachHeadingField();
        }
    }

    public void clickIncrementApproachHeading()
    {
        waitToBeClickable(approachHeadingField);
        click(approachHeadingField);
        waitToBeClickable(approachHeadingField);
        click(approachHeadingField);
    }

}

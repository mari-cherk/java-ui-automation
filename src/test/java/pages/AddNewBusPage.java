package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddNewBusPage extends BasePage {
    private static final PageElement busNameField = new PageElement(
            "Bus Name Field",
            By.id("BusName"),
            true);
    private static final PageElement busLicensePlate = new PageElement(
            "Bus License Plate field",
            By.id("BusLicensePlate"),
            false);
    private static final PageElement busCapacityField = new PageElement(
            "Bus Capacity Field",
            By.id("BusCapacity"),
            true);
    private static final PageElement busRoutingDropdown = new PageElement(
            "Bus Routing Dropdown",
            By.cssSelector("#BusRouting"),
            true);
    private static final PageElement saveButton = new PageElement(
            "Save Button",
            By.cssSelector("input[type='submit']"),
            true);
    private static final PageElement otherPropertiesNameField = new PageElement(
            "Name Field",
            By.name("fieldname"),
            false);
    private static final PageElement otherPropertiesValueField = new PageElement(
            "Value",
            By.name("value"),
            false);
    private static final PageElement deleteOtherProperiesButton = new PageElement(
            "Delete Other Properies Button",
            By.cssSelector("button.button.button-danger.button-small.button-block"),
            false);
    private static final PageElement routingSelector = new PageElement(
            "Routing Selector",
            By.cssSelector("#BusAddForm > div.panel-body.clearfix > div:nth-child(4) > div > div.selectize-input.items.required.invalid.not-full.has-options"),
            true);
    private static final PageElement busCapacityCanNotBeNegativeMessage = new PageElement(
            "Bus capacity cannot be negative Message",
            By.xpath(".//div[contains(text(),'Bus capacity cannot be negative')]"),
            false);
    private static final PageElement busCouldNotBeSavedMessage = new PageElement(
            "The bus could not be saved Message",
            By.xpath(".//div[contains(text(),'The bus could not be saved. Please, try again.')]"),
            false);
    private static final PageElement routingDropdownSelectedValue = new PageElement(
            "Routing Dropdown Selected Value",
            By.xpath("//div[@class='item']"),
            false);

    public AddNewBusPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void fillInBusNameField(String busName) {
        enterText(busNameField, busName);
    }

    public void fillInBusLicensePlateField(String licensePlate) {
        waitToBeVisible(busLicensePlate);
        enterText(busLicensePlate, licensePlate);
    }

    public void fillInCapacityField(String busCapacity) {
        enterText(busCapacityField, busCapacity);
    }

    public void clickSubmitButton() {
        click(saveButton);
    }

    public void clickOnRoutingDropDown(int index) {
        waitToBeClickable(routingSelector);
        click(routingSelector);
        List<WebElement> optionsList = driver.findElements(By.cssSelector("#BusAddForm > div.panel-body.clearfix > div:nth-child(4) > div > div.selectize-dropdown.single.form-control.js-selectize > div > div"));
        optionsList.get(index).click();
    }

    public void selectRoutingOption(String optionName) {
        waitToBeClickable(routingSelector);
        click(routingSelector);
        PageElement option = new PageElement(
                "Select option from Routing dropdown",
                By.xpath(".//div[@class='selectize-dropdown-content']/div[contains(text(), '" + optionName + "')]"),
                false
        );
        waitToBeClickable(option);
        click(option);
    }

    public String getSelectedRouting() {
        String routingSelectedValue = getText(routingDropdownSelectedValue).trim();
        return routingSelectedValue;
    }

    public void fillInNameField(String name) {
        enterText(otherPropertiesNameField, name);
    }

    public void fillInValueField(String value) {
        enterText(otherPropertiesValueField, value);
    }

    public boolean isNameFieldPresent() {
        return isElementPresent(otherPropertiesNameField);
    }

    public boolean isValueFieldPresent() {
        return isElementPresent(otherPropertiesValueField);
    }

    public boolean isBusNegativeCapacityMessage() {
        return isElementPresent(busCapacityCanNotBeNegativeMessage);
    }

    public boolean isBusCouldNotBeSavedMessage() {
        waitToBeVisible(busCouldNotBeSavedMessage);
        return isElementPresent(busCouldNotBeSavedMessage);
    }

    public void clickOnSaveButton() {
        waitToBeVisible(saveButton);
        click(saveButton);
    }
}



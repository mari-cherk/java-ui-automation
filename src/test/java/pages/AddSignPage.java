package pages;

import common.Config;
import common.PageElement;
import common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddSignPage extends BasePage {
    private static final PageElement signNameField = new PageElement(
            "SignName Field",
            By.id("SignName"),
            true);
    private static final PageElement signIpAddressField = new PageElement(
            "Sign Ip Address Field",
            By.id("SignIpAddress"),
            true);
    private static final PageElement submitButton = new PageElement(
            "Submit Button",
            By.xpath("//input[@type='submit']"),
            true);
    private static final PageElement stopField = new PageElement(
            "Stop Field",
            By.id("SignStopId"),
            true);
    private static final PageElement routeField = new PageElement(
            "Route Field",
            By.id("RouteRoute"),
            true);

    public AddSignPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    public void createNewSign(){
        waitToBeVisible(signNameField);
        String signRandomName = "SwanSign" + Utils.getRandomInteger(65536);
        Config.SIGN_NAME = signRandomName;
        enterText(signNameField, Config.SIGN_NAME);
        waitToBeVisible(signIpAddressField);
        enterText(signIpAddressField, "192.168.2.122");
        click(submitButton);
    }

    public void fillSignNameField(String signName){
        enterText(signNameField, signName);
    }

    public void fillSignIpAddressField(String signIpAddress){
        enterText(signIpAddressField, signIpAddress);
    }

    public void selectStop(String signStopName){
        waitToBeClickable(stopField);
        click(stopField);
        Select listDropdown = new Select(driver.findElement(By.id("SignStopId")));
        listDropdown.selectByVisibleText(signStopName);
    }

    public void selectRoute(String signRouteName){
        waitToBeClickable(routeField);
        click(routeField);
        Select listDropdown = new Select(driver.findElement(By.id("RouteRoute")));
        listDropdown.selectByVisibleText(signRouteName);
    }

    public void clickOnSubmitButton(){
        waitToBeClickable(submitButton);
        click(submitButton);
    }
}

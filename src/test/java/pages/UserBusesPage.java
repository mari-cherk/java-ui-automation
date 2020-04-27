package pages;


import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserBusesPage extends BasePage{
    private static final PageElement allOnButton  = new PageElement(
            "All On button",
            By.id("bus-all-on"),
            true);
    private static final PageElement allOffButton = new PageElement(
            "All Of button",
            By.id("bus-all-off"),
            true);
    private static final PageElement oopsResetButton = new PageElement(
            "Oops! Reset button",
            By.id("bus-reset"),
            true);
    public UserBusesPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }



}

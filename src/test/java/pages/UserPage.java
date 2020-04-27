package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {
    private static final PageElement logoutButton = new PageElement(
            "User button",
            By.linkText("Logout"),
            true);
    private static final PageElement viewAllUsersButton = new PageElement(
            "View all users button",
            By.linkText("View all users"),
            false);

    private static final PageElement changePasswordButton = new PageElement(
            "Change Password Button",
            By.linkText("Change password"),
            false);


    public UserPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    public void makeLogout(){
        waitToBeClickable(logoutButton);
        click(logoutButton);
    }

    public void clickViewAllUsersButton(){
        waitToBeClickable(viewAllUsersButton);
        click(viewAllUsersButton);
    }

    public void clickOnChangePasswordButton(){
        waitToBeClickable(changePasswordButton);
        click(changePasswordButton);
    }

}
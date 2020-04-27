package pages;

import common.PageElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewUserPage extends BasePage {
    private static final PageElement disableAccountButton = new PageElement(
            "Disable Account button",
            By.xpath("/html/body/div/div[1]/div[3]/ul/li[1]/a"),
            false);
    private static final PageElement reEnableAccountButton = new PageElement(
            "Re-enable Account button",
            By.linkText("Re-enable account"),
            false);

    private static final PageElement viewEmail = new PageElement(
            "View Email text",
            By.xpath("//*[@id='content']/div[2]/dl/dd[4]"),
            true);

    private static final PageElement viewDisplayName = new PageElement(
            "View Display Name text",
            By.xpath("//*[@id='content']/div[2]/dl/dd[3]"),
            true);

    public ViewUserPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    private void clickDisableUserAccount(){
        waitToBeClickable(disableAccountButton);
        click(disableAccountButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    private void clickReEnableUserAccount(){
        waitToBeClickable(reEnableAccountButton);
        click(reEnableAccountButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void disableUserAccount(){
        this.clickDisableUserAccount();
    }

    public void reEnableUserAccount(){
        this.clickReEnableUserAccount();
    }

    public String getEmailText() {
        return getText(viewEmail);
    }

    public String getDisplayName() {
        return getText(viewDisplayName);
    }
}

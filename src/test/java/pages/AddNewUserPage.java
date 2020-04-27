package pages;

import common.PageElement;
import common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AddNewUserPage extends BasePage {
    private static final PageElement usernameField = new PageElement(
            "Username field",
            By.id("UserUsername"),
            true);
    private static final PageElement displayNameField = new PageElement(
            "Display name field",
            By.id("UserDisplayName"),
            false);
    private static final PageElement emailField = new PageElement(
            "Email field",
            By.id("UserEmail"),
            true);
    private static final PageElement passwordField = new PageElement(
            "Password field",
            By.id("UserPassword"),
            true);
    private static final PageElement confirmPasswordField = new PageElement(
            "Confirm password field",
            By.id("UserPassword2"),
            true);
    private static final PageElement roleDropdown = new PageElement(
            "Role Dropdown",
            By.id("UserRole"),
            false);
    private static final PageElement submitButton = new PageElement(
            "Submit button",
            By.className("submit"),
            true);

    private static final PageElement highlightMessage = new PageElement(
            "Highlight Message",
            By.id("flashMessage"),
            false);

    private static final PageElement listUsersButton = new PageElement(
            "Highlight Message",
            By.linkText("List Users"),
            true);

    private static final PageElement usernameAlreadyTakenMessage = new PageElement(
            "Username Already Taken Message",
            By.xpath("//div[@class='error-message' and text()='Username already taken.']"),
            false);

    private static final PageElement usernameAllowedSymbolsMessage = new PageElement(
            " Message: 'Username can only have letters, numbers, dash and underscore'",
            By.xpath("//div[@class='error-message' and text()='Username can only have letters, numbers, dash and underscore.']"),
            false);

    private static final PageElement passwordNeedsToBeCharactersLong = new PageElement(
            " Message: 'Password needs to be at least 8 characters long.'",
            By.xpath("//div[@class='error-message' and text()='Password needs to be at least 8 characters long.']"),
            false);

    private static final PageElement addNewUserForm = new PageElement(
            "Add New User Form",
            By.id("UserAddForm"),
            false);

    public AddNewUserPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    public void fillUsernameField(String strUserName){
        enterText(usernameField, strUserName);
    }

    public void fillDisplayNameField(String strUserName){
        enterText(displayNameField, strUserName);
    }

    public void fillEmailField(String strUserName){
        enterText(emailField, strUserName);
    }

    public void fillPasswordField(String strPassword){
        enterText(passwordField, strPassword);
    }

    public void fillConfirmPassword(String strConfirmPassword){
        enterText(confirmPasswordField, strConfirmPassword);
    }

    public void selectUserRole(String strUserRole){
        selectFromSelectBox(roleDropdown, strUserRole);
    }

    public void clickSubmitButton(){
        waitToBeClickable(submitButton);
        click(submitButton);
    }

    public void clickListUserButton(){
        waitToBeClickable(listUsersButton);
        click(listUsersButton);
    }

    public void createNewUser(String username, String displayName, String email, String password, String role){
        fillUsernameField(username);
        fillDisplayNameField(displayName);
        fillEmailField(email);
        fillPasswordField(password);
        fillConfirmPassword(password);
        selectUserRole(role);
        clickSubmitButton();
    }

    public void createNewUser(String username, String displayName, String email, String password, String role, boolean confirm, boolean submit){
        fillUsernameField(username);
        fillDisplayNameField(displayName);
        fillEmailField(email);
        fillPasswordField(password);
        if (confirm) {
            fillConfirmPassword(password);
        }
        selectUserRole(role);
        if (submit) {
            clickSubmitButton();
        }
    }

    public boolean highlightMessageIsDisplayed(){
        return isElementPresent(highlightMessage);
    }

    public boolean usernameAlreadyTakenMessageIsDisplayed(){
        return isElementPresent(usernameAlreadyTakenMessage);
    }

    public boolean usernameAllowedSymbolsMessageIsDisplayed(){
        return isElementPresent(usernameAllowedSymbolsMessage);
    }

    public boolean PasswordNeedsToBeAtLeastCharactersIsDisplayed(){
        return isElementPresent(passwordNeedsToBeCharactersLong);
    }

    public void takeScreenshotOfAddNewUserForm(String imgName){
        String imgPath = System.getProperty("user.dir") + "/src/test/resources/screenshotsComparison/";
        Utils.sleep(3000);
        WebElement form = driver.findElement(By.id("UserAddForm"));
        Screenshot myScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, form);
        try {
            ImageIO.write(myScreenshot.getImage(), "PNG", new File(imgPath + imgName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean screenshotCompareOfAddNewUserForm(String image1, String image2, String image3){
        String imgPath = System.getProperty("user.dir") + "/src/test/resources/screenshotsComparison/";
        BufferedImage expectedImage = null;
        try {
            expectedImage = ImageIO.read(new File(imgPath + image1 + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedImage actualImage = null;
        try {
            actualImage = ImageIO.read(new File(imgPath + image2 + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);
        BufferedImage diffImage = diff.getMarkedImage();
        try {
            ImageIO.write(diffImage, "PNG", new File(imgPath + image3 + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return diff.hasDiff();
    }

    public boolean isFieldRequired(){
        waitToBeVisible(addNewUserForm);
        takeScreenshotOfAddNewUserForm("Add User Form before");
        click(submitButton);
        takeScreenshotOfAddNewUserForm("Add User Form after");
        return screenshotCompare("Add User Form before", "Add User Form after", "Add User Form Diff");
    }

}

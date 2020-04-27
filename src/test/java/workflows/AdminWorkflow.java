package workflows;

import common.dataObjects.AdminDataObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AddNewUserPage;
import tests.BaseTest;

public class AdminWorkflow {
    private Logger log = Logger.getLogger(this.getClass().getSimpleName());

    AddNewUserPage addNewUserPage;

    public AdminWorkflow(WebDriver driver){
        this.addNewUserPage = new AddNewUserPage(driver);
    }

    public void createNewAdmin(AdminDataObject adminDataObject, boolean clickSubmit){
        log.info("Start creating new Admin");
        addNewUserPage.fillUsernameField(adminDataObject.UserName);
        addNewUserPage.fillDisplayNameField(adminDataObject.DisplayName);
        addNewUserPage.fillEmailField(adminDataObject.Email);
        addNewUserPage.fillPasswordField(adminDataObject.Password);
        addNewUserPage.fillConfirmPassword(adminDataObject.ConfirmPassword);
        addNewUserPage.selectUserRole(adminDataObject.Role);
        if (clickSubmit) {
            addNewUserPage.clickSubmitButton();
            log.info("Finish Creating New Admin");
        }
    }
}

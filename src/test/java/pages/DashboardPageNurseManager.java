package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageNurseManager extends DashboardPage {

    public static final PageElement inventoryTab = new PageElement(
            "Inventory Tab",
            By.xpath("//a[text()='Inventory']"),
            true);

    public static final PageElement patientsTab = new PageElement(
            "Patients Tab",
            By.xpath("//a[text()='Patients']"),
            true);

    public DashboardPageNurseManager(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }
}

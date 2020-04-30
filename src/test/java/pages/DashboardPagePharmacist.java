package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPagePharmacist extends DashboardPage {

    public static final PageElement inventoryTab = new PageElement(
            "Inventory Tab",
            By.xpath("//a[text()='Inventory']"),
            true);

    public static final PageElement medicationTab = new PageElement(
            "Medication Tab",
            By.xpath("//a[text()='Medication']"),
            true);

    public DashboardPagePharmacist(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }
}

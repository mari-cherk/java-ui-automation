package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageBusinessOffice extends DashboardPage {

    public static final PageElement patientsTab = new PageElement(
            "Patients Tab",
            By.xpath("//a[text()='Patients']"),
            true);

    public static final PageElement schedulingTab = new PageElement(
            "Scheduling Tab",
            By.xpath("//a[text()='Scheduling']"),
            true);

    public static final PageElement billingTab = new PageElement(
            "Billing Tab",
            By.xpath("//a[text()='Billing']"),
            true);

    public DashboardPageBusinessOffice(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }
}

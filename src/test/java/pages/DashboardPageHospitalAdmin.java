package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageHospitalAdmin extends DashboardPage {

    public static final PageElement inventoryTab = new PageElement(
            "Inventory Tab",
            By.xpath("//a[text()='Inventory']"),
            true);

    public static final PageElement patientsTab = new PageElement(
            "Patients Tab",
            By.xpath("//a[text()='Patients']"),
            true);

    public static final PageElement schedulingTab = new PageElement(
            "Scheduling Tab",
            By.xpath("//a[text()='Scheduling']"),
            true);

    public static final PageElement imagingTab = new PageElement(
            "Imaging Tab",
            By.xpath("//a[text()='Imaging']"),
            true);

    public static final PageElement medicationTab = new PageElement(
            "Medication Tab",
            By.xpath("//a[text()='Medication']"),
            true);

    public static final PageElement labsTab = new PageElement(
            "Labs Tab",
            By.xpath("//a[text()='Labs']"),
            true);

    public static final PageElement billingTab = new PageElement(
            "Billing Tab",
            By.xpath("//a[text()='Billing']"),
            true);

    public static final PageElement incidentTab = new PageElement(
            "Incident Tab",
            By.xpath("//a[text()='Incident']"),
            true);

    public static final PageElement adminTab = new PageElement(
            "Admin Tab",
            By.xpath("//a[text()='Administration']"),
            true);

    public DashboardPageHospitalAdmin(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }
}

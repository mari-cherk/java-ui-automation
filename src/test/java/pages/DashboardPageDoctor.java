package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageDoctor extends DashboardPage {

    public static final PageElement patientsTab = new PageElement(
            "Patients Tab",
            By.xpath("//a[text()='Patients']"),
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

    public DashboardPageDoctor(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }


}

package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageNurse extends DashboardPage {

    public static final PageElement patientsTab = new PageElement(
            "Patients Tab",
            By.xpath("//a[text()='Patients']"),
            true);

    public static final PageElement imagingTab = new PageElement(
            "Imaging Tab",
            By.xpath("//a[text()='Imaging']"),
            true);

    public DashboardPageNurse(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }
}

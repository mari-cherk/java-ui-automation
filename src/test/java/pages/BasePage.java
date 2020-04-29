package pages;

import com.google.common.base.Function;
import common.PageElement;
import common.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public abstract class BasePage {

    public static final PageElement gridProcessingSpinner = new PageElement(
            "Grid processing spinner",
            By.className(".lds-spin-grid"));

    public WebDriver driver;
    protected Logger log;



    public BasePage(WebDriver driver){
        this.driver = driver;
        log = Logger.getLogger(this.getClass().getCanonicalName());
    }

    public abstract boolean pageIsDisplayed();


    public String getText(PageElement pageElement){
        log.info("Getting text of element: " + pageElement.name);
        return this.find(pageElement).getText();
    }

    public String getAttribute(PageElement pageElement, String attibute){
        log.info("Getting arrtibute of element: " + pageElement.name);
        return this.find(pageElement).getAttribute(attibute);
    }

    public void enterText(PageElement pageElement, String text){
        this.enterText(pageElement, text, true);
    }

    public void enterText(PageElement pageElement, String text, boolean clearField){
        log.info("Entering text \"" + text + "\" to element: " + pageElement.name);
        this.find(pageElement).click();
        if (clearField) {
            this.find(pageElement).clear();
        }
        this.find(pageElement).sendKeys(text);
    }

    public void click(PageElement pageElement){
        log.info("Clicking on element: " + pageElement.name);
        this.find(pageElement).click();
    }

    public WebElement find(By element){
        return this.driver.findElement(element);
    }

    public WebElement find(PageElement element){
        return this.find(element.getLocator());
    }

    public List<WebElement> findAll(By element){
        return this.driver.findElements(element);
    }

    public List<WebElement> findAll(PageElement element){
        return this.findAll(element.getLocator());
    }

    /**
     * Gets all elements on the page from the page object.
     *
     * @return a list of all the elements in this object.
     */
    public List<PageElement> getElements(){
        List<PageElement> elements = new ArrayList<PageElement>();
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.getType().getSimpleName().equals("PageElement")) {
                try {
                    field.setAccessible(true);
                    elements.add((PageElement) field.get(PageElement.class));
                    field.setAccessible(false);
                } catch (IllegalAccessException ignored) {
                    System.out.println(ignored.toString());
                }
            }
        }
        return elements;
    }

    /**
     * Gets the required elements for this page.
     *
     * @return an array of the required elements on this page.
     */
    public List<PageElement> getRequiredElements(){
        ArrayList<PageElement> requiredElements = new ArrayList<PageElement>();
        for (PageElement ele : this.getElements()) {
            if (ele.required) {
                requiredElements.add(ele);
            }
        }
        return requiredElements;
    }

    /**
     * Returns an array of all the required elements that were not visible on the current page.
     *
     * @return all the elements in the array that were not visible.
     */
    public ArrayList<PageElement> getMissingRequiredElements(List<PageElement> requiredElements){
        ArrayList<PageElement> elements = new ArrayList<PageElement>(requiredElements);
        for (PageElement ele : requiredElements) {
            if (this.isElementPresent(ele)) {
                elements.remove(ele);
            } else {
                log.info("Missed required element: " + ele.name);
            }
        }
        return elements;
    }

    protected boolean allRequiredElementDisplayed(){
        waitForPageLoaded();
        log.info("Checking if all required elements present on page");
        return this.getMissingRequiredElements(this.getRequiredElements()).isEmpty();
    }

    public boolean isElementPresent(By element){
        boolean elementFound;
        try {
            this.find(element);
            elementFound = true;
        } catch (NoSuchElementException e) {
            elementFound = false;
        }
        return elementFound;
    }

    public boolean isElementPresent(PageElement element){
        return this.isElementPresent(element.getLocator());
    }

    /**
     * Waits for the specified timeout period for an element to be visible.
     *
     * @param element the By object representing the element to wait for.
     * @param timeout the length of time in seconds to wait, as an integer.
     */
    public void waitToBeVisible(final By element, int timeout){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoreAll(Arrays.asList(ElementNotVisibleException.class, NoSuchElementException.class, StaleElementReferenceException.class, WebDriverException.class));
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver input){
                return input.findElement(element);
            }
        });
    }

    public void waitToBeVisible(By element){
        this.waitToBeVisible(element, 30);
    }

    public void waitToBeVisible(PageElement element, int timeout){
        this.waitToBeVisible(element.getLocator(), timeout);
    }

    public void waitToBeVisible(PageElement element){
        this.waitToBeVisible(element.getLocator(), 30);
    }

    /**
     * Waits for the specified timeout period for an element to be invisible.
     *
     * @param element the By object representing the element to wait for.
     * @param timeout the length of time in seconds to wait, as an integer.
     */
    public void waitToBeInvisible(By element, int timeout){
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void waitToBeInvisible(By element){
        this.waitToBeInvisible(element, 60);
    }

    public void waitToBeInvisible(PageElement element, int timeout){
        log.info("Wait to be invisible " + element.name + " ...");
        this.waitToBeInvisible(element.getLocator(), timeout);
    }

    public void waitToBeInvisible(PageElement element){
        this.waitToBeInvisible(element.getLocator(), 60);
    }

    /**
     * Waits for the specified timeout period for an element to be clickable.
     *
     * @param element the By object representing the element to wait for.
     * @param timeout the length of time in seconds to wait, as an integer.
     */
    public void waitToBeClickable(By element, int timeout){
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToBeClickable(By element){
        this.waitToBeClickable(element, 30);
    }

    public void waitToBeClickable(PageElement element, int timeout){
        this.waitToBeClickable(element.getLocator(), timeout);
    }

    public void waitToBeClickable(PageElement element){
        this.waitToBeClickable(element.getLocator(), 30);
    }

    /**
     * Waits for the specified timeout period for an element to be present.
     *
     * @param element the By object representing the element to wait for.
     * @param timeout the length of time in seconds to wait, as an integer.
     */
    public void waitToBePresent(By element, int timeout){
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitToBePresent(By element){
        this.waitToBePresent(element, 30);
    }

    public void waitToBePresent(PageElement element, int timeout){
        this.waitToBePresent(element.getLocator(), timeout);
    }

    public void waitToBePresent(PageElement element){
        this.waitToBePresent(element.getLocator(), 30);
    }

    public void waitForInvisibilityOfGridSpinner(){
        this.waitToBeInvisible(gridProcessingSpinner, 60);
    }

    public void selectFromSelectBox(PageElement selectBox, String value){
        log.info("Selecting \"" + value + "\" from: " + selectBox.name);
        Select dropdown = new Select(find(selectBox));
        dropdown.selectByValue(value);
    }

//    public void selectFromSelectBoxByIndex(PageElement selectBox, String value){
//        log.info("Selecting \"" + value + "\" from: " + selectBox.name);
//        Select dropdown = new Select(find(selectBox));
//        dropdown.selectByValue(value);
//    }

    public void selectFromDropdown(WebElement dropdown){
        Select listDropdown = new Select(dropdown);
        List<WebElement> list = listDropdown.getOptions();
        listDropdown.selectByIndex(Utils.getRandomInteger(list.size()));
    }

    public void selectFromDropDownByIndex(PageElement selectBox, int index){
        Select dropdown = new Select(find(selectBox));
        dropdown.selectByIndex(index);
    }

    public void takeScrenshotByElement(String imgName){
        String imgPath = System.getProperty("user.dir") + "/src/test/resources/screenshotsComparison/";
        Utils.sleep(3000);
        WebElement map = driver.findElement(By.id("map"));
        Screenshot myScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, map);
        try {
            ImageIO.write(myScreenshot.getImage(), "PNG", new File(imgPath + imgName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean screenshotCompare(String image1, String image2, String image3){
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
        //Assert.assertFalse(diff.hasDiff(), "Image Are Same");
        return diff.hasDiff();
    }

    public void waitForPageLoaded(){
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver){
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void check(PageElement el){
        log.info("Checking element " + el.name);
        if (!find(el).isSelected()) {
            click(el);
        }
    }

    public void uncheck(PageElement el){
        log.info("Unchecking element " + el.name);
        if (find(el).isSelected()) {
            click(el);
        }
    }

    public boolean isChecked(PageElement el){
        log.info("Checking is element " + el.name + " checked");
        return find(el).isSelected();
    }

    public boolean isUnchecked(PageElement el){
        log.info("Checking is element " + el.name + " unchecked");
        return !find(el).isSelected();
    }

    /**
     * If Javascript Alert is present on the page cancels it.
     */
    public void handleAlert() throws AWTException {
        if(isAlertPresent()){
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        }
    }

    /**
     *
     * @return True if JavaScript Alert is present on the page otherwise false
     */

    public boolean isAlertPresent(){
        Utils.sleep(1500);
        try{
            driver.switchTo().alert();
            return true;
        }catch(NoAlertPresentException ex){
            return false;
        }
    }

    public void refreshPage() throws InterruptedException, AWTException {
        driver.navigate().refresh();
        handleAlert();
    }
}

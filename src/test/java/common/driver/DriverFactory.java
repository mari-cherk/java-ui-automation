package common.driver;

import common.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private String browser;
    private WebDriver driver;
    private Logger log = Logger.getLogger(this.getClass().getSimpleName());

    public DriverFactory(String browser){
        this.browser = browser;
    }

    public WebDriver getDriver(){
        setUpDriver(browser);
        return driver;
    }

    private void setUpDriver(String browser){
        if (browser.equalsIgnoreCase("Chrome")) {
            initChromeDriverPath();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("--disable-popup-blocking");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
        } else if (browser.equalsIgnoreCase("IE")) {
            initInternetExplorerDriverPath();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void initChromeDriverPath(){
        String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers";

        if (Utils.getSystemName().contains("Win")) {
            chromeDriverPath += "/windows/chromedriver.exe";
        } else if (Utils.getSystemName().contains("Mac")) {
            chromeDriverPath += "/mac/chromedriver";
        } else {
            chromeDriverPath += "/linux/chromedriver";
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }

    private void initInternetExplorerDriverPath(){
        String internetExplorerPath = System.getProperty("user.dir") + "/src/test/resources/drivers";

        if (Utils.getSystemName().contains("Win")) {
            internetExplorerPath += "/windows/IEDriverServer.exe";
        } else if (Utils.getSystemName().contains("Mac")) {
            log.info("IE doesn't supported by Mac");
        } else {
            log.info("IE doesn't supported by Linux");
        }
        System.setProperty("webdriver.ie.driver", internetExplorerPath);
    }
}

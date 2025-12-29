package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import utils.PropertyReader;

public class WebDriverFactory {
    private final static String browser = PropertyReader.getProperty("browserType");

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    //safari > SAFARI
    private static AbstractDriver getDriver() {
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        return browserType.getDriverFactory();
    }

    public static WebDriver initDriver() {
        WebDriver driver = ThreadGuard.protect(getDriver().createDriver());
        driverThreadLocal.set(driver);
        return driverThreadLocal.get();
    }




    public static WebDriver get() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }
}

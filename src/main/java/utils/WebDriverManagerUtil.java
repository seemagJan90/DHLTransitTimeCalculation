package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Utility class for managing WebDriver instances.
 * This class ensures that the WebDriver is initialized only once
 * and provides a single instance throughout the test execution.
 */
public class WebDriverManagerUtil {
    private static WebDriver driver;

    /**
     * Returns a singleton instance of WebDriver.
     * If the driver is not already initialized, it sets up a new instance.
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.6998.178 Safari/537.36");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    /**
     * Closes and quits the WebDriver instance if it is not null.
     * This should be called at the end of the test execution to clean up resources.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

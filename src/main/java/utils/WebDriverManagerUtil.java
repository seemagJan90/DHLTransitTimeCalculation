package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Utility class for managing WebDriver instances. This class ensures that the
 * WebDriver is initialized only once and provides a single instance throughout
 * the test execution.
 */
public class WebDriverManagerUtil {
	private static WebDriver driver;

	/**
	 * Returns a singleton instance of WebDriver. If the driver is not already
	 * initialized, it sets up a new instance.
	 *
	 * @return WebDriver instance
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();

			// Create a new instance of ChromeOptions to customize the ChromeDriver settings
			ChromeOptions options = new ChromeOptions();

			// Prevent detection of the automated browser (helpful in bypassing bot
			// detection)
			options.addArguments("--disable-blink-features=AutomationControlled");
			
			// This argument prevents the Cross-Origin Resource Sharing error caused by
			// automated access from an origin other than the server.
			options.addArguments("--remote-allow-origins=*");
			
			// This argument starts the browser window maximized, preventing the detection
			// of a small window or browser UI configuration commonly used in automated
			// tests.
			options.addArguments("--start-maximized");

			// Prevent WebDriver detection
			// This disables Chrome's built-in automation extension, which is otherwise
			// detectable in some cases. It can be used to hide automation traces.
			options.setExperimentalOption("useAutomationExtension", false);
			
			// This argument removes the "enable-automation" switch that can reveal
			// automation-related details in the browser (e.g., in the browser console).
			// This helps hide Selenium from websites.
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		return driver;
	}

	/**
	 * Closes and quits the WebDriver instance if it is not null. This should be
	 * called at the end of the test execution to clean up resources.
	 */
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}

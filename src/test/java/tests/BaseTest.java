package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.TransitTimeCalculatorPage;
import utils.WebDriverManagerUtil;

public class BaseTest {
	
	protected WebDriver driver;
	protected TransitTimeCalculatorPage calculatorPage;

    @BeforeClass
    public void setup() {
        driver = WebDriverManagerUtil.getDriver();
        driver.get("https://www.dhl.com/se-en/home/freight/tools/european-road-freight-transit-time-calculator.html");
        calculatorPage = new TransitTimeCalculatorPage(driver);
        //calculatorPage.acceptCookies();
    }
    
    @AfterClass
    public void teardown() {
        WebDriverManagerUtil.quitDriver();
    }

}

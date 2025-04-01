package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransitTimeCalculatorPage {
    WebDriver driver;

    // Web Elements
    @FindBy(id = "origin-country")
    private WebElement originCountry;

    @FindBy(id = "origin-postcode")
    private WebElement originPostalCode;

    @FindBy(id = "destination-country")
    private WebElement destinationCountry;

    @FindBy(id = "destination-postcode")
    private WebElement destinationPostalCode;

    @FindBy(css = "#wcag-main-content > div.l-grid.c-calculator.c-leadtime.js--swe-leadtime.component-wide.component-margin > div.c-leadtime--countryselector-container.js--freightcalc--countryselector-container.c-calculator--tabcontent.l-grid.l-grid--left-s.l-grid--w-100pc-s > div.c-calculator--input-form.c-calculator--padding-vertical.l-grid.l-grid--w-100pc-s.l-grid--center-s.l-grid--center-m > div.l-grid--center-s.l-grid.l-grid--w-90pc-s.l-grid--w-33pc-m > button")
    private WebElement calculateButton;

    @FindBy(css = "#wcag-main-content > div.l-grid.c-calculator.c-leadtime.js--swe-leadtime.component-wide.component-margin > div.c-leadtime--countryselector-container.js--freightcalc--countryselector-container.c-calculator--tabcontent.l-grid.l-grid--left-s.l-grid--w-100pc-s > div.c-calculator--input-form.c-calculator--padding-vertical.l-grid.l-grid--w-100pc-s.l-grid--center-s.l-grid--center-m > div:nth-child(1) > div:nth-child(2) > p") // Replace with actual locator
    private WebElement errorMessageOriginPostcode;
    
    @FindBy(css = "#wcag-main-content > div.l-grid.c-calculator.c-leadtime.js--swe-leadtime.component-wide.component-margin > div.c-leadtime--countryselector-container.js--freightcalc--countryselector-container.c-calculator--tabcontent.l-grid.l-grid--left-s.l-grid--w-100pc-s > div.c-calculator--input-form.c-calculator--padding-vertical.l-grid.l-grid--w-100pc-s.l-grid--center-s.l-grid--center-m > div:nth-child(2) > div:nth-child(2) > p") // Replace with actual locator
    private WebElement errorMessageDestinationPostcode;
    
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;
    
    @FindBy(css = "#wcag-main-content > div.l-grid.c-calculator.c-leadtime.js--swe-leadtime.component-wide.component-margin > div.c-leadtime--options-container.js--leadtime--options-container.l-grid.l-grid--left-s.l-grid--w-100pc-s.l-grid--w-100pc-m > div.l-grid.l-grid--left-s.l-grid--w-100pc-s.c-calculator--padding-vertical > div.l-grid--w-50pc-s.l-grid--left-s > h3")
    private WebElement transitTimeResult;
    
    WebDriverWait wait;
    
    // Constructor
    public TransitTimeCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Page Actions
    public void selectOriginCountry(String country) {
    	
        wait.until(ExpectedConditions.elementToBeClickable(originCountry));
    	Select countryDropdown = new Select(originCountry);
        countryDropdown.selectByVisibleText(country); 
    }

    public void enterOriginPostalCode(String postalCode) {
    	originPostalCode.clear();
        originPostalCode.sendKeys(postalCode);
    }

    public void selectDestinationCountry(String country) {
    	Select countryDropdown = new Select(destinationCountry);
        countryDropdown.selectByVisibleText(country); 
    }

    public void enterDestinationPostalCode(String postalCode) {
    	destinationPostalCode.clear();
        destinationPostalCode.sendKeys(postalCode);
    }

    public void clickCalculate() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", calculateButton);
        //calculateButton.click();
        
    }

    public String getOriginPostcodeErrorMessage() {
        return errorMessageOriginPostcode.isDisplayed() ? errorMessageOriginPostcode.getText() : null;
    }
    
    public String getDestinationPostcodeErrorMessage() {
        return errorMessageDestinationPostcode.isDisplayed() ? errorMessageDestinationPostcode.getText() : null;
    }
    
    public void acceptCookies() {
    	 wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
        if (acceptCookiesButton.isDisplayed()) {
            acceptCookiesButton.click();
        }
    }
    
    public String getTransitTimeResultMessage() {
    	wait.until(ExpectedConditions.visibilityOf(transitTimeResult));
    	return transitTimeResult.isDisplayed() ? transitTimeResult.getText() : null;
    }
}

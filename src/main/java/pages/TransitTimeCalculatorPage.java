package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model class for the Transit Time Calculator Page. This class
 * contains methods to interact with the calculator form, including selecting
 * countries, clicking the calculate button, and verifying displayed results.
 */
public class TransitTimeCalculatorPage {
	WebDriver driver;

	/**
	 * WebElement for selecting the origin country from the dropdown.
	 */
	@FindBy(id = "origin-country")
	private WebElement originCountry;

	/**
	 * WebElement for entering the postal code for origin country.
	 */
	@FindBy(id = "origin-postcode")
	private WebElement originPostalCode;

	/**
	 * WebElement for selecting the destination country from the dropdown.
	 */
	@FindBy(id = "destination-country")
	private WebElement destinationCountry;

	/**
	 * WebElement for entering the postal code for destination country.
	 */
	@FindBy(id = "destination-postcode")
	private WebElement destinationPostalCode;

	/**
	 * WebElement for clicking the Calculate button.
	 */
	@FindBy(css = "#wcag-main-content > div.l-grid.c-calculator.c-leadtime.js--swe-leadtime.component-wide.component-margin > div.c-leadtime--countryselector-container.js--freightcalc--countryselector-container.c-calculator--tabcontent.l-grid.l-grid--left-s.l-grid--w-100pc-s > div.c-calculator--input-form.c-calculator--padding-vertical.l-grid.l-grid--w-100pc-s.l-grid--center-s.l-grid--center-m > div.l-grid--center-s.l-grid.l-grid--w-90pc-s.l-grid--w-33pc-m > button")
	private WebElement calculateButton;

	/**
	 * WebElement for error message when invalid input is provided.
	 */
	@FindBy(css = "#wcag-main-content > div.l-grid.c-calculator.c-leadtime.js--swe-leadtime.component-wide.component-margin > div.c-leadtime--countryselector-container.js--freightcalc--countryselector-container.c-calculator--tabcontent.l-grid.l-grid--left-s.l-grid--w-100pc-s > div.c-calculator--input-form.c-calculator--padding-vertical.l-grid.l-grid--w-100pc-s.l-grid--center-s.l-grid--center-m > div:nth-child(1) > div:nth-child(2) > p") // Replace
																																																																																																															// with
																																																																																																															// actual
																																																																																																															// locator
	private WebElement errorMessageOriginPostcode;

	@FindBy(css = "#wcag-main-content > div.l-grid.c-calculator.c-leadtime.js--swe-leadtime.component-wide.component-margin > div.c-leadtime--countryselector-container.js--freightcalc--countryselector-container.c-calculator--tabcontent.l-grid.l-grid--left-s.l-grid--w-100pc-s > div.c-calculator--input-form.c-calculator--padding-vertical.l-grid.l-grid--w-100pc-s.l-grid--center-s.l-grid--center-m > div:nth-child(2) > div:nth-child(2) > p") // Replace
																																																																																																															// with
																																																																																																															// actual
																																																																																																															// locator
	private WebElement errorMessageDestinationPostcode;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement acceptCookiesButton;

	/**
	 * WebElement for verifying if results are displayed.
	 */
	@FindBy(css = "#wcag-main-content > div.l-grid.c-calculator.c-leadtime.js--swe-leadtime.component-wide.component-margin > div.c-leadtime--options-container.js--leadtime--options-container.l-grid.l-grid--left-s.l-grid--w-100pc-s.l-grid--w-100pc-m > div.l-grid.l-grid--left-s.l-grid--w-100pc-s.c-calculator--padding-vertical > div.l-grid--w-50pc-s.l-grid--left-s > h3")
	private WebElement transitTimeResult;

	WebDriverWait wait;

	/**
	 * Constructor to initialize the WebDriver and PageFactory elements.
	 * 
	 * @param driver WebDriver instance
	 */
	public TransitTimeCalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/**
	 * Selects the origin country from the dropdown.
	 * 
	 * @param country The name of the country to select
	 */
	public void selectOriginCountry(String country) {

		wait.until(ExpectedConditions.elementToBeClickable(originCountry));
		Select countryDropdown = new Select(originCountry);
		countryDropdown.selectByVisibleText(country);
	}

	/**
	 * enter the postal code for origin country .
	 * 
	 * @param postalCode The postalCode for origin country
	 */
	public void enterOriginPostalCode(String postalCode) {
		originPostalCode.clear();
		originPostalCode.sendKeys(postalCode);
	}

	/**
	 * Selects the destination country from the dropdown.
	 * 
	 * @param country The name of the country to select
	 */
	public void selectDestinationCountry(String country) {
		Select countryDropdown = new Select(destinationCountry);
		countryDropdown.selectByVisibleText(country);
	}

	/**
	 * enter the postal code for destination country .
	 * 
	 * @param postalCode The postalCode for destination country
	 */
	public void enterDestinationPostalCode(String postalCode) {
		destinationPostalCode.clear();
		destinationPostalCode.sendKeys(postalCode);
	}

	/**
	 * Clicks the Calculate button to compute the transit time.
	 */
	public void clickCalculate() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", calculateButton);
		// calculateButton.click();

		// Actions actions = new Actions(driver);
		// actions.moveToElement(calculateButton).click().perform();

	}

	/**
	 * Checks if an error message is displayed for invalid input.
	 * 
	 * @return error message if an error message is displayed, false null
	 */
	public String getOriginPostcodeErrorMessage() {
		return errorMessageOriginPostcode.isDisplayed() ? errorMessageOriginPostcode.getText() : null;
	}

	/**
	 * Checks if an error message is displayed for invalid input.
	 * 
	 * @return error message if an error message is displayed, false null
	 */
	public String getDestinationPostcodeErrorMessage() {
		return errorMessageDestinationPostcode.isDisplayed() ? errorMessageDestinationPostcode.getText() : null;
	}

	public void acceptCookies() {
		wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
		if (acceptCookiesButton.isDisplayed()) {
			acceptCookiesButton.click();
		}
	}

	/**
	 * Checks if the result section is displayed after calculation.
	 * 
	 * @return text if the result section is displayed, otherwise null
	 */
	public String getTransitTimeResultMessage() {
		wait.until(ExpectedConditions.visibilityOf(transitTimeResult));
		return transitTimeResult.isDisplayed() ? transitTimeResult.getText() : null;
	}
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for validating error handling of the transit time calculator with
 * invalid inputs. This test ensures the system correctly handles and provides
 * appropriate messages for invalid or missing data entries.
 */
public class InvalidInputTest extends BaseTest {

	/**
	 * Test method to verify handling of missing origin and destination postal codes
	 */
	@Test
	public void testBlankPostalCode() {
		//calculatorPage.acceptCookies();
		calculatorPage.selectOriginCountry("Sweden");
		calculatorPage.enterOriginPostalCode("");

		calculatorPage.selectDestinationCountry("Belgium");
		calculatorPage.enterDestinationPostalCode("");

		calculatorPage.clickCalculate();

		String originPostcodeErrorText = calculatorPage.getOriginPostcodeErrorMessage();
		Assert.assertNotNull(originPostcodeErrorText, "Correct postal code (e.g. no post box)*");
		Assert.assertEquals(originPostcodeErrorText, "Correct postal code (e.g. no post box)*");
		System.out.println("Test Passed: Error message displayed - " + originPostcodeErrorText);

		String destinationPostcodeErrorText = calculatorPage.getDestinationPostcodeErrorMessage();
		Assert.assertNotNull(destinationPostcodeErrorText, "Correct postal code (e.g. no post box)*");
		Assert.assertEquals(destinationPostcodeErrorText, "Correct postal code (e.g. no post box)*");
		System.out.println("Test Passed: Error message displayed - " + destinationPostcodeErrorText);
	}

	/**
	 * Test method to verify handling of invalid postal codes
	 * @throws InterruptedException 
	 */
	@Test
	public void testInvalidPostalCode() throws InterruptedException {
		//calculatorPage.acceptCookies();
		calculatorPage.selectOriginCountry("Sweden");
		calculatorPage.enterOriginPostalCode("10012");

		calculatorPage.selectDestinationCountry("Sweden");
		calculatorPage.enterDestinationPostalCode("10115");

		calculatorPage.clickCalculate();
		Thread.sleep(2000);
		String destinationPostcodeErrorText = calculatorPage.getDestinationPostcodeErrorMessage();
		Assert.assertNotNull(destinationPostcodeErrorText, "Correct postal code (e.g. no post box)*");
		Assert.assertEquals(destinationPostcodeErrorText, "Correct postal code (e.g. no post box)*");
		System.out.println("Test Passed: Error message displayed - " + destinationPostcodeErrorText);
	}

}

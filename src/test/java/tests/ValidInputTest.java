package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for validating the transit time calculator with valid input data.
 * This test ensures that the calculator correctly computes transit times for
 * valid origin and destination countries.
 */
public class ValidInputTest extends BaseTest {

	/**
	 * Test method to verify transit time calculation for a valid country.
	 */
	@Test
	public void testTransitTimeCalculationForGermany() {
		// Provide valid input
		calculatorPage.selectOriginCountry("Sweden");
		calculatorPage.enterOriginPostalCode("10012");
		calculatorPage.selectDestinationCountry("Germany");
		calculatorPage.enterDestinationPostalCode("10115");
		calculatorPage.clickCalculate();

		String successMessage = calculatorPage.getTransitTimeResultMessage();
		Assert.assertEquals(successMessage, "2/2 Transit Time Result");
		System.out.println("Test Passed: Success message displayed - " + successMessage);
	}

	/**
	 * Test method to verify transit time calculation for a valid country.
	 */
	@Test
	public void testTransitTimeCalculationForCzechRepublic() {
		// Provide valid input
		calculatorPage.selectOriginCountry("Sweden");
		calculatorPage.enterOriginPostalCode("10012");
		calculatorPage.selectDestinationCountry("Czech Republic");
		calculatorPage.enterDestinationPostalCode("60200");
		calculatorPage.clickCalculate();

		String successMessage = calculatorPage.getTransitTimeResultMessage();
		Assert.assertEquals(successMessage, "2/2 Transit Time Result");
		System.out.println("Test Passed: Success message displayed - " + successMessage);
	}

}

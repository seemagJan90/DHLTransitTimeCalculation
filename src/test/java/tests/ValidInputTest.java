package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidInputTest extends BaseTest {

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

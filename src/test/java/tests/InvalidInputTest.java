package tests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InvalidInputTest extends BaseTest {
    

    @Test
    public void testInvalidPostalCode() {
    	calculatorPage.acceptCookies();
    	calculatorPage.selectOriginCountry("Sweden");
        calculatorPage.enterOriginPostalCode(""); // Invalid input

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

    
}

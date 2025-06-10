package testCases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.SRPCarsPage;
import testBase.BaseClass;

public class TC005_SRPCarsTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void getTotalSearchResults() {
		logger.info("**** Starting TC005_SRPCarsTest ****");
	
		try {
	   // TC002_LoginTest login = new TC002_LoginTest();
		//login.verify_login();
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLogin();
		
		SRPCarsPage cars = new SRPCarsPage(driver);
		
		//Cookie cookie = new Cookie(prop.getProperty("cookieName"), prop.getProperty("cookieValue"));
	
		//driver.manage().addCookie(cookie);
		cars.clickMarketPlaceCarsTextLink();
		//cars.clickShowResultsBtn();
		String totalResults = cars.getTotalResults();
		
		
		 // Use regex to extract digits
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher( totalResults.replaceAll(",", ""));  // remove commas

        int number = 0;
        if (matcher.find()) {
            number = Integer.parseInt(matcher.group());
        }
		
		System.out.println(number);
		

		if(number > 1000) {
			AssertJUnit.assertTrue(true);
			
		}else {
			logger.error("Test failed...");
			logger.debug("Debug logs....");
			AssertJUnit.assertTrue(false);
		}
		
		//AssertJUnit.assertEquals(number, number);
		
		
		}catch(Exception e) {
			Assert.fail();
			
		}
		
		logger.info("**** Ending TC005_SRPCarsTest ****");
		
		
		
	}
	
}

package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test
	public void verify_account_registration() {
		
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
		
		try {
			//LoginPage hp = new LoginPage(driver);
			
			
			//hp.clickSignUp();
			
			//logger.info("Clicked on Sign Up Link...");
			
		
			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			
			regPage.clickSignUp();
			
			logger.info("Clicked on Sign Up Link...");
			
			logger.info("Providing user details.....");
			
			String email = "cegemba+"+randomString()+"@deseretdigital.com";
			regPage.setEmail(email);
			
			regPage.setFirstName(randomString().toUpperCase());
			regPage.setLastName(randomString().toUpperCase());
			
			regPage.setZipCode("84"+randomNumber());
			
			String password = randomAlphaNumeric();
			regPage.setPassword(password);
			regPage.setConfirmPassword(password);
			
			regPage.setCheckBox18();
			regPage.clickSubmit();
			
			
			logger.info("email" + email);
			logger.info("Password" + password);
			
			
			
			
			logger.info("Validating expected message.....");
			String confirmationMsg = regPage.getConfirmationMsg();
			
			
			
			if(confirmationMsg.equals("A verification email was sent to")) {
				AssertJUnit.assertTrue(true);
				
			}else {
				logger.error("Test failed...");
				logger.debug("Debug logs....");
				AssertJUnit.assertTrue(false);
			}
			//Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!");
			AssertJUnit.assertEquals(confirmationMsg, "A verification email was sent to");
			
		}catch(Exception e) {
			
			AssertJUnit.fail();
		}
		
	
		
		logger.info("**** Finished TC001_AccountRegistrationTest ****");
			
		
	}
	
	

}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test
	public void verify_login() {
		logger.info("******Starting TC_002_LoginTest");
		
		try {
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLogin();
			lp.clickProfileElement();
			//lp.clickLabel();
			boolean userIsLoggedIn = lp.isUserLoggedIn();
			Assert.assertEquals(userIsLoggedIn, true, "Login failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
		logger.info("******Finished TC_002_LoginTest");
	}

}

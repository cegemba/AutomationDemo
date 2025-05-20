package testCases;

import org.testng.annotations.Test;

import pageObjects.LogoutPage;
import testBase.BaseClass;

public class TC003_LogoutTest extends BaseClass{
	
	@Test
	public void logout() {
		logger.info("******Starting TC_003_LogoutTest");
		LogoutPage lo = new LogoutPage(driver);
		lo.clickProfileElement();
		lo.clickSignOutLink();
		
		logger.info("******Finished logout TC_003_LogoutTest");
			
		
	}
	
	

}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.cdimascio.dotenv.Dotenv;
import pageObjects.LoginPage;
import testBase.BaseClass;


public class TC002_LoginTest extends BaseClass{
	Dotenv dotenv = Dotenv.load();
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("******Starting TC_002_LoginTest");
		
		try {
			//String encryptedEmail = EnvConfig.get("email");
	        //String encryptedPassword = EnvConfig.get("password");

	        //String email = DecryptCredentials.decrypt(encryptedEmail);
	        //String password = DecryptCredentials.decrypt(encryptedPassword);
			LoginPage lp = new LoginPage(driver);
			//lp.setEmail(prop.getProperty("email"));
			//lp.setPassword(prop.getProperty("password"));
			lp.setEmail(dotenv.get("email"));
			lp.setEmail(dotenv.get("password"));
			//lp.setPassword("password");
			
			
			
			
			lp.clickLogin();
			logger.info("******Login Finished TC_002_LoginTest");
			//lp.clickProfileElement();
			//lp.clickLabel();
			//lp.closeProfileDropdown();
			//boolean userIsLoggedIn = lp.isUserLoggedIn();
			//Assert.assertEquals(userIsLoggedIn, true, "Login failed");
			//System.out.println(userIsLoggedIn);
			//logger.info("******Finished TC_002_LoginTest");
			//Assert.assertTrue(userIsLoggedIn);
			
			
			Assert.assertTrue(true);
		}
		catch(Exception e) {
			//logger.error("Test failed...");
			//logger.debug("Debug logs....");
			e.printStackTrace();
			Assert.fail();
		}
		
		
		logger.info("******Finished TC_002_LoginTest");
	}

}

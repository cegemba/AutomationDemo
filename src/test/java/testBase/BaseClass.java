package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import pageObjects.AccountRegistrationPage;
import pageObjects.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger; //Log4j2
	public Properties prop;
	
	
	@BeforeMethod
	@Parameters({"os", "browser"})
	public void setUp(String os, String browser) throws IOException {
		
		
		//Loading config.properties
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		
		
		logger= LogManager.getLogger(this.getClass()); //Log4j2	
		
		ChromeOptions options = new ChromeOptions(); //headless 
        options.addArguments("--headless=new");  // use "--headless" for older versions
        
        
		switch(browser.toLowerCase()) {
		
		case "chrome" : driver = new ChromeDriver(options); break;
		case "safari" : driver = new SafariDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default: System.out.println("Invalid browser name"); return;
		
		
		}
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url")); //reading url from properties file
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return generatedNumber;
	}
	
	
	
	public String randomAlphaNumeric()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return (generatedString+generatedNumber);
	}


}

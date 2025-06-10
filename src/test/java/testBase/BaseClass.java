package testBase;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v133.emulation.Emulation;
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

import com.google.common.base.Optional;

import pageObjects.AccountRegistrationPage;
import pageObjects.LoginPage;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger; //Log4j2
	public Properties prop;
	
	
	@BeforeMethod(groups= {"Sanity","Regression","Master"})
	@Parameters({"os", "browser"})
	public void setUp(String os, String browser) throws IOException {
		
		
		//Loading config.properties
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		
		
		logger= LogManager.getLogger(this.getClass()); //Log4j2	
	
		ChromeOptions options = new ChromeOptions(); //headless 
        options.addArguments("--headless=new");  // use "--headless" for older versions
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-notifications");
		//options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        
      //driver=new ChromeDriver();
		switch(browser.toLowerCase()) {
		
		case "chrome" : driver = new ChromeDriver(options); break;
		case "safari" : driver = new SafariDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default: System.out.println("Invalid browser name"); return;
		
		
		}
		//driver=new ChromeDriver();
		//SeleniumStealth stealth = new SeleniumStealth();
       // stealth.apply(driver);
		// Use DevTools to spoof WebDriver and other settings
 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url")); //reading url from properties file
		
		
		
	}
	
	
	@AfterMethod(groups= {"Sanity","Regression","Master"})
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
	
	public String captureScreen(String testName) throws IOException{
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + testName + "_" + timeStamp;
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
	}


}

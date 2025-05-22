package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SRPCarsPage extends BasePage  {

	public SRPCarsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	//@FindBy(xpath="//a[span[text()='Cars']]")WebElement txtLinkMarketPlaceCars; //Cars texts link on homepage
	@FindBy(xpath="(//a[@href=\"https://cars.ksl.com/?c=1\" and span[text()=\"Cars\"]])[1]\n"
			+ "") WebElement txtLinkMarketPlaceCars; 
	
	
	@FindBy(xpath="//button[contains(., 'Show') and contains(., 'result')]") WebElement btnShowResults; 
	@FindBy(xpath="//div[@class=\"font-bold hidden sm:flex\" and contains(text(), \"results\")]")WebElement txtTotalResults;
	
	
	Actions actions = new Actions(driver);
	
	public void clickMarketPlaceCarsTextLink() {
		
		// Then navigate to your target page
		
		driver.get("https://cars.ksl.com/v2/search/sort/0");
		//driver.get("https://cars.ksl.com/?c=1");
		

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		//txtLinkMarketPlaceCars.click();
	}
	
	/*
	 * public void clickShowResultsBtn() { btnShowResults.click();
	 * //((JavascriptExecutor) driver).executeScript(
	 * "document.querySelector('.popup-class').style.display='none';");
	 * 
	 * }
	 */
	
	
	public String getTotalResults() {
		return txtTotalResults.getText();
	}
	
	

}




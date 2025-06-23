package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class SRPClassifiedsPage extends BasePage {
	
	public SRPClassifiedsPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="https://classifieds.ksl.com/v2/search/sort/0") WebElement txtLinkMarketPlaceClassifieds;
	
	@FindBy(xpath="//div[@class=\"font-bold hidden sm:flex\" and contains(text(), \"results\")]")WebElement txtTotalResults;
	
	public void clickMarketPlaceClassifiedsTextLink() {
		
		// Then navigate to your target page
		
		driver.get("https://classifieds.ksl.com/v2/search/sort/0");
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

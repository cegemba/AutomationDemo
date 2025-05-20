package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[contains(@class, 'ksl-header-account-toggle--logged-in')]")WebElement profileElement;
	
	@FindBy(xpath="//div[@id='kslHeader']//a[text()='Sign Out']") WebElement signOutElement;
	
	public void clickProfileElement() {
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		profileElement.click();
	}
	
	
	public void clickSignOutLink() {
		
		signOutElement.click();
	}
	

}

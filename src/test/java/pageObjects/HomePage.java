package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)  {
		
		super(driver);
		
	}
	
	
	
	
	@FindBy(xpath="//strong[text()[normalize-space(.) = \"SIGN UP\"]]") WebElement linkSignUp;
	
	
	/**@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement linkMyAccount; 
	
	
	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement linkRegister ;
	
	
	
	public void clickMyAccount() {
		
			linkMyAccount.click();
		
	}
	
	public void clickRegister() {
		
		linkRegister.click();		
	}**/
	
	
public void clickSignUp() {
		
	linkSignUp.click();		
	}
	

}

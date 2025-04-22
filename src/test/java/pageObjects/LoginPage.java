package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)  {
		
		super(driver);
		
	}
	
	
	
	
	//@FindBy(xpath="//strong[text()[normalize-space(.) = \"SIGN UP\"]]") WebElement linkSignUp;
	
	
	@FindBy(xpath="//input[@name='email']")WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='password']")WebElement txtPassword;
	@FindBy(xpath="//button[text()='Login']")WebElement btnLogin;
	//@FindBy(xpath="//button[@aria-haspopup='true' and @aria-labelledby='ksl-header-account-label'][1]")WebElement btnAccountLabel;
	
	@FindBy(xpath="//span[contains(@class, 'ksl-header-account-toggle--logged-in')]")WebElement profileElement;
	
	
	@FindBy(xpath="//div[@class=\"ksl-header-nav-item__split\"]/a[contains(text(), \"Welcome\")]") WebElement textElement;
	
	
	
	public void setEmail(String email) {
			
		txtEmail.sendKeys(email);
		
		}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
		
	}
	
	
	
	
	
	public void clickProfileElement() {
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		profileElement.click();
	}
	
	//WebElement profileElement = driver.findElement(By.xpath("//span[contains(@class, 'ksl-header-account-toggle--logged-in')]"));
 
    
    
    public boolean isUserLoggedIn() {
    	
    	try {
    		
    		return textElement.getText().contains("Welcome");
    		
    	}catch(Exception e) {
    		
    		return false;
    	}
    	 
      	 
    	
    }
    
    //@FindBy(xpath="//div[@class=\\\"ksl-header-nav-item__split\\\"]/a[contains(text(), \\\"Welcome\\\")]") WebElement textElement ;
    

	/*public void clickLabel() {
		btnAccountLabel.click();
		
	}*/
	
		
	
	}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	@FindBy(xpath="//strong[text()[normalize-space(.) = \"SIGN UP\"]]") WebElement linkSignUp;
	
	
	
	@FindBy(xpath="//input[@name='email']")WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='firstName']")WebElement txtFirstname;
	
	@FindBy(xpath="//input[@name='lastName']")WebElement txtLastname;
	
	@FindBy(xpath="//input[@name='zip']")WebElement txtZip;
	
	//@FindBy(xpath="//input[@id='input-telephone']")WebElement txtTelephone;
	
	@FindBy(xpath="//input[@name='password']")WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='confirmPassword']")WebElement txtConfirmPassword;
	
	//@FindBy(xpath="//input[@name='check18']")WebElement checkedBox18;
	@FindBy(xpath="//div[text()='I am at least 18 years old (required)']")WebElement checkedBox18;
	
	
	
	@FindBy(xpath="//button[contains(.,'Submit')]") WebElement btnSubmit;


	@FindBy(xpath="//div[text()='A verification email was sent to']") WebElement confirmationMsg;
	
	
	
	public void clickSignUp() {
		
		linkSignUp.click();		
		}
	public void setFirstName(String fname) {
		
		txtFirstname.sendKeys(fname);
		
	}
	
	public void setLastName(String lname) {
			
			txtLastname.sendKeys(lname);
			
		}
	
	
	public void setEmail(String email) {
		
		txtEmail.sendKeys(email);
		
		
	}
	
	
	
	
	public void setZipCode(String zip) {
			
			txtZip.sendKeys(zip);
			
		}
	
	
	
	public void setPassword(String pwd) {
			
			txtPassword.sendKeys(pwd);
			
		}
	
	
	
	public void setConfirmPassword(String pwd) {
		
		txtConfirmPassword.sendKeys(pwd);
		
	}

	
	public void setCheckBox18() {
		
		checkedBox18.click();
		
	}
	
	
	public void clickSubmit() {
			
			btnSubmit.click();
			
		}
	

	
	public String getConfirmationMsg() {
		try {
			return (confirmationMsg.getText());
			
		}catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	
	
	
	

}

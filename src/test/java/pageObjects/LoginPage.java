package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)  {
		
		super(driver);
		
	}
	
	
	
	
	
	
	
	@FindBy(xpath="//input[@name='email']")WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='password']")WebElement txtPassword;
	@FindBy(xpath="//button[text()='Login']")WebElement btnLogin;
	
	
	//@FindBy(xpath="//div[@class='ksl-header-nav-item__split']/a[contains(text(), 'Welcome')]") WebElement textElement;
	
	@FindBy(xpath="//a[contains(text(), 'Welcome')]") WebElement textElement;
	
	
	
	
	
	public void setEmail(String email) {
			
		txtEmail.sendKeys(email);
		
		}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();

			
	}
	
	
	
	
	
	/*
	 * public void clickProfileElement() throws InterruptedException {
	 * driver.manage().window().setSize(new Dimension(2136, 1489));
	 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	 * driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
	 * 
	 * 
	 * try { Alert alert = driver.switchTo().alert(); alert.dismiss(); // or
	 * alert.accept(); } catch (NoAlertPresentException ignored) {}
	 * 
	 * 
	 * 
	 * WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
	 * .until(ExpectedConditions.elementToBeClickable(By.
	 * xpath("//span[contains(@class, 'ksl-header-account-toggle--logged-in')]")));
	 * //driver.manage().window().maximize(); //driver.manage().window().setSize(new
	 * Dimension(2136, 1489));
	 * 
	 * Actions actions = new Actions(driver);
	 * actions.moveToElement(element).pause(Duration.ofMillis(500)).perform();
	 * 
	 * 
	 * //driver.manage().deleteAllCookies();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	 * textElement.click();
	 * 
	 * 
	 * 
	 * //profileElement.click(); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public boolean isUserLoggedIn() {
	 * 
	 * //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * //WebElement link =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
	 * xpath("div[@class='ksl-header-nav-item__split']/a[contains(text(), 'Welcome')"
	 * )));
	 * 
	 * try {
	 * 
	 * //System.out.println(textElement.getText().contains("Welcome")); return
	 * textElement.getText().contains("Welcome"); //return
	 * link.getText().contains("Welcome");
	 * 
	 * }catch(Exception e) {
	 * 
	 * return false; }
	 * 
	 * 
	 * 
	 * }
	 */
    

	
		
	
	}
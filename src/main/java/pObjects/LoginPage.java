package pObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestBase;

public class LoginPage extends TestBase
{
	//Object Repository
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement loginpanel;
	@FindBy(className="nav-action-signin-button") WebElement loginbutton;
	@FindBy(id="ap_email") WebElement username; 
	@FindBy(id="ap_password") WebElement password;
	@FindBy(id="continue") WebElement next1;
	
	//Initialization the page object
	public LoginPage()
	{
		PageFactory.initElements(TestBase.driver, this);
	}
	
	//public methods for step definition
	
	public void clickLogin()
	{
		WebElement loginpanel=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		WebElement loginbutton=driver.findElement(By.className("nav-action-signin-button"));
		Actions action= new Actions(driver);
		System.out.println("OK - i am in clickLogin Method");
		action.moveToElement(loginpanel).build().perform();
		loginbutton.click();
		
	}
	public void lognDetails(String un, String pw)
	{
		System.out.println("adding login details");
		WebElement username=driver.findElement(By.cssSelector("#ap_email"));
		System.out.println("clicked");
		username.sendKeys(un);
		
		WebElement next1= driver.findElement(By.id("continue"));
		next1.click();
		
		WebElement password=driver.findElement(By.cssSelector("#ap_password"));
		password.sendKeys(pw);
		
		WebElement signin= driver.findElement(By.cssSelector("#signInSubmit"));
		signin.click();
		
	}
	
	public String validateHomePage()
	{
		return driver.getTitle();
	}
}



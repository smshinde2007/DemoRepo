package StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pObjects.HomePage;
import pObjects.LoginPage;
import utility.TestBase;

public class loginSteps extends TestBase
{	
	  LoginPage loginpage= new  LoginPage();
	  HomePage homepage;

	@Given("user is on login page")
	public void user_is_on_login_page()
	{
		TestBase.initilization();
		System.out.println("Open browser done");
		loginpage.clickLogin();  
	}

	@When("user enter username and password")
	public void user_enter_username_and_password()
	{
		System.out.println("I am in entter username step definition");
		loginpage.lognDetails(prop.getProperty("name"), prop.getProperty("pass"));
	}

	@Then("user is navigate to home page")
	public void user_is_navigate_to_home_page() 
	{
		String title= loginpage.validateHomePage();
		Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", title);
		System.out.println("Title validated successfully");
		
	}




}

package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	
	public static WebDriver driver;
	
	@Given("^Parasoft broswer is launched$")
	public void parasoft_broswer_is_launched() {
		//System.out.println("Launch Browser 1");
		WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
			
	}

	@When("^user is on home page$")
	public void user_is_on_home_page() {
		String Actual_Title = "ParaBank | Welcome | Online Banking";
		String Expected_Title = driver.getTitle();
	    Assert.assertEquals(Actual_Title, Expected_Title);

	}

	@Then("^user can see login button$")
	public void user_can_see_login_button(){
		Boolean boolButton = driver.findElement(By.cssSelector("input.button")).isDisplayed();
	    Assert.assertTrue(boolButton, "Login button not present");
	}

	@Given("^User is in Login screen$")
	public void user_is_in_Login_screen() {
		System.out.println("user_is_in_login_screen");
		
		System.out.println(driver.getTitle());
	
	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_username_as_and_password_as(String arg1,String arg2) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(arg1);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arg2);
		driver.findElement(By.cssSelector("input.button")).click();		
	}

	@Then("^User is logged in successfully$")
	public void user_is_logged_in_successfully(){
		String Actual_Title = "ParaBank | Accounts Overview";
		String Expected_Title = driver.getTitle();
	    Assert.assertEquals(Actual_Title, Expected_Title);
	
	}

	@Then("^User logs out$")
	public void user_logs_out() {
		driver.findElement(By.linkText("Log Out")).click();
	  
	}



}

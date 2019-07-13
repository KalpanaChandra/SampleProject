package LearnTestNG;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Practice1 extends LearnTestNG.BaseClass{
	
	//public static WebDriver driver;
	
//	@BeforeTest
//	//launch browser and open url
//	public void LaunchBrower()
//	{
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("http://www.way2automation.com/");	
//	}
	
	@Test(priority=1)
	public void OpenRegForm() throws Exception
	{
		BaseClass.SetUp();
		driver.findElement(By.xpath(OR.getProperty("Resources_xPath"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//a[text()='Practice site 2']")).click();
		
		String strExpectedTitle = "Protractor and AngularJS practice - sample website";
		String strActualTitle = driver.getTitle();
		//System.out.println(strActualTitle);
		
		Assert.assertEquals(strActualTitle, strExpectedTitle);
	}
	
	@Test(priority=2)
	public void OpenBankApp()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@src='demo/images/bank.jpg']")).click();
	
		String parentHandle = driver.getWindowHandle();
		Set<String> strhands = driver.getWindowHandles();
	for(String strhand:strhands)
	{
		if(!strhand.equals(parentHandle))
		{
			driver.switchTo().window(strhand);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		//System.out.println(strhand);
	}
		//intentionally added 'aaa' to fail the test case
		String strExpectedTitle = "Protractor practice website - Banking App";
		String strActualTitle = driver.getTitle();
		System.out.println(strActualTitle);
		System.out.println("before assertion");
		Assert.assertEquals(strActualTitle, strExpectedTitle);
		System.out.println("ending the test");
	}
	
	@Test(priority=3)
	public void CustomerLogin()
	{
		driver.findElement(By.xpath(".//div/button[@class = 'btn btn-primary btn-lg' and text()='Customer Login']")).click();
		
		Boolean boolPresent = driver.findElement(By.xpath(".//label[text()='Your Name :']")).isDisplayed();
		System.out.println("---" + boolPresent);
		SoftAssert softAssrt = new SoftAssert();
		softAssrt.assertEquals(boolPresent, true);
		
		Select drpdown = new Select(driver.findElement(By.id("userSelect")));
		drpdown.selectByValue("4");
		
		driver.findElement(By.cssSelector("button.btn.btn-default")).click();
	}
	
	
	/*@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	*/
	
	
}

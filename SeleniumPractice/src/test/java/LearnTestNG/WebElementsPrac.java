package LearnTestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class WebElementsPrac {
	
	public static WebDriver driver;
	public Boolean bool;
	public static Properties OR;
	public static Properties Config;
	public static FileInputStream fs;
	
	@BeforeTest
	public void StartBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","E://Selenium//SeleniumPracr//SeleniumPractice//Executables//chromedriver.exe");
		driver = new ChromeDriver();
		
		//System.out.println(System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");
		driver.get("http://the-internet.herokuapp.com/");
		
		OR = new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//Properties//OR.properties");
			OR.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void AddRemoveElements()
	{
		driver.findElement(By.linkText("Add/Remove Elements")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add Element')]")).click();
		//verify add element
		WebElement btnDelete = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		//System.out.println(btnDelete.getText());
		Assert.assertEquals("Delete",btnDelete.getText());
		
		//verify delete element
		btnDelete.click();
		
		try
		{
			btnDelete.isDisplayed();
			bool = true;
		}catch(Exception e)
		{
			bool = false;
		}
		//System.out.println(bool);
		Assert.assertFalse(bool);
		
	}
	
	@Test
	public void BasicAuth()
	{
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.xpath(OR.getProperty("BasicAuth_xPath"))).click();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	}
	
	@Test
	public void BrokenImages()
	{
		driver.navigate().back();
		driver.findElement(By.xpath(OR.getProperty("BrokenImages_xPath"))).click();
		
	}
//	@AfterTest
//	public void teardown()
//	{
//		driver.close();
//	}
}

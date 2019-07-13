package LearnTestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	
	//@BeforeTest
	public static void SetUp() throws IOException
	{
		fis = new FileInputStream((System.getProperty("user.dir")) + "\\src\\test\\resources\\Properties\\Config.properties");
		Config.load(fis);
		
		fis = new FileInputStream((System.getProperty("user.dir")) + "\\src\\test\\resources\\Properties\\OR.properties");
		OR.load(fis);
		
		if(Config.getProperty("browser")=="chrome")
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(Config.getProperty("website"));	
		}
	}
	
	
}

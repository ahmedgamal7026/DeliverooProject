package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	
	public WebDriver driver;
	

	@Parameters({"Browser"})
	@BeforeSuite
	public void Setup(@Optional ("Chrome")String BrowserName)
	
	{
		
		if (BrowserName.equalsIgnoreCase("Chrome")) 
		{
			String chromepath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",chromepath );
			driver = new ChromeDriver();
			
		} 
		
		else 
		{
			String Firefoxpath = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",Firefoxpath );
			driver = new FirefoxDriver();
		}
		
		driver.get("https://deliveroo.it/en/");
		driver.manage().window().maximize();
		
		
	}
	
	@AfterSuite
	public void TearDown()
	{
		
		driver.quit();
	}

}

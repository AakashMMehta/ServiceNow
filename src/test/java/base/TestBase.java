package base;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class TestBase
{
	protected WebDriver driver;
	@BeforeSuite
	public void open() 
	{
		driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.manage().window().maximize();
		PropertyConfigurator.configure("log4j.properties");
	}
	/*@AfterSuite
	public void closeWindow() {
		driver.quit();
	}*/
}

package pages;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;

public class HomePage extends PageBase{
	
	@FindBy(id="filter")
	public WebElement  Filter;

	@FindBy(css="#\\39 c9a1f390a0a3c74013288b0639f0806 > div:nth-child(1) > div")
	public WebElement  Published;
		
	Logger logger=Logger.getLogger("HomePage");
	
	public HomePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public Published onPClick() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Filter.sendKeys("Knowledge Base");
		logger.info("Entered Knowledge Base in Search Option");
		Published.click();
		logger.info("Clicked on Publish");
		//String script = "return window.getComputedStyle(document.querySelector('a.list_filter_toggle icon-filter btn btn-icon'),':before').getPropertyValue('content');";
		
		return new Published(driver);
	}
}

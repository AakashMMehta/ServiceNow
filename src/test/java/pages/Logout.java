package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;

public class Logout extends PageBase{

	Logger logger=Logger.getLogger("Logout");
	
	public Logout(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	public void LogoutServiceNow() {
		driver.switchTo().defaultContent();
		driver.findElement(By.id("user_info_dropdown")).click();
		driver.findElement(By.linkText("Logout")).click();
		logger.info("Clicked on Logout");
	}
	
	
}

package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ClearLog;
import utils.ScreenSnap;
import base.PageBase;


public class LoginPage extends PageBase  {
	@FindBy(id="user_name")
	public WebElement  UserName;
	
	@FindBy(id="user_password")
	public WebElement  Password;
	
	@FindBy(id="sysverb_login")
	public WebElement loginButton;
	
	Logger logger=Logger.getLogger("LoginPage");
	
	ClearLog tut=new ClearLog();
	
	public LoginPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public HomePage onLogin(String sUserName, String sPassword) throws InterruptedException
	{
		try {
			tut.rollLogFile(logger);
			UserName.sendKeys(sUserName);
			logger.info("Username entered");
			Password.sendKeys(sPassword);
			logger.info("Password entered");
			ScreenSnap.takeSnapShot(driver,"D:\\ServiceNow\\SeleniumAutomation\\Screenshot\\Login.png") ;
			loginButton.click();
			logger.info("Login button Clicked");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage(driver);
	}
	
}

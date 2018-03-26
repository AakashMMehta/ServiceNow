package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.PageBase;
import utils.ScreenSnap;

public class Published extends PageBase {

	@FindBy(id = "kb_knowledge_filter_toggle_image")
	public WebElement Find;

	@FindBy(id = "select2-chosen-4")
	public WebElement StateSelector;

	@FindBy(id = "s2id_autogen4_search")
	public WebElement SearchStateSelector;
	
	@FindBy(xpath ="//*[@class=\'select2-match\']")
	public WebElement SelectorLink;
	
	@FindBy(xpath ="//*[@type=\"workflow\"]//*[@id=\"oper\"]/select")
	public WebElement FirstOperatorSelector;
	
	@FindBy(xpath ="//*[@type=\"workflow\"]//*[@id=\"value\"]/select")
	public WebElement FirstInputSelector;
	
	@FindBy(xpath ="//*[@type=\"workflow\"]//td[@class=\'sn-filter-top condition_buttons_cell\']/button")
	public WebElement FirstAND;
	
	@FindBy(id = "select2-chosen-139")
	public WebElement SecondStateSelector;
	
	@FindBy(id = "s2id_autogen139_search")
	public WebElement SecondSearchStateSelector;
	
	@FindBy(xpath ="//*[@type=\"boolean\"]//*[@id=\"oper\"]/select")
	public WebElement SecondOperatorSelector;
	
	@FindBy(xpath ="//*[@type=\"boolean\"]//*[@id=\"value\"]/select")
	public WebElement SecondInputSelector;
	
	@FindBy(xpath ="//*[@type='boolean']//td[@class='sn-filter-top condition_buttons_cell']/button")
	public WebElement SecondAND;
	
	@FindBy(id = "select2-chosen-283")
	public WebElement ThirdStateSelector;
	
	@FindBy( id ="s2id_autogen283_search" )
	public WebElement ThirdSearchStateSelector;
	
	@FindBy(xpath ="//*[@type=\"reference\"]//*[@id=\"oper\"]/select")
	public WebElement ThirdOperatorSelector;
	
	@FindBy(xpath ="//*[@type=\"reference\"]//*[@class=\"pull-left form-control filter-reference-input\"]")
	public WebElement ThirdInputSelector;
	
	@FindBy(xpath ="//*[@type=\"keyword\"]//button[@onclick=\"runThisFilter(this);\"]")
	public WebElement Run;
	
	@FindBy(xpath ="//*[@class='input-group-addon input-group-select']//select")
	public WebElement GoToSelect;

	@FindBy(xpath ="//*[@class='input-group']//input")
	public WebElement GoToText;
	
	@FindBy(xpath ="//*[@class=\"linked formlink\"]")
	public WebElement ClickOnFirstArticle;
	
	@FindBy(id="clone_click_action")
	public WebElement purposeModification;
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	Logger logger = Logger.getLogger("Published");
	public Published(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Test
	public Purpose_Modification OnPublished() throws InterruptedException {
		
		try {
			driver.switchTo().frame("gsft_main");
			Select GoToDropdown=new Select(GoToSelect);
			GoToDropdown.selectByValue("number");
			GoToText.sendKeys("KB0000027");
			GoToText.sendKeys(Keys.RETURN);
			logger.info("KB article searched");
			ClickOnFirstArticle.click();
			logger.info("Selected KB article");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clone_click_action")));
			String verify_Propose_Modification=purposeModification.getText();
			Assert.assertEquals(verify_Propose_Modification, "Propose Modification");
			logger.info("Propose Modification button verified");
			ScreenSnap.lele(driver,"D:\\ServiceNow\\SeleniumAutomation\\Screenshot\\Propose_Modification.png");
			logger.info("SnapShot Taken for Purpose Modification");
			purposeModification.click();
			logger.info("Clicked on Purpose Modification");
			/*Find.click();
			logger.info("Clicked on Filter Icon");*/
			
			//First DropDown 
			
			/*StateSelector.click();
			SearchStateSelector.sendKeys("Number");
			SelectorLink.click();
			logger.info("Selected Number");
			Select chooseOperator = new Select(FirstOperatorSelector);
			chooseOperator.selectByVisibleText("is");
			logger.info("Selected is");
			Select chooseInput = new Select(FirstInputSelector);
			chooseInput.selectByVisibleText("Published");
			logger.info("Selected KB0000977");*/
			/*FirstAND.click();
			logger.info("Clicked on AND");*/
			
			//Second DropDown Handling
			
			/*SecondStateSelector.click();
			SecondSearchStateSelector.sendKeys("Clone In Progress");
			SelectorLink.click();
			logger.info("Selected Clone In Progress");
			
			Select chooseOperator2 = new Select(SecondOperatorSelector);
			chooseOperator2.selectByVisibleText("is");
			logger.info("Selected is");
			
			Select chooseInput2 = new Select(SecondInputSelector);
			chooseInput2.selectByVisibleText("false");
			logger.info("Selected false");
			
			SecondAND.click();
			logger.info("Clicked on AND");
			
			
			//Third DropDown Handling
			
			ThirdStateSelector.click();
			ThirdSearchStateSelector.sendKeys("Knowledge Owner");
			SelectorLink.click();
			logger.info("Selected Knowledge Owner");
			
			Select chooseOperator3 = new Select(ThirdOperatorSelector);
			chooseOperator3.selectByVisibleText("is");
			logger.info("Selected is");
			
			ThirdInputSelector.sendKeys("Support01, Test");
			ThirdInputSelector.sendKeys(Keys.RETURN);
			logger.info("Sent Support01, Test");*/
			
			/*Run.click();
			logger.info("Clicked on Run");*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Purpose_Modification(driver);
	}
}

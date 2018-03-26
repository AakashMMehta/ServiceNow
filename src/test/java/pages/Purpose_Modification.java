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

import base.PageBase;

public class Purpose_Modification extends PageBase  {

	@FindBy(id = "kb_knowledge.u_submission_type")
	public WebElement SelectSubmissionType;
	
	@FindBy(id = "kb_knowledge.topic")
	public WebElement SelectTopic;
	
	@FindBy(id = "kb_knowledge.category")
	public WebElement SelectCategory;
	
	@FindBy(id = "sys_display.kb_knowledge.cmdb_ci")
	public WebElement ConfigurationItem;
	
	@FindBy(id = "kb_knowledge.u_audit_cycle")
	public WebElement SelectAuditCycle;
	
	@FindBy(id = "kb_knowledge.short_description")
	public WebElement short_description;
	
	@FindBy(id = "tinymce")
	public WebElement Text;
	
	@FindBy(id = "submit_click")
	public WebElement submit;
	
	@FindBy(id = "kb_knowledge.u_comment")
	public WebElement Comment;
	
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	Logger logger = Logger.getLogger("Purpose_Modification");

	public Purpose_Modification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public Logout OnPurposeModification(){
		Select submission_type = new Select(SelectSubmissionType);
		submission_type.selectByVisibleText("Full Audit");
		logger.info("Full Audit selected from Submission Type");
		Select topic = new Select(SelectTopic);
		topic.selectByVisibleText("L2Ops");
		logger.info("L2Ops selected from Topic");
		Select Category = new Select(SelectCategory);
		Category.selectByVisibleText("Unlisted");
		logger.info("Unlisted selected from Category");
		ConfigurationItem.sendKeys("UNLISTED CI");
		ConfigurationItem.sendKeys(Keys.RETURN);
		logger.info("Unlisted CI inserted in Configuration Item");
		Select auditCycle = new Select(SelectAuditCycle);
		auditCycle.selectByVisibleText("One Year");
		logger.info("One Year selected from Audit Cycle");
		short_description.sendKeys("test");
		logger.info("Short Description provided");
		driver.switchTo().frame(driver.findElement(By.id("kb_knowledge.text_ifr")));
		Text.sendKeys(Keys.PAGE_DOWN);
		Text.sendKeys(Keys.END);
		Text.sendKeys(" Test");
		logger.info("Text provided");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		submit.click();
		logger.info("Clicked on Submit");
		driver.switchTo().alert().accept();
		Comment.sendKeys("Testing for the Partial Audit Submission Type");
		logger.info("Comments provided");
		submit.click();
		logger.info("Clicked on Submit");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"linked formlink\"]")));
		return new Logout(driver);
	}

}

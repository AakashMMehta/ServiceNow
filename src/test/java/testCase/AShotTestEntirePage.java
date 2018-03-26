package testCase;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScreenSnap;


public class AShotTestEntirePage {
	ScreenSnap pickaboo=new ScreenSnap();
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.bbc.com");
        
       
        Thread.sleep(10000);
        ScreenSnap.lele(driver,"D:\\ServiceNow\\SeleniumAutomation\\Screenshot\\"+ "AShot_BBC_Entire.png" );

        driver.quit();
    }
}
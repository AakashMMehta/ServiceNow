package testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utils.DataExcel;
import utils.ExcelUtils;

public class Knowledge_Owner_rejects_modification extends TestBase {

	LoginPage page;
	
	String workbookname = "R.xlsx";
	
	String sheetName = "A";
	
	private String sTestCaseName;

	private int iTestCaseRow;

	@BeforeClass
	public void beforeClass() {

		try {

			//RunBatchProcess.startGrid();

			if (System.getProperty("app.integrationapplysheetname") == null) {

				System.setProperty("app.integrationapplysheetname", sheetName);

				System.setProperty("app.workbookname", workbookname);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}  

	@Test(dataProvider = "Authentication")
	public void TestLogin(String sUserName, String sPassword) throws Exception {
		try {
			for (int i = 0; i <= 1; i++) {
				driver.get("https://corningtest.service-now.com/login.do");
				// Runtime.getRuntime().exec("E:\\Softwares\\Testing\\FileIUploadAutoit.exe");
				// Runtime.getRuntime().exec("D:\\ServiceNow\\SeleniumAutomation\\hub.exe");
				page = new LoginPage(driver);
				switch(i)
				{
				case 0 : page.onLogin(sUserName, sPassword).onPClick().OnPublished().OnPurposeModification().LogoutServiceNow();break;
				case 1 : page.onLogin(sPassword, sPassword);
				}
				 

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*@DataProvider(name = "Authentication")

	public Object[][] toolingDataProvider() {

		Object[][] data = null;

		try {

			data = DataExcel.getTableArray(System.getProperty("app.workbookname"),

					System.getProperty("app.integrationapplysheetname"));

			
			
			System.out.println("Data Fetching Is Done");

		} catch (Exception e) {

			System.out.println("Error when fetching data from Dataprovider " + e);

		}

		return data;

	}*/
	@DataProvider(name = "Authentication")

	  public Object[][] Authentication() throws Exception{

		    // Setting up the Test Data Excel file

		 	ExcelUtils.setExcelFile("D:\\ServiceNow\\SeleniumAutomation\\resources\\R.xlsx","A");

		 	sTestCaseName = this.toString();

		  	// From above method we get long test case name including package and class name etc.

		  	// The below method will refine your test case name, exactly the name use have used

		  	sTestCaseName = ExcelUtils.getTestCaseName(this.toString());

		    // Fetching the Test Case row number from the Test Data Sheet

		    // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

		 	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);

		    Object[][] testObjArray = ExcelUtils.getTableArray("D:\\ServiceNow\\SeleniumAutomation\\resources\\R.xlsx","A",iTestCaseRow);

		    	return (testObjArray);

			}

	

	
	 @AfterMethod
	 
	 public void afterMethod() {
	 
	 driver.close();
	  
	 }
}
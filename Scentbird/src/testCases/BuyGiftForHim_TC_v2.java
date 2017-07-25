package testCases;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;	

import pageObject.*;
import utility.*;
	//import appModule.*;

public class BuyGiftForHim_TC_v2 {
	
	public WebDriver driver;
    private String sTestCaseName;   
    private int iTestCaseRow;
    String sBrowserName;
    Gift_Page Gift_Page;
    
	@BeforeMethod
	public void beforeMethod() throws Exception {
    	// Provide Log4j configuration settings
   	 
		DOMConfigurator.configure("log4j.xml");
		
		sTestCaseName = this.toString();
		 
        sTestCaseName = Utils.getTestCaseName(this.toString());

        Log.startTestCase(sTestCaseName);
		
        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
        
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
 
        driver = Utils.openBrowser(iTestCaseRow);        
        
		// Initializing the PageObject for Selenium driver
 
		new PageObject(driver);
		Gift_Page = new Gift_Page(driver);
		
	}
	
	@Test
	public void main() throws Exception {
		
		try{
			Gift_Page.clickBuyGiftNow();
		
			Thread.sleep(2000);

			Gift_Page.btn_BuyForHim.click();

			Log.info("Buy For Him button clicked");
			
			if(PageObject.bResult==true){
				 
				// If the value of boolean variable is True, then test is complete pass and do this
	 
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
	 
			}else{
	 
				// If the value of boolean variable is False, then test is fail
	 
				// This is to throw exception in case of fail test, this exception will be caught by catch block below
	 
				throw new Exception("Test Case Failed because of Verification");
			}
			}catch (Exception e){
			 
			  // If in case you got any exception during the test, it will mark test as Fail in the test result sheet
	 
			  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
	 
			  // If the exception is in between the test, bcoz of any element not found or anything, this will take a screen shot
	 
			  Utils.takeScreenshot(driver, sTestCaseName);
	 
			  // This will print the error log message
	 
			  Log.error(e.getMessage());
	 
			  // Again throwing the exception to fail the test completely in the TestNG results
	 
			  throw (e);
	 
		  }
		}

   @AfterMethod   	 
    public void afterMethod() {
   	 
		// Printing beautiful logs to end the test case
	   
	    Log.endTestCase(sTestCaseName);
   }
   
	@AfterSuite
	public void tearDown()
	{
		BrowserFactory.closeAllDriver();
	}
}

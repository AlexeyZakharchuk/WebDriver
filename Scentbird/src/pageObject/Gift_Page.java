package pageObject;
	
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.*;
	
public class Gift_Page extends PageObject{

	@FindBy(id="buyGiftNow")
	public WebElement buyGiftNow;
	
	@FindBy(id="buyForHim")
	public WebElement btn_BuyForHim;
	
	@FindBy(id="buyForHer")
	public WebElement btn_BuyForHer;
	
	@FindBy(className="_1zIn")
	public WebElement frame_BuyForHim;
	
    public Gift_Page(WebDriver driver) {	
    	super(driver);
    	assertTrue(buyGiftNow.isDisplayed());
	}
 
  	public boolean isInitialized() {
		return buyGiftNow.isDisplayed();
   }
    
	public void clickBuyGiftNow(){	 
		 buyGiftNow.click();
		 Log.info("Buy Gift Now button clicked");		 
	}     
}

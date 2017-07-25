package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageObject {
	protected WebDriver driver;
	public static boolean bResult;
		
	public PageObject(WebDriver driver){
		this.driver = driver;
		PageObject.bResult = true;
		
		//Here, when an operation is performed on an element the wait for its visibility starts
		//from that moment only. If the element is not found in the given time interval, test 
		//case execution will throw 'NoSuchElementException' exception. 
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		
		PageFactory.initElements(factory, this);
	}
}

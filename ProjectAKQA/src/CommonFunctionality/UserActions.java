package CommonFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserActions extends Configfile{

/*****************************************************************************************************************************************
	*	Method            : OpenChromeBrowser
	*  Arguments 		  : url	
	*  Return value 	  : r_chromeDriver
	*  Method Description : This method will launch the Chrome browser and use given Url
	* Date Created        : 10/08/2019
	* Author              : Kirti Vikas
	*
*****************************************************************************************************************************************/
	public WebDriver OpenChromeBrowser(String URL)throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}	

/*****************************************************************************************************************************************
	 *	Method            : NavigateToUrl(String URL,WebDriver driverThread,ExtentTest logger)
	 *  Arguments 		  :	
	 *  Return value 	  : 
	 *  Method Description: This method will navigate to given Url 
	 * Date Created       : 10/08/2019
	 * Author             : Kirti Vikas
	 *
*****************************************************************************************************************************************/
	public void NavigateToUrl(String URL, WebDriver driverThread, ExtentTest logger) throws Exception {
		driverThread.get(URL);
		logger.log(LogStatus.INFO, "Logged in to URL :" + URL);
	}
	
	
/******************************************************************************************************************
	 *	Method             : Click(String t_objProp,WebDriver driverThread,ExtentTest logger)
	 *  Arguments 		   : t_objProp	
	 *  Return value 	   : 
	 *  Method Description : This method will click on the web element  
	 *  Date Created       : 10/08/2019
	 *  Author             : Kirti Vikas
	 *
********************************************************************************************************************/
	public  void Click(String t_objProp,WebDriver driverThread,ExtentTest logger) throws Exception {
		String Loctaor = GetJsonObjectRepository(t_objProp);
		WebDriverWait wait = new WebDriverWait(driverThread, 10);
		WebElement ClickableWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loctaor)));
		ClickableWebElement.click();		
		}		

/******************************************************************************************************************
	 *	Method             : Click(String t_objProp,String Key, WebDriver driverThread,ExtentTest logger)
	 *  Arguments 		   : t_objProp	
	 *  Return value 	   : 
	 *  Method Description : This method will click on the web element which will be identified based on Key value 
	 *  Date Created       : 10/08/2019
	 *  Author             : Kirti Vikas
	 *
********************************************************************************************************************/
	public  void Click(String t_objProp, String Key, WebDriver driverThread,ExtentTest logger) throws Exception {			
		String Loctaor = GetJsonObjectRepository(t_objProp);
		String LocatorewithKey= Loctaor.replace("KeyValue", Key);
		WebDriverWait wait = new WebDriverWait(driverThread, 10);
		WebElement ClickableWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorewithKey)));
		ClickableWebElement.click();			
		}	
/********************************************************************************************************************
	 *	Method             : GetText(String t_objProp,WebDriver driverThread,ExtentTest logger)
	 *  Arguments 		   : t_objProp	
	 *  Return value 	   : String text 
	 *  Method Description : This method will get Text from a web element   
	 *  Date Created       : 10/08/2019
	 *  Author             : Kirti Vikas
	 *
*********************************************************************************************************************/
	public  String GetTextMethod(String t_objProp,WebDriver driverThread,ExtentTest logger) throws Exception {
		String Loctaor = GetJsonObjectRepository(t_objProp);
		WebDriverWait wait = new WebDriverWait(driverThread, 10);
		WebElement WebElementText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Loctaor)));
		String WebElementTextString = WebElementText.getText();		
		return WebElementTextString;				
	}
	
}
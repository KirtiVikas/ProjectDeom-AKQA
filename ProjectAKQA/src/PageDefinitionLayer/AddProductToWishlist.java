package PageDefinitionLayer;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import CommonFunctionality.UserActions;


public class AddProductToWishlist extends UserActions{
	
/*****************************************************************************************************************************************
	 *	Method            : SelectRandomProduct(String URL,WebDriver driverThread,ExtentTest logger)
	 *  Arguments 		  :	
	 *  Return value 	  : 
	 *  Method Description: This method will select first product (as requirement is not for a specific product, its for random)from page
	 * Date Created       : 10/08/2019
	 * Author             : Kirti Vikas
	 *
*****************************************************************************************************************************************/
	public void SelectProduct(String ProductNameSelected, WebDriver driverThread, ExtentTest logger) throws Exception {

		// Click("ProductTitle_Link_Xpath",driverThread,logger);
		Click("ProductTitle_Link_Xpath", ProductNameSelected, driverThread, logger);
		logger.log(LogStatus.INFO, "Product selected : " + ProductNameSelected);

	}
	
/*******************************************************************************************************************************************************
	 *	Method            : GetProductTitleAndAddToWishlist(String URL,WebDriver driverThread,ExtentTest logger)
	 *  Arguments 		  :	
	 *  Return value 	  : boolean value as true if product is added otherwise false.
	 *  Method Description: This method add a random product to wishlist and confirm product is added
	 * Date Created       : 10/08/2019
	 * Author             : Kirti Vikas
	 *
********************************************************************************************************************************************************/
	public void GetProductTitleAndAddToWishlist(WebDriver driverThread, ExtentTest logger) throws Exception {

		String ProductName = GetTextMethod("ProductName_Text_Xpath", driverThread, logger);
		logger.log(LogStatus.INFO, "Product to be added to wishlist  : " + ProductName);
		Click("AddWishList_Button_Xpath", driverThread, logger);
		String Status = GetTextMethod("AddedtoWishlist_Text_Xpath", driverThread, logger);
		if (Status.equalsIgnoreCase("Added")) {
			logger.log(LogStatus.INFO, "Add to Wishlist button clicked successfully");
		} else {
			logger.log(LogStatus.FAIL,
					"Add to Wishlist button clicked unsuccessfully test may fail please increase explicite wait time");
		}
	}

	/***************************************************************************************************************************************************
	 *	Method            : GetProductFromWishlist(WebDriver driverThread,ExtentTest logger)
	 *  Arguments 		  :	
	 *  Return value 	  : 
	 *  Method Description: This method will navigate to wishlist and verify product is added in
	 * Date Created       : 10/08/2019
	 * Author             : Kirti Vikas
	 *
********************************************************************************************************************************************************/
	public String GetProductFromWishlist(WebDriver driverThread, ExtentTest logger) throws Exception {
		Click("AddWishList_Link_Xpath", driverThread, logger);
		String ProductNameFromWishlist = GetTextMethod("GetProduct_Text_Xpath", driverThread, logger);
		return ProductNameFromWishlist;

	}
}

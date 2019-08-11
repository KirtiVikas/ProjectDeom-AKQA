package TestDefinistionLayer;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import CommonFunctionality.UserActions;
import PageDefinitionLayer.AddProductToWishlist;

public class TestCase_AddProductInWishlist extends UserActions {
	public ExtentReports reporter;
	public ExtentTest logger;
	AddProductToWishlist Obj = new AddProductToWishlist();
	@Test
	public void AddProductInWishlist() throws Exception {
		WebDriver driverThread = null;
		Testcasename = "AddProductInWishlist";
		String URL = GetJsonTestData("Url");
		String Reportpath = GetJsonTestData("Reportpath");
		String ProductName = GetJsonTestData("ProductName");
		reporter = new ExtentReports(Reportpath, true);
		ExtentTest logger = reporter.startTest(Testcasename, " To verify a random product is added to wishlist ");
		reporter.config().reportName("Automation Report");
		
		try {
			/*******************************************************************************************************
			 * Open Chrome Browser and access given URL
			 *******************************************************************************************************/
			driverThread = OpenChromeBrowser(URL);

			/*******************************************************************************************************
			 * Select a product from Page displayed
			 *******************************************************************************************************/
			Obj.SelectProduct(ProductName, driverThread, logger);

			/*******************************************************************************************************
			 * Get Name of product selected, add product to wishlist and confirm
			 *******************************************************************************************************/
			  Obj.GetProductTitleAndAddToWishlist(driverThread, logger);			 

			/*******************************************************************************************************
			 * Verify Same product is added to Wishlist as selected
			 *******************************************************************************************************/
			String ProductFromWishlist = Obj.GetProductFromWishlist(driverThread, logger);
			if (ProductName.equalsIgnoreCase(ProductFromWishlist)) {

				logger.log(LogStatus.PASS, "Product added successfully to wishlist & Test Passed");

			} else {

				logger.log(LogStatus.FAIL, "Product could not added successfully & Test failed");
				Assert.fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Tc failed  due to an exception" + e.getMessage());
			System.out.println("Tc failed" + e.getMessage());
			Assert.fail();

		} finally {
			driverThread.quit();
			reporter.endTest(logger);
			reporter.flush();
			reporter.close();
		}
	}

}
